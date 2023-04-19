package demo.jiang.aop.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注解切面
 */
@Slf4j
@Aspect
@Component
public class AnnotationAspect {
    /**
     * 匹配标注有@MyAnno注解的类底下的方法
     */
    @Pointcut("@annotation(demo.jiang.aop.annotation.MyAnno)")
    public void matchMyAnno() {
    }

    /**
     * 匹配标注有@MyWithin注解的类底下的方法
     * 1.要求@MyWithin注解中的@Retention为RetentionPolicy.CLASS
     */
    @Pointcut("@within(demo.jiang.aop.annotation.MyWithin) && within(demo.jiang.aop..*)")
    public void matchWithin() {
    }

    /**
     * 匹配标注有@MyTarget注解的类底下的方法
     * 要求@MyTarget注解中的@Retention为RetentionPolicy.RUNTIME
     */
    @Pointcut("@target(demo.jiang.aop.annotation.MyTarget) && within(demo.jiang.aop..*)")
    public void matchTarget() {
    }

    /**
     * 匹配传入参数中有@MyArgs注解的方法
     */
    @Pointcut("@args(demo.jiang.aop.annotation.MyArgs) && within(demo.jiang.aop..*)")
    public void matchArgs() {
    }

    @Before("matchMyAnno()")
    public void matchMyAnnoBefore() {
        log.info("{}.matchMyAnnoBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchWithin()")
    public void matchWithinBefore() {
        log.info("{}.matchWithinBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchTarget()")
    public void matchTargetBefore() {
        log.info("{}.matchTargetBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchArgs()")
    public void matchArgsBefore() {
        log.info("{}.matchArgsBefore()..", this.getClass().getSimpleName());
    }
}
