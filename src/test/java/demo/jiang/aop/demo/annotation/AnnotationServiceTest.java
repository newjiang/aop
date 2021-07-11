package demo.jiang.aop.demo.annotation;

import demo.jiang.aop.code.model.ArgsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnnotationServiceTest {

    @Autowired
    private AnnotationService annotationService;

    @Test
    public void matchAdmin() {
        annotationService.matchAdmin();
    }

    @Test
    public void matchWithin() {
        annotationService.matchWithin();
    }

    @Test
    public void matchTarget() {
        annotationService.matchTarget();
    }

    @Test
    public void matchArgs() {
        ArgsDto dto = new ArgsDto();
        dto.setId("9527");
        annotationService.matchArgs(dto);
    }
}