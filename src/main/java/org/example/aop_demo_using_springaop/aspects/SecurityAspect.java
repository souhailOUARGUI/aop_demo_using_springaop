package org.example.aop_demo_using_springaop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect securedByAspect) throws Throwable {

        System.out.println("*************************************Security Aspect************************************************");
        String[] roles= securedByAspect.roles();
        boolean authorized= false;
        for (String r:roles){
            if (SecurityContext.hasRole(r)){
                authorized=true;
                break;
            }
        }

        if (authorized){
            Object o = proceedingJoinPoint.proceed();
            return o;
        }else throw new RuntimeException("Not Authorized !!");
    }

}
