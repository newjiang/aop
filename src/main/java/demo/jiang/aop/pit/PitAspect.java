package demo.jiang.aop.pit;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PitAspect {
    /**
     * 匹配静态放法
     */
    @Pointcut("execution(public static void demo.jiang.aop.pit.PitService.staticMethod())")
    public void staticMethod() {
    }

    /**
     * 匹配最终放法
     */
    @Pointcut("execution(public final void demo.jiang.aop.pit.PitService.finalMethod())")
    public void finalMethod() {
    }

    /**
     * 匹配私有放法
     */
    @Pointcut("execution(private void demo.jiang.aop.pit.PitService.private*(..))")
    public void privateMethod() {
    }

    @Before("staticMethod()")
    public void staticMethodBefore() {
        log.info("{}.staticMethodBefore()..", this.getClass().getSimpleName());
    }

    @Before("finalMethod()")
    public void finalMethodBefore() {
        log.info("{}.finalMethodBefore()..", this.getClass().getSimpleName());
    }

    @Before("privateMethod()")
    public void privateMethodBefore() {
        log.info("{}.privateMethodBefore()..", this.getClass().getSimpleName());
    }
}
