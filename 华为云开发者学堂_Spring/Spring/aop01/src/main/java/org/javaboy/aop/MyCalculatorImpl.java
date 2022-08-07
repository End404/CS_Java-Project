
//    3.1 AOP简介及基于JDK动态代理实现的AOP


package org.javaboy.aop;

public class MyCalculatorImpl implements MyCalculator{
    public int add(int a, int b) {
        return a + b;
    }
}
