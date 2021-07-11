package demo.jiang.aop.demo.annotation;

import demo.jiang.aop.code.annotation.MyAnno;
import demo.jiang.aop.code.annotation.MyTarget;
import demo.jiang.aop.code.annotation.MyWithin;
import demo.jiang.aop.code.model.ArgsDto;
import org.springframework.stereotype.Service;

@Service
@MyWithin
@MyTarget
public class AnnotationService {

    @MyAnno
    public void matchAdmin() {
    }

    public void matchWithin() {
    }

    public void matchTarget() {
    }

    public void matchArgs(ArgsDto dto) {

    }

}
