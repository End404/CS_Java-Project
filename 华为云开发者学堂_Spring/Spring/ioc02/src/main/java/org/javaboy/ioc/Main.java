package org.javaboy.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();

//        2.12 混合配置
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig2.class);
        DataSource ds3 = ctx.getBean("ds", DataSource.class);
        System.out.println("ds3( 2.12 ) = " + ds3);
    }

    private static void m3() {
        // 2.9 xml
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
//        DataSource ds = ctx.getBean(DataSource.class);
//        System.out.println("ds( 2.9 xml ) = " + ds);
//
//        // 	2.10 Bean 的作用域
//        DataSource ds1 = ctx.getBean(DataSource.class);
//        System.out.println(ds==ds1);  //2.10 Bean 的作用域

//        2.11 id 和 name 的区别
        DataSource ds3 = ctx.getBean("ds", DataSource.class);
        System.out.println("ds3( 2.11 ) = " + ds3);
    }

    private static void m2() {
        // 2.9
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(JavaConfing.class);
        ctx.refresh();
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println("ds( 2.9 ) = " + ds);

        DataSource ds2 = ctx.getBean(DataSource.class);
        System.out.println(" 2.10:  ");
        System.out.println(ds==ds2);
    }

    private static void m1() {
        // 2.8
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfing.class);
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        String s = cmd.showCmd();
        System.out.println("s( 2.8 ) = " + s);
    }
}
