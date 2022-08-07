
//    第四章：JdbcTemplate


package org.javaboy.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
@ComponentScan
public class JdbcTest {
    JdbcTemplate jdbcTemplate;
    private AccountService accountService;

    @Before
    public void before() {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        accountService = ctx.getBean(AccountService.class);
    }

    @Test
    public void test1() {
        jdbcTemplate.update("insert into user (username,address,favorites) value (?,?,?);", "javaboy", "www.javaboy.org", "coding");
    }
    @Test
    public void test2() {
        jdbcTemplate.update("update user set username = ? where  id=?;", "javabouy123", 13);
    }
    @Test
    public void test3(){
        jdbcTemplate.update("delete from user where id=?", 13);
    }
    @Test
    public void test4(){
        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        System.out.println("list = " + list);
    }


//    第5章：事务简介
    @Test
    public void test5() {
        accountService.updateMoney();
    }
}
