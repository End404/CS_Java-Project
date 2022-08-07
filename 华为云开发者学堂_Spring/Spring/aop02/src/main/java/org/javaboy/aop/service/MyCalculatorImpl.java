
//  3.2 AOP

package org.javaboy.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyCalculatorImpl implements MyCalculator{
//    @Action     //注解（侵入式）
    @Override
    public Integer add(int a, int b) {
//        int i = 1 / 0;
        System.out.println(a + "+" + b + "=" + (a+b));
        return a + b;
    }

//    @Action
    @Override
    public void min(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a-b));
    }
}
