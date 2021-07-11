package demo.jiang.aop.demo.object;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObjectAspect {

    // 匹配AOP对象的目标对象为指定类型的方法，即ObjectService的AOP代理对象的方法
    @Pointcut("this(demo.jiang.aop.demo.object.ObjectService)")
    public void matchThis() {
    }

    // 匹配IObjectService接口的目标对象(不是AOP的代理对象)，即IObjectService实现类
    @Pointcut("this(demo.jiang.aop.demo.object.IObjectService)")
    public void matchTarget() {
    }

    // 匹配bean的名称为objectService里的方法
    @Pointcut("bean(objectService)")
    public void matchBean() {
    }

    @Before("matchThis()")
    public void matchPackageTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ObjectAspect.matchThis: " + name);
    }

    @Before("matchTarget()")
    public void matchTargetTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ObjectAspect.matchTarget: " + name);
    }

    @Before("matchBean()")
    public void matchBeanTest(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toShortString();
        System.out.println("ObjectAspect.matchBean: " + name);
    }


}
