package demo.jiang.aop.demo.object;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ObjectServiceTest {
    @Autowired
    private ObjectService objectService;

    @Test
    void alpha() {
        log.info("alpha = {}", objectService.alpha());
    }

    @Test
    void beta() {
        log.info("beta = {}", objectService.beta());
    }
}