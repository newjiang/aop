package demo.jiang.aop.demo.args;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ArgsServiceTest {
    @Autowired
    private ArgsService argsService;

    @Test
    void findAny() {
        log.info("findAny = {}", argsService.findAny());
    }

    @Test
    void findById() {
        log.info("findById = {}", argsService.findById(1L));
    }

    @Test
    void deleteById() {
        log.info("deleteById = {}", argsService.deleteById(1L));
    }
}