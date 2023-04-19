package demo.jiang.aop.demo.within;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 匹配包/类型的切面
 */
@Slf4j
@Aspect
@Component
public class WithinAspect {
    /**
     * 匹配WithinService类里面的所有方法
     */
    @Pointcut("within(demo.jiang.aop.demo.within.WithinService)")
    public void matchType() {
    }

    /**
     * 匹配demo.jiang.aop开头，包命是within结尾的所有类的所有方法
     */
    @Pointcut("within(demo.jiang.aop..within.*)")
    public void matchPackage() {
    }

    @Before("matchType()")
    public void matchTypeBefore() {
        log.info("{}.matchTypeBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchPackage()")
    public void matchPackageBefore() {
        log.info("{}.matchPackageBefore()..", this.getClass().getSimpleName());
    }
}
