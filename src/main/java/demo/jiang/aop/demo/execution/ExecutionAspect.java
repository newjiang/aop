package demo.jiang.aop.demo.execution;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 表达式切面，格式：[修饰符] [返回值] [包名] [方法名] [方法参数名] [异常]
 */
@Slf4j
@Aspect
@Component
public class ExecutionAspect {
    /**
     * 只匹配ExecutionService下的alpha的方法
     * 方法是public的
     * 方法是无返回值的
     * 方法是无参的
     * 方法是在demo.jiang.aop.demo.execution.ExecutionService类下的
     */
    @Pointcut("execution(public void demo.jiang.aop.demo.execution.ExecutionService.alpha())")
    public void matchAlpha() {
    }

    @Pointcut("execution(public * demo.jiang.aop..ExecutionService.beta(..))")
    public void matchBeta() {
    }

    @Before("matchAlpha()")
    public void matchAlphaBefore() {
        log.info("{}.matchAlphaBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchBeta()")
    public void matchBetaBefore() {
        log.info("{}.matchBetaBefore()..", this.getClass().getSimpleName());
    }
}
