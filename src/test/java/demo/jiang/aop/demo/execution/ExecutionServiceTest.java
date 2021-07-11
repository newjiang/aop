package demo.jiang.aop.demo.execution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExecutionServiceTest {

    @Autowired
    private ExecutionService executionService;

    @Test
    public void alpha() {
        executionService.alpha();
    }

    @Test
    public void beta() {
        executionService.beta();
    }

    @Test
    public void beta1() {
        executionService.beta("beta");
    }

    @Test
    public void beta2() {
        executionService.beta(1);
    }

    @Test
    public void beta3() {
        executionService.beta("beta", 1);
    }
}