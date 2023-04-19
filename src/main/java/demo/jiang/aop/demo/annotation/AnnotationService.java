package demo.jiang.aop.demo.annotation;

import demo.jiang.aop.annotation.MyAnno;
import demo.jiang.aop.annotation.MyTarget;
import demo.jiang.aop.annotation.MyWithin;
import demo.jiang.aop.model.ArgsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 注解服务
 */
@Slf4j
@Service
@MyWithin
@MyTarget
public class AnnotationService {
    /**
     * 匹配注解@MyAnno
     */
    @MyAnno
    public void matchAnnotation() {
        log.info("{}.matchAnnotation ..", this.getClass().getSimpleName());
    }

    /**
     * 匹配注解@MyWithin
     */
    public void matchWithin() {
        log.info("{}.matchWithin ..", this.getClass().getSimpleName());
    }

    /**
     * 匹配注解@MyTarget
     */
    public void matchTarget() {
        log.info("{}.matchTarget ..", this.getClass().getSimpleName());
    }

    /**
     * 匹配注解@MyArgs
     */
    public void matchArgs(ArgsDto dto) {
        log.info("{}.matchArgs .., dto = {}", this.getClass().getSimpleName(), dto);
    }
}
