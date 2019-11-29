package com.jiang.aop.demo.config;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 例子二:对象匹配
 *
 *
 * @Pointcut("this(com.imooc.log.Loggable)")
 * //
 *
 * @Pointcut("target(com.imooc.log.Loggable)")
 * //this 可以拦截 DeclareParents(Introduction)
 * //target 不拦截 DeclareParents(Introduction)
 * //匹配所有以Service结尾的bean里头的方法
 *
 * @Pointcut("bean(*Service)")
 * Created by cat on 2016-12-04.
 *
 */
//@Aspect
//@Component
public class ObjectAspectConfig {

    // @Pointcut("this(com.jiang.aop.demo.log.Loggable)") // 匹配实现Loggable接口的目标对象(而不是aop代理后的对象)的方法
    // @Pointcut("this(com.jiang.aop.demo.log.Loggable)") // 匹配AOP对象的目标对象为指定类型的方法,即LogService的aop代理对象的方法
    @Pointcut("bean(logService)") // 匹配logService的bean里头的方法
    public void matchCondition(){}

    @Before("matchCondition()")
    public void before(){
        System.out.println("[切面日志]:对象匹配 === before > 方法之前执行");
    }
}
