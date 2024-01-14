package com.neo.helloworld1.service;


import com.neo.helloworld1.hello.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/***
 * 慕课网——Spring Boot 发送邮件
 * 2-2
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Resource
    HelloService helloService;

    @Test
    public void sayHelloTest(){
        helloService.sayHello();
    }
}
