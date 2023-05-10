package demo.jiang.aop.introduction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntroductionInterfaceImpl implements IntroductionInterface {
    @Override
    public void request() {
        log.info("{}.request() ..", this.getClass().getSimpleName());
    }
}
