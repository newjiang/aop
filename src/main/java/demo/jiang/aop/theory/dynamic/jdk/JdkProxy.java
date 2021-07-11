package demo.jiang.aop.theory.dynamic.jdk;


import demo.jiang.aop.theory.pattern.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于jdk的动态代理
 * 1.利用java.lang.reflect.Proxy
 * 2.实现java.lang.reflect.InvocationHandler接口
 * 3.只能基于接口进行动态代理
 */
public class JdkProxy implements InvocationHandler {

    private Subject subject;

    public JdkProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkProxy.Before");
        Object result;
        try {
            result = method.invoke(subject, args);
        } catch (Exception e) {
            System.out.println("JdkProxy.Exception:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("JdkProxy.After");
        }
        return result;
    }
}
