package demo.jiang.aop.demo.within;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 匹配包/类型的切莫
 */
@Aspect
@Component
public class WithinAspect {

    // 匹配WithinService类里面的所有方法
    @Pointcut("within(demo.jiang.aop.demo.within.WithinService)")
    public void matchType() {
    }

    // 匹配demo.jiang.aop开头，within结尾的所有类的所有方法
    @Pointcut("within(demo.jiang.aop..within.*)")
    public void matchPackage() {
    }

    @Before("matchType()")
    public void matchTypeTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("WithinAspect.matchType: " + name);
    }

    @Before("matchPackage()")
    public void matchPackageTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("WithinAspect.matchPackage: " + name);
    }

}
