package demo.jiang.aop.pertarget;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect("pertarget(target(demo.jiang.aop.pertarget.PretargetService))")
@Scope("prototype")
@Component
@Slf4j
public class PretargetAspect {
    public PretargetAspect() {
        log.error("{}.ProthisAspect() ..", this.getClass().getSimpleName());
    }

    @Pointcut("execution(public void demo.jiang.aop.pertarget.PretargetService.foo())")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void foo() {
        log.info("{}.Before()..", this.getClass().getSimpleName());
    }
}
