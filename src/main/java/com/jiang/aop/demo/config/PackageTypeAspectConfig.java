package com.jiang.aop.demo.config;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 例子一：
 * within表达式,匹配包/类型
 */
//@Aspect
//@Component
public class PackageTypeAspectConfig {

    @Pointcut("within(com.jiang.aop.demo.service..*)")             // 匹配com.jiang.aop.demo.service包及子包下所有类的方法
    // @Pointcut("within(com.jiang.aop.demo.service.TestService)") // 匹配com.jiang.aop.demo.service包下所有类的方法
    public void matchType() {
    }

    @Before("matchType()")
    public void before() {
        System.out.println("[切面日志]:within表达式,匹配包/类型 === before>方法之前执行");
    }
}
