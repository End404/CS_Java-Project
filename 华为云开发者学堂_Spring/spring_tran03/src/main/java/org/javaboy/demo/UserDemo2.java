package org.javaboy.demo;

import org.javaboy.demo.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDemo2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService2 us2 = ctx.getBean(UserService2.class);
        us2.transfer4();
    }
}
