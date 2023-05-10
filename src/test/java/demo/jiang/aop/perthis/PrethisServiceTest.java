package demo.jiang.aop.perthis;

import demo.jiang.aop.context.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PrethisServiceTest {
    @Test
    void foo() {
        for (int i = 0; i < 5; i++) {
            ApplicationContextHolder.getContext().getBean(IPerthisService.class).foo();
        }
    }
}