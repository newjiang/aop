package demo.jiang.aop.theory.dynamic.jdk;


import demo.jiang.aop.theory.proxy.TargetSubject;
import org.springframework.aop.framework.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于jdk的动态代理
 * 1.利用java.lang.reflect.Proxy
 * 2.实现java.lang.reflect.InvocationHandler接口
 * 3.只能基于接口进行动态代理
 *  * Spring选择jdk的策略{@link org.springframework.aop.framework.DefaultAopProxyFactory#createAopProxy(AdvisedSupport)}
 */
public class JdkProxy implements InvocationHandler {

    private final TargetSubject subject;

    public JdkProxy(TargetSubject subject) {
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
