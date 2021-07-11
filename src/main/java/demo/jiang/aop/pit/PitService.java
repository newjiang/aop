package demo.jiang.aop.pit;

import demo.jiang.aop.code.context.ApplicationContextHolder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AOP的坑
 */
@Service
public class PitService {

    /**
     * 带有缓存的查询方法
     */
    @Cacheable(cacheNames = {"cache"})
    public List<String> query() {
        System.out.println("select from database");
        return Arrays.asList("AAA", "BBB", "CCC");
    }

    /**
     * 错误的调用
     */
    public List<String> errorCall() {
        return query();
    }

    /**
     * 正确的调用
     */
    public List<String> correctCall() {
        PitService bean = ApplicationContextHolder.getContext().getBean(PitService.class);
        return bean.query();
    }


    /**
     * 静态方法
     */
    public static void staticMethod() {
        System.out.println("execute static method ..");
    }

    /**
     * 最终方法
     */
    public final void finalMethod() {
        System.out.println("execute final method ..");
    }

    /**
     * 私有方法
     */
    private void privateMethod() {
        System.out.println("execute private method ..");
    }

    /**
     * 静态方法
     */
    public void executePrivateMethod() {
        PitService bean = ApplicationContextHolder.getContext().getBean(PitService.class);
        bean.privateMethod();
    }
}
