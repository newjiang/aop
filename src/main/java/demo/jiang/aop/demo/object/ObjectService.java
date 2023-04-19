package demo.jiang.aop.demo.object;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 对象服务的实现
 */
@Slf4j
@Service
public class ObjectService implements IObjectService {
    @Override
    public String alpha() {
        log.info("{}.alpha ..", this.getClass().getSimpleName());
        return "alpha";
    }

    @Override
    public String beta() {
        log.info("{}.beta ..", this.getClass().getSimpleName());
        return "beta";
    }
}
