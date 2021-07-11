package demo.jiang.aop.demo.object;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ObjectServiceTest {

    @Autowired
    private ObjectService objectService;

    @Test
    public void alpha() {
        objectService.alpha();
    }

    @Test
    public void beta() {
        objectService.beta();
    }
}