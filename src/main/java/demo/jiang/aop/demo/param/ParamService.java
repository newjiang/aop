package demo.jiang.aop.demo.param;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 参数服务
 */
@Slf4j
@Service
public class ParamService {
    /**
     * findAny
     *
     * @return String
     */
    public String findAny() {
        log.info("{}.findAny ..", this.getClass().getSimpleName());
        return "findAny";
    }

    /**
     * findById
     *
     * @param id Long
     * @return Long
     */
    public Long findById(Long id) {
        log.info("{}.findById(id = {}) ..", this.getClass().getSimpleName(), id);
        return id;
    }

    /**
     * deleteById
     *
     * @param id Long
     * @return Long
     */
    public String deleteById(Long id) {
        log.info("{}.deleteById(id = {}) ..", this.getClass().getSimpleName(), id);
        return "deleteById";
    }
}
