package demo.jiang.aop.demo.within;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 匹配包/类型的切莫
 */
@Slf4j
@Service
public class WithinService {
    /**
     * alpha
     *
     * @return alpha
     */
    public String alpha() {
        log.info("{}.alpha ..", this.getClass().getSimpleName());
        return "alpha";
    }

    /**
     * beta
     *
     * @return beta
     */
    public String beta() {
        log.info("{}.beta ..", this.getClass().getSimpleName());
        return "beta";
    }
}
