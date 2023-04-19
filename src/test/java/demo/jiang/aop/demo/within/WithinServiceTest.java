package demo.jiang.aop.demo.within;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class WithinServiceTest {
    @Autowired
    private WithinService withinService;

    @Test
    void alpha() {
        log.info("alpha = {}", withinService.alpha());
    }

    @Test
    void beta() {
        log.info("beta = {}", withinService.beta());
    }
}