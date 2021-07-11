package demo.jiang.aop.demo.within;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WithinServiceTest {

    @Autowired
    private WithinService withinService;

    @Test
    public void alpha() {
        withinService.alpha();
    }

    @Test
    public void beta() {
        withinService.beta();
    }
}