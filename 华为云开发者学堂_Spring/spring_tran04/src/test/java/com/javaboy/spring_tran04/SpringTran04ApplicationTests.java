package com.javaboy.spring_tran04;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTran04ApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.transfer();
    }

}
