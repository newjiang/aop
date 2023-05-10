package demo.jiang.aop.perthis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect("perthis(this(demo.jiang.aop.perthis.IPerthisService))")
@Scope("prototype")
@Component
@Slf4j
public class PerthisAspect {
    public PerthisAspect() {
        log.error("{}.PrethisAspect() ..", this.getClass().getSimpleName());
    }

    @Pointcut("execution(public void demo.jiang.aop.perthis.PerthisService.foo())")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void foo() {
        log.info("{}.Before()..", this.getClass().getSimpleName());
    }
}
