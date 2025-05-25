package com.spring.chatgptspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor: Mattu
 * @Date: 2025/5/25 16:35
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return helloService.sayHello(name);
    }

}
