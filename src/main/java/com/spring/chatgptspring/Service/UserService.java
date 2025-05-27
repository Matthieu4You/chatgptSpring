package com.spring.chatgptspring.Service;

import com.spring.chatgptspring.Exception.UserNotFoundException;
import com.spring.chatgptspring.Model.User;
import com.spring.chatgptspring.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Autor: Mattu
 * @Date: 2025/5/26 10:09
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("用户未找到"+id)); // 或抛异常，自定义返回404等
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

}
