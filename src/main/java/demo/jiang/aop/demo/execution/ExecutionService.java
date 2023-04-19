package demo.jiang.aop.demo.execution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExecutionService {
    /**
     * alpha
     */
    public void alpha() {
        log.info("{}.alpha() ..", this.getClass().getSimpleName());
    }

    /**
     * beta
     */
    public void beta() {
        log.info("{}.beta() ..", this.getClass().getSimpleName());
    }

    /**
     * beta
     *
     * @param param String
     * @return String
     */
    public String beta(String param) {
        log.info("{}.beta(param = {}) ..", this.getClass().getSimpleName(), param);
        return param;
    }

    /**
     * beta
     *
     * @param param Integer
     * @return Integer
     */
    public Integer beta(Integer param) {
        log.info("{}.beta(param = {}) ..", this.getClass().getSimpleName(), param);
        return param;
    }

    /**
     * beta
     *
     * @param param1 String
     * @param param2 Integer
     * @return Long
     */
    public Long beta(String param1, Integer param2) {
        log.info("{}.beta(param1 = {}, param2 = {}) ..", this.getClass().getSimpleName(), param1, param2);
        return 1L;
    }
}
