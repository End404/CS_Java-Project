
//   3.4 XML 配置 AOP


package org.javaboy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


public class LogAspectXML {


    //前置通知，在目标方法执行前执行
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("（3.2 前置） " + name + "方法开始执行了。 ");
    }

    //后置通知，目标方法之后执行
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("（3.2 后置） " + name + "方法开始结束了。 ");
    }

    //返回通知，可以在该方法中获取目标方法的返回值，如果目标方法的返回值为 void ，则收到 null .
    public void returning(JoinPoint joinPoint, Object r) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法的返回通知： " + r);
    }

    //异常通知，当目标方法抛出异常时，该方法会被触发
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println( name + "方法异常通知：" + e.getMessage());
    }

    //环绕通知，是四种通知的集大成者，核心类似在反射中执行方法
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //这个有点类似于 method.ivnoke 方法，我们可以在这个方法的前后分别添加日志，相当于前置/后置通知
        Object proceed = pjp.proceed();
        return proceed;
    }
}
