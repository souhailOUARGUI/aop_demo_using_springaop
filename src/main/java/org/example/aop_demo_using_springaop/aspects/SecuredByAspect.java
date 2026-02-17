package org.example.aop_demo_using_springaop.aspects;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecuredByAspect {

    String[] roles();
}
