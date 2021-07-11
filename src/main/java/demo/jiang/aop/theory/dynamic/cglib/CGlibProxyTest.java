package demo.jiang.aop.theory.dynamic.cglib;


import demo.jiang.aop.theory.pattern.ISubject;
import demo.jiang.aop.theory.pattern.Subject;
import net.sf.cglib.proxy.Enhancer;

public class CGlibProxyTest {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Subject.class);
        enhancer.setCallback(new CGlibProxy());
        ISubject subject = (ISubject) enhancer.create();

        subject.request();
    }
}
