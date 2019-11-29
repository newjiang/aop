package com.jiang.aop.theory.dynamic;


import com.jiang.aop.theory.pattern.RealSubject;
import com.jiang.aop.theory.pattern.Subject;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = (Subject) Proxy.newProxyInstance(
                        Client.class.getClassLoader(),
                        new Class[]{Subject.class},
                        new JdkProxySubject(new RealSubject()));
        subject.hello();
    }
}
