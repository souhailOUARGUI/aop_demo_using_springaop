package org.example.aop_demo_using_springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@EnableAspectJAutoProxy
@Aspect
public class LoggingAspect {
    @Around("@annotation(org.example.aop_demo_using_springaop.aspects.Log)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1= System.currentTimeMillis();
        System.out.println("From Logging Aspect : Before method "+proceedingJoinPoint.getSignature());
        Object o= proceedingJoinPoint.proceed();
        long t2 = System.currentTimeMillis();
        System.out.println("From Logging Aspect : After method "+proceedingJoinPoint.getSignature());
        System.out.println("from Logging Aspect : Duration :"+ (t2-t1));
        return o;
    }

}
