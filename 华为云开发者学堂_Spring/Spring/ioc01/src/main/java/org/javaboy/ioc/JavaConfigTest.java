
/*
 * 2.5 Java配置
 */

package org.javaboy.ioc;

import org.javaboy.ioc.javaconfig.JavaConfig;
import org.javaboy.ioc.javaconfig.SayHello;
import org.javaboy.ioc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JavaConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        SayHello sayHello = ctx.getBean("sh", SayHello.class);
        System.out.println("sayHello( 2.5 ) = " + sayHello.sayHello("javaboy"));

        // 2.6 自动配置
        UserService userService = ctx.getBean(UserService.class);
        List<String> allUsers = userService.getAllUsers();
        System.out.println("allUsers( 2.6 ) = " + allUsers);

    }
}
