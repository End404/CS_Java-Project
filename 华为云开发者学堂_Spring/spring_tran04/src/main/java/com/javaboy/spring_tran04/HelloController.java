package com.javaboy.spring_tran04;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    UserService userService;
    @GetMapping("/hello")
    public void hello() {
        userService.transfer();
    }
}
