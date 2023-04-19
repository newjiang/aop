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
    public void betaFoo() {
        log.info("{}.betaFoo() ..", this.getClass().getSimpleName());
    }

    /**
     * gamma方法
     *
     * @param param String
     * @return String
     */
    public String gammaFoo(String param) {
        log.info("{}.gammaFoo(param = {}) ..", this.getClass().getSimpleName(), param);
        return param;
    }

    /**
     * delta方法
     *
     * @param param Integer
     * @return Integer
     */
    public Integer deltaFoo(Integer param) {
        log.info("{}.deltaFoo(param = {}) ..", this.getClass().getSimpleName(), param);
        return param;
    }

    /**
     * epsilon方法
     *
     * @param param1 String
     * @param param2 Integer
     * @return Long
     */
    public Long epsilonFoo(String param1, Integer param2) {
        log.info("{}.epsilonFoo(param1 = {}, param2 = {}) ..", this.getClass().getSimpleName(), param1, param2);
        return 1L;
    }

    /**
     * zeta
     */
    public void zeta() {
        log.info("{}.zeta () ..", this.getClass().getSimpleName());
    }
}
