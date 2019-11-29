package com.jiang.aop.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 例子：Advice
 */
//@Aspect
//@Component
public class AdviceAspectConfig {

    /******pointcut********/

    @Pointcut("@annotation(com.jiang.aop.demo.anno.AdminOnly) && within(com.jiang.aop..*)")
    public void matchAnno(){}

    @Pointcut("execution(* *..find*(Long)) && within(com.jiang.aop..*) ")
    public void matchLongArg(){}

    @Pointcut("execution(public * com.jiang.aop.demo.service..*Service.*(..) throws java.lang.IllegalAccessException) && within(com.jiang.aop..*)")
    public void matchException(){}

    @Pointcut("execution(String com.jiang.aop..*.*(..)) && within(com.jiang.aop..*)")
    public void matchReturn(){}

    @Before("matchLongArg() && args(productId)")
    public void before(Long productId) {
        System.out.println("###before,get args:" + productId);
    }

    @Around("matchException()")
    public java.lang.Object after(ProceedingJoinPoint joinPoint){
        System.out.println("###before");
        java.lang.Object result = null;
        try{
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("###after returning");
        }catch (Throwable e){
            System.out.println("###ex");
            //throw
            e.printStackTrace();
        }finally {
            System.out.println("###finally");
        }
        return result;
    }

}
