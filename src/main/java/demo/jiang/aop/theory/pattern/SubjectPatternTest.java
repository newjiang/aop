package demo.jiang.aop.theory.pattern;

/**
 * 代理模式测试类
 * 该模式属于静态代理
 * 缺点：
 *
 */
public class SubjectPatternTest {

    public static void main(String[] args) {
        ISubject subject = new ProxySubject(new Subject());
        subject.request();
    }
}
