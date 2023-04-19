package demo.jiang.aop.demo.execution;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ExecutionServiceTest {
    @Autowired
    private ExecutionService executionService;

    @Test
    void alpha() {
        executionService.alpha();
    }

    @Test
    void betaFoo() {
        executionService.betaFoo();
    }

    @Test
    void gammaFoo() {
        log.info("gammaFoo = {}", executionService.gammaFoo("gamma"));
    }

    @Test
    void deltaFoo() {
        log.info("deltaFoo = {}", executionService.deltaFoo(1));
    }

    @Test
    void epsilonFoo() {
        log.info("epsilonFoo = {}", executionService.epsilonFoo("epsilon", 1));
    }

    @Test
    void zeta() {
        executionService.zeta();
    }
}