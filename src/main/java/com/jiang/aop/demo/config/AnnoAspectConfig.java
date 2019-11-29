package com.jiang.aop.demo.config;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 注解匹配
 *
 * @Pointcut("@annotation(com.imooc.anno.AdminOnly) && within(com.imooc..*)")
 * //匹配标注有NeedSecured的类底下的方法 //class级别
 * @Pointcut("@within(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
 * //
 * 在spring context的环境下,二者没有区别
 * @Pointcut("@target(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
 * //匹配传入的参数类标注有Repository注解的方法
 * @Pointcut("@args(com.imooc.anno.NeedSecured) && within(com.imooc..*)")
 */
//@Aspect
//@Component
public class AnnoAspectConfig {

    // @Pointcut("@annotation(com.jiang.aop.demo.anno.AdminOnly) && within(com.jiang.aop..*)") // 匹配方法标注有AdminOnly的注解的方法
    // @Pointcut("@within(com.jiang.aop.demo.anno.NeedSecured) && within(com.jiang.aop..*)")   // 匹配标注有NeedSecured的类及其子类的方法 //runtime级别
    // @Pointcut("@target(com.jiang.aop.demo.anno.NeedSecured) && within(com.jiang.aop..*)")   // 在spring context的环境下与第二个,二者没有区别
    @Pointcut("@args(com.jiang.aop.demo.anno.NeedSecured) && within(com.jiang.aop..*)")        // 匹配传入的参数类标注有NeedSecured注解的方法
    public void matchAnno() {
    }

    @Before("matchAnno()")
    public void before(){
        System.out.println("[切面日志]:注解匹配 === before > 方法之前执行");
    }

}
