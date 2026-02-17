package org.example.aop_demo_using_springaop;

import org.example.aop_demo_using_springaop.aspects.SecurityContext;
import org.example.aop_demo_using_springaop.metier.IMetier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AopDemoUsingSpringaopApplication {

    public static void main(String[] args) {
        SecurityContext.authenticate("root", "1234", new String[]{"USER"});
        ApplicationContext  context = new AnnotationConfigApplicationContext(AopDemoUsingSpringaopApplication.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println(metier.compute());

    }

}
