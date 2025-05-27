package com.spring.chatgptspring.Exception;

/**
 * @Autor: Mattu
 * @Date: 2025/5/27 15:55
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
