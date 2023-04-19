package demo.jiang.aop.theory.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 目标实现类
 */
@Slf4j
public class TargetSubject implements Subject {
    @Override
    public void request() {
        log.info("I am Target Subject.");
    }
}
