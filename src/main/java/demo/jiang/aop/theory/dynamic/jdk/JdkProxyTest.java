package demo.jiang.aop.theory.dynamic.jdk;


import demo.jiang.aop.theory.pattern.ISubject;
import demo.jiang.aop.theory.pattern.Subject;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        // 设置系统属性，保存生成的文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 类加载器
        ClassLoader classLoader = JdkProxyTest.class.getClassLoader();
        // 接口
        Class[] interfaces = {ISubject.class};
        // 代理对象
        JdkProxy invocationHandler = new JdkProxy(new Subject());

        // 生成代理类
        ISubject subject = (ISubject) Proxy.newProxyInstance(
                classLoader, interfaces, invocationHandler);

        // 执行方法
        subject.request();

    }
}
