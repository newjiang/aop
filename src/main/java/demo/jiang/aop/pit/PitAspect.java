package demo.jiang.aop.pit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PitAspect {

    @Pointcut("execution(public static void demo.jiang.aop.pit.PitService.staticMethod())")
    public void staticMethod() {
    }

    @Pointcut("execution(public final void demo.jiang.aop.pit.PitService.finalMethod())")
    public void finalMethod() {
    }

    @Pointcut("execution(private void demo.jiang.aop.pit.PitService.private*(..))")
    public void privateMethod() {
    }

    @Before("staticMethod()")
    public void staticMethodTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("PitAspect.staticMethod: " + name);
    }

    @Before("finalMethod()")
    public void finalMethodTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("PitAspect.finalMethod: " + name);
    }

    @Before("privateMethod()")
    public void privateMethodTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("PitAspect.privateMethod: " + name);
    }
}
