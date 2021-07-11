package demo.jiang.aop.demo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

    /**
     * 匹配标注有@Admin注解的类底下的方法
     */
    @Pointcut("@annotation(demo.jiang.aop.code.annotation.MyAnno)")
    public void matchMyAnno() {
    }

    /**
     * 匹配标注有@MyWithin注解的类底下的方法
     * 要求@MyWithin注解中的@Retention为RetentionPolicy.CLASS
     */
    @Pointcut("@within(demo.jiang.aop.code.annotation.MyWithin) && within(demo.jiang.aop..*)")
    public void matchWithin() {
    }

    /**
     * 匹配标注有@MyTarget注解的类底下的方法
     * 要求@MyTarget注解中的@Retention为RetentionPolicy.RUNTIME
     */
    @Pointcut("@target(demo.jiang.aop.code.annotation.MyTarget) && within(demo.jiang.aop..*)")
    public void matchTarget() {
    }

    /**
     * 匹配传入参数中有@MyArgs注解的方法
     */
    @Pointcut("@args(demo.jiang.aop.code.annotation.MyArgs) && within(demo.jiang.aop..*)")
    public void matchArgs() {
    }

    @Before("matchMyAnno()")
    public void matchMyAnnoTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("AnnotationAspect.matchMyAnno: " + name);
    }

    @Before("matchWithin()")
    public void matchWithinTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("AnnotationAspect.matchWithin: " + name);
    }

    @Before("matchTarget()")
    public void matchTargetTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("AnnotationAspect.matchTarget: " + name);
    }

    @Before("matchArgs()")
    public void matchArgsTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("AnnotationAspect.matchArgs: " + name);
    }
}
