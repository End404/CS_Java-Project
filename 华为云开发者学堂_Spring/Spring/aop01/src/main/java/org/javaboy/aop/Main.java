package org.javaboy.aop;

public class Main {
    public static void main(String[] args) {

        //    3.1 AOP简介及基于JDK动态代理实现的AOP
        MyCalculatorImpl myCalculator = new MyCalculatorImpl();
        MyCalculator calculator = (MyCalculator) CalculatorProxy.getInstance(myCalculator);
        int add = calculator.add(3, 4);
        System.out.println("add( 3.1 ) = " + add);
    }
}
