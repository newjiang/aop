package demo.jiang.aop.demo.object;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ObjectAspect {
    /**
     * 匹配AOP对象的目标对象为指定类型的方法，即ObjectService的AOP代理对象的方法
     */
    @Pointcut("this(demo.jiang.aop.demo.object.ObjectService)")
    public void matchThis() {
    }

    /**
     * 匹配IObjectService接口的目标对象(不是AOP的代理对象)，即IObjectService实现类
     */
    @Pointcut("this(demo.jiang.aop.demo.object.IObjectService)")
    public void matchTarget() {
    }

    /**
     * 匹配bean的名称为objectService里的方法
     */
    @Pointcut("bean(objectService)")
    public void matchBean() {
    }

    @Before("matchThis()")
    public void matchThisBefore() {
        log.info("{}.matchThisBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchTarget()")
    public void matchTargetBefore() {
        log.info("{}.matchTargetBefore()..", this.getClass().getSimpleName());
    }

    @Before("matchBean()")
    public void matchBeanBefore() {
        log.info("{}.matchBeanBefore()..", this.getClass().getSimpleName());
    }
}
