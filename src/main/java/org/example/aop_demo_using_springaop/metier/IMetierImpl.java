package org.example.aop_demo_using_springaop.metier;


import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier
{
    @Override
    public void process() {
        System.out.println("Biz Logic");
    }

    @Override
    public double compute() {
        double data= 80;
        System.out.println("Biz Computing and returning result !");
        return data;
    }

}
