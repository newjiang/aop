package demo.jiang.aop.theory.pattern;

/**
 * 代理类
 */
public class ProxySubject implements ISubject {

    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("ProxySubject.Before");
        try {
            /**
             * 执行实现类的方法
             */
            realSubject.request();
        } catch (Exception e) {
            System.out.println("ProxySubject.Exception:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("ProxySubject.After");
        }
    }
}
