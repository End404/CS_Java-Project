package org.javaboy.ioc;

import org.javaboy.ioc.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        m1(ctx);
//        m2(ctx);
//        m3(ctx);
        User u4 = ctx.getBean("user4", User.class);
        System.out.println(u4);
    }

    private static void m3(ClassPathXmlApplicationContext ctx) {
        //工厂注入
        User u3 = ctx.getBean("user3", User.class);
        System.out.println("u3 = " + u3);
    }

    private static void m1( ClassPathXmlApplicationContext ctx ) {
        //构造方法注入
        User user = (User) ctx.getBean("user");
        User user1 = ctx.getBean("user", User.class);
        User user2 = ctx.getBean(User.class);
        System.out.println("user = " + user);
        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);
    }

    private static void m2( ClassPathXmlApplicationContext ctx ) {
        //第二种方法属性注入
        User u2 = ctx.getBean("user2", User.class);
        System.out.println("u2 = " + u2);
    }

}
