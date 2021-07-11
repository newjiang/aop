package demo.jiang.aop.demo.param;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParamAspect {

    // 匹配任何以find开头的方法 且 匹配是demo.jiang.aop包下的
    @Pointcut("execution(* *..find*(..)) && within(demo.jiang.aop..*)")
    public void findAny() {
    }

    // 匹配只有Long参数的方法 且 匹配是demo.jiang.aop包下的
    @Pointcut("args(Long) && within(demo.jiang.aop..*)")
    public void onlyLong() {
    }

    // 匹配delete开头和第一个参数是Long的方法 且 匹配是demo.jiang.aop包下的
    @Pointcut("execution(* *..delete*(Long,..)) && within(demo.jiang.aop..*)")
    public void findAndLongStart() {
    }

    @Before("findAny()")
    public void findAnyTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ParamAspect.findAny: " + name);
    }

    @Before("onlyLong()")
    public void onlyLongTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ParamAspect.onlyLong: " + name);
    }

    @Before("findAndLongStart()")
    public void findAndLongStartTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ParamAspect.findAndLongStart: " + name);
    }
}
