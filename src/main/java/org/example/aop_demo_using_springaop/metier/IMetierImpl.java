package org.example.aop_demo_using_springaop.metier;


import jakarta.servlet.annotation.ServletSecurity;
import org.example.aop_demo_using_springaop.aspects.Log;
import org.example.aop_demo_using_springaop.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier
{
    @Log
    @SecuredByAspect(roles={"ADMIN","USER"})
    @Override
    public void process() {
        System.out.println("Biz Logic");
    }


    @Log
    @SecuredByAspect(roles = {"ADMIN"})
    @Override
    public double compute() {
        double data= 80;
        System.out.println("Biz Computing and returning result !");
        return data;
    }

}
