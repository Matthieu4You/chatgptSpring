package com.spring.chatgptspring;

import org.springframework.stereotype.Service;

/**
 * @Autor: Mattu
 * @Date: 2025/5/25 16:34
 */
@Service
public class HelloService {

    public String sayHello(String name) {
        return "Hello "+name;
    }

}
