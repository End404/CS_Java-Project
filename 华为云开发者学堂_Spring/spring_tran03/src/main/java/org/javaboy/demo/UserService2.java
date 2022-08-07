
// 第2章 事务的两种实现方式


package org.javaboy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;


@Component
public class UserService2 {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    PlatformTransactionManager transactionManager;

    //    2.4 Java+配置声明式事务
    @Transactional
    public void transfer4() {
        jdbcTemplate.update("update user set money = ? where username=?", 99, "zahngsan");
//        int i = 1 / 0;
    }

}
