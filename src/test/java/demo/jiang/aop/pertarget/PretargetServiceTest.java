package demo.jiang.aop.pertarget;

import demo.jiang.aop.context.ApplicationContextHolder;
import demo.jiang.aop.perthis.IPerthisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PretargetServiceTest {

    @Test
    void foo() {
        for (int i = 0; i < 5; i++) {
            ApplicationContextHolder.getContext().getBean(PretargetService.class).foo();
        }
    }
}