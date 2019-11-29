package com.jiang.aop.demo.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * execution表达式
 * //匹配任何公共方法
 * @Pointcut("execution(public * com.imooc.service.*.*(..))")
 * <p>
 * //匹配com.imooc包及子包下Service类中无参方法
 * @Pointcut("execution(* com.imooc..*Service.*())")
 * <p>
 * //匹配com.imooc包及子包下Service类中的任何只有一个参数的方法
 * @Pointcut("execution(* com.imooc..*Service.*(*))")
 * <p>
 * //匹配com.imooc包及子包下任何类的任何方法
 * @Pointcut("execution(* com.imooc..*.*(..))")
 * <p>
 * //匹配com.imooc包及子包下返回值为String的任何方法
 * @Pointcut("execution(String com.imooc..*.*(..))")
 * <p>
 * //匹配异常
 * execution(public * com.imooc.service.*.*(..) throws java.lang.IllegalAccessException)
 */
//@Aspect
//@Component
public class ExecutionAspectConfig {

    @Pointcut("execution(public * com.jiang.aop.demo.service.*.*(..))")//匹配任何公共方法
    public void matchCondition() {
    }

    @Before("matchCondition()")
    public void before() {
        System.out.println("[切面日志]:Execution表达式 === before > 方法之前执行");
    }
}
