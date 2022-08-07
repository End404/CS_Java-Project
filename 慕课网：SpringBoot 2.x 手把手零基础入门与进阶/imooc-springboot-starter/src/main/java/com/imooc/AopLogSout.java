package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//3-17 使用AOP监控service执行时间
@Aspect
@Slf4j
@Component
public class AopLogSout {
    /**
     * 环绕通知
     */
    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object printLogTimesOfService(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("正在执行{}.{}",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long exTime = startTime - endTime;

        if (exTime > 3000) {
            log.error("当前执行耗时：{}", exTime);
        } else if (exTime > 2000) {
            log.warn("当前执行耗时：{}", endTime);
        } else {
            log.warn("当前执行耗时：{}", exTime);
        }

        return result;
    }
}
