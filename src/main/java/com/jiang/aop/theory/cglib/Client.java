package com.jiang.aop.theory.cglib;

import com.jiang.aop.theory.pattern.RealSubject;
import com.jiang.aop.theory.pattern.Subject;
import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();

        subject.hello();
        subject.request();
    }
}
