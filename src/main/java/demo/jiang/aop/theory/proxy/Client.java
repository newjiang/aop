package demo.jiang.aop.theory.proxy;

/**
 * 代理模式测试类
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject(new TargetSubject());
        subject.request();
    }
}
