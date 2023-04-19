package demo.jiang.aop.theory.dynamic.jdk;


import demo.jiang.aop.theory.proxy.Subject;
import demo.jiang.aop.theory.proxy.TargetSubject;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        // 设置系统属性，保存生成的文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 类加载器
        ClassLoader classLoader = JdkProxyTest.class.getClassLoader();
        // 接口
        Class[] interfaces = {Subject.class};
        // 代理对象
        JdkProxy invocationHandler = new JdkProxy(new TargetSubject());

        // 生成代理类
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        // 执行方法
        subject.request();

    }
}
