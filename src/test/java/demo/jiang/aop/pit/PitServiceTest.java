package demo.jiang.aop.pit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PitServiceTest {
    @Autowired
    private PitService pitService;

    @Test
    void query() {
        log.info("query = {}", pitService.query());
    }

    @Test
    void errorCall() {
        log.info("errorCall1 = {}", pitService.errorCall());
        log.info("errorCall2 = {}", pitService.errorCall());
    }

    @Test
    void correctCall() {
        log.info("correctCall1 = {}", pitService.correctCall());
        log.info("correctCall2 = {}", pitService.correctCall());
    }

    @Test
    void staticMethod() {
        PitService.staticMethod();
    }

    @Test
    void finalMethod() {
        pitService.finalMethod();
    }

    @Test
    void executePrivateMethod() {
        pitService.executePrivateMethod();
    }
}