package demo.jiang.aop.demo.args;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 参数服务切面
 */
@Slf4j
@Aspect
@Component
public class ArgsAspect {
    /**
     * 1.匹配任何以find开头的方法
     * 2.匹配findXxx()的参数是任意的
     * 3.匹配是demo.jiang.aop下的
     */
    @Pointcut("execution(* *..find*(..)) && within(demo.jiang.aop..*)")
    public void findAny() {
    }

    /**
     * 1.匹配只有Long参数的方法
     * 2.匹配是demo.jiang.aop包下的
     */
    @Pointcut("args(Long) && within(demo.jiang.aop..*)")
    public void onlyLong() {
    }

    /**
     * 1.匹配delete开头和第一个参数是Long的方法
     * 2.匹配deleteXxx()的放法，第一个参数是long类型的
     * 3.匹配是demo.jiang.aop包下的
     */
    @Pointcut("execution(* *..delete*(Long,..)) && within(demo.jiang.aop..*)")
    public void startsWithdeleteAndFirstParamTypeIsLong() {
    }

    @Before("findAny()")
    public void findAnyBefore() {
        log.info("{}.findAnyBefore()..", this.getClass().getSimpleName());
    }

    @Before("onlyLong()")
    public void onlyLongBefore() {
        log.info("{}.onlyLongBefore()..", this.getClass().getSimpleName());
    }

    @Before("startsWithdeleteAndFirstParamTypeIsLong()")
    public void startsWithdeleteAndFirstParamTypeIsLongBefore() {
        log.info("{}.startsWithdeleteAndFirstParamTypeIsLongBefore()..", this.getClass().getSimpleName());
    }
}
