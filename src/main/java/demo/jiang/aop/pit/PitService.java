package demo.jiang.aop.pit;

import demo.jiang.aop.context.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * AOP的坑
 */
@Slf4j
@Service
public class PitService {
    /**
     * 带有缓存的查询方法
     * @see org.springframework.cache.aspectj.AnnotationCacheAspect
     */
    @Cacheable(cacheNames = {"cache"})
    public List<String> query() {
        log.info("select from database ...");
        return Arrays.asList("AAA", "BBB", "CCC");
    }

    /**
     * 错误的调用
     */
    public List<String> errorCall() {
        // log.info("errorCall [this] is aop proxy = {}", AopUtils.isAopProxy(this));
        return query();
    }

    /**
     * 正确的调用
     */
    public List<String> correctCall() {
        PitService pitService = ApplicationContextHolder.getContext().getBean(PitService.class);
        // log.info("correctCall [pitService] is aop proxy = {}", AopUtils.isAopProxy(this));
        return pitService.query();
    }

    /**
     * 静态方法，不能代理
     */
    public static void staticMethod() {
        log.info("PitService.staticMethod() ..");
    }

    /**
     * 最终方法，不能代理
     */
    public final void finalMethod() {
        log.info("PitService.finalMethod() ..");
    }

    /**
     * 私有方法，不能代理
     */
    private void privateMethod() {
        log.info("PitService.privateMethod() ..");
    }

    /**
     * 静态方法
     */
    public void executePrivateMethod() {
        PitService service = ApplicationContextHolder.getContext().getBean(PitService.class);
        service.privateMethod();
    }
}
