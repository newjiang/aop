package demo.jiang.aop.theory.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 代理类
 */
@Slf4j
public class ProxySubject implements Subject {
    private final TargetSubject targetSubject;

    public ProxySubject(TargetSubject realTargetSubject) {
        this.targetSubject = realTargetSubject;
    }

    @Override
    public void request() {
        log.info("I am Proxy Subject.. Before..");
        try {
            targetSubject.request(); // 执行实现类的方法
        } catch (Exception e) {
            log.info("I am Proxy Subject.. Exception:", e);
            throw e;
        } finally {
            log.info("I am Proxy Subject.. After..");
        }
    }
}
