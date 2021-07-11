package demo.jiang.aop.theory.pattern;

/**
 * 实现类
 */
public class Subject implements ISubject {

    @Override
    public void request() {
        System.out.println("Subject execute request");
    }

}
