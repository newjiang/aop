package demo.jiang.aop.demo.annotation;

import demo.jiang.aop.model.ArgsDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AnnotationServiceTest {
    @Autowired
    private AnnotationService annotationService;

    @Test
    void matchAnnotation() {
        annotationService.matchAnnotation();
    }

    @Test
    void matchWithin() {
        annotationService.matchWithin();
    }

    @Test
    void matchTarget() {
        annotationService.matchTarget();
    }

    @Test
    void matchArgs() {
        annotationService.matchArgs(new ArgsDto("999"));
    }
}