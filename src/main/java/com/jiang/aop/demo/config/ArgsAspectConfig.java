package com.jiang.aop.demo.config;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 例子三：参数匹配
 */
//@Aspect
//@Component
public class ArgsAspectConfig {

    @Pointcut("args(int,String) && within(com.jiang.aop.demo.service.TestService)") // 匹配TestService方法中，只有两个参数，第一个参数是int,第二个参数是String
    // @Pointcut("execution(* *..find*(int))")                 // 匹配任何以find开头而且只有一个int参数的方法
    // @Pointcut("within(com.jiang.aop.demo..*) && args(int)") // 匹配任何只有一个int参数的方法
    // @Pointcut("within(com.jiang.aop..*) && args(int,..)")   // 匹配第一个参数为Long型的方法
    public void matchArgs() {
    }

    @Before("matchArgs()")
    public void before() {
        System.out.println("[切面日志]:参数匹配 === before > 方法之前执行");
    }
}
