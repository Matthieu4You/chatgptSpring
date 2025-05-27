package com.spring.chatgptspring.Config.Converter;

import com.spring.chatgptspring.Model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Autor: Mattu
 * @Date: 2025/5/27 20:17
 */
public class FooMessageConverter implements HttpMessageConverter<User> {
    private static final MediaType FOO_MEDIA_TYPE = MediaType.parseMediaType("application/x-foo");

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz == User.class && (mediaType == null || FOO_MEDIA_TYPE.includes(mediaType));
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz == User.class && (mediaType == null || FOO_MEDIA_TYPE.includes(mediaType));
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(FOO_MEDIA_TYPE);
    }

    @Override
    public User read(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException {
        String body = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        String[] parts = body.split(";");
        int id = Integer.parseInt(parts[0].split("=")[1]);
        String name = parts[1].split("=")[1];
        String email = parts[2].split("=")[1];
        return new User(id, name, email);
    }

    @Override
    public void write(User user, MediaType contentType, HttpOutputMessage outputMessage) throws IOException {
        String output = "id=" + user.getId() + ";name=" + user.getName();
        outputMessage.getHeaders().setContentType(FOO_MEDIA_TYPE);
        outputMessage.getBody().write(output.getBytes(StandardCharsets.UTF_8));
    }
}
