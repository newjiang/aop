package demo.jiang.aop.theory.dynamic.cglib;

import demo.jiang.aop.theory.proxy.Subject;
import demo.jiang.aop.theory.proxy.TargetSubject;
import net.sf.cglib.proxy.Enhancer;

public class CGlibProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetSubject.class);
        enhancer.setCallback(new CGlibProxy());
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }
}
