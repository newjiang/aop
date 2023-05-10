package demo.jiang.aop.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {
    /**
     * value：指定对象
     * defaultImpl，对应接口是实现类
     */
    @DeclareParents(value = "demo.jiang.aop.introduction.IntroductionService", defaultImpl = IntroductionInterfaceImpl.class)
    private IntroductionInterface introductionInterface;
}
