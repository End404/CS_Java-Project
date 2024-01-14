package com.neo.helloworld1.hello;

/***
 * 慕课网——Spring Boot 发送邮件
 * 2-2
 */


import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void sayHello(){
        System.out.println("Hello world");
    }
}
