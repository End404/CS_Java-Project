package com.javaboy.spring_tran04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserService2 userService2;

    @Transactional(rollbackFor = IOException.class, readOnly = true, timeout = 3000)    // 3.9 Spring事务回滚规则; 3.10 Spring事务只读属性; 3.11 Spring事务超时时间
    public void transfer() throws IOException {
        jdbcTemplate.update("update user set money = ? where username=?;", 1000, "zhangshan");
        throw new IOException();    // 3.9 Spring事务回滚规则
        //        userService2.update();
//        int i = 0;  //抛个异常
    }
}
