package com.spring.chatgptspring.Config;

import com.spring.chatgptspring.Config.Converter.FooMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Autor: Mattu
 * @Date: 2025/5/27 20:15
 */
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FooMessageConverter());
    }


}
