package demo.jiang.aop.theory.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib代理是基于继承来实现的
 * 无法对象static，final，private类和方法，进行代理
 */
public class CGlibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CGlibProxy.before");
        Object result;
        try {
            result = proxy.invokeSuper(obj, args);
        } catch (Exception e) {
            System.out.println("CGlibProxy.Exception:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("CGlibProxy.After");
        }
        return result;
    }

}
