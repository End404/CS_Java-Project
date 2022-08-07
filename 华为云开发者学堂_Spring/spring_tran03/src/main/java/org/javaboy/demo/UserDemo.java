// 第2章 事务的两种实现方式
// 2.1 PlatformTransactionManager+实现编程式事务


package org.javaboy.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDemo {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        2.5 Java+XML混合配置声明式事务
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService us = ctx.getBean(UserService.class);
//        us.transfer();
//        us.transfer2();
        us.transfer3();
    }
}
