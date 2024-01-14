package com.javaboy.springsecuritydemo01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  云享读书会：深入浅出 Spring Security
 *      DAY02. Spring Security 认证流程分析
 */


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello spring security!";
    }
}
