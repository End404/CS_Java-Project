package com.javaboy.spring_tran04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//Spring事务传播性之REQUIRED

@Service
public class UserService2 {
    @Autowired
    JdbcTemplate jdbcTemplate;
//    @Transactional(propagation = Propagation.REQUIRES_NEW)      //3.3 Spring事务传播性之REQUIRES_NEW
//    @Transactional(propagation = Propagation.NESTED)    //3.4 Spring事务传播性之REQUIRES_NEW
//    @Transactional(propagation = Propagation.MANDATORY)   //3.5
//    @Transactional(propagation = Propagation.SUPPORTS)    //3.6
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)    //3.7
    @Transactional(propagation = Propagation.NEVER)     //3.8
    public void update() {
        jdbcTemplate.update("update user set money = ? where username=?;", 1000, "lisi");
//        int i = 1 / 0;



    }
}
