package org.javaboy.aop;

import org.javaboy.aop.service.MyCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LogAspectXML.class);
        MyCalculator calcuator = ctx.getBean(MyCalculator.class);
        calcuator.add(3,4);
        calcuator.min(3,4);
    }
}
