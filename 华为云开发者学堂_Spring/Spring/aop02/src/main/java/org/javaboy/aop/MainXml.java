package org.javaboy.aop;

import org.javaboy.aop.service.MyCalculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator calculator = ctx.getBean(MyCalculator.class);
        calculator.add(6,7);
        calculator.min(6,7);
    }
}
