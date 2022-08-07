
//  第5章：事务简介


package org.javaboy.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Transactional
    public void updateMoney() {
        jdbcTemplate.update("update account set money=money-500 where username=?", "zhangsan");
        int i = 1 / 0;  //假设这是个失误
        jdbcTemplate.update("update account set money=money+500 where username=?", "lisi");
    }
}
