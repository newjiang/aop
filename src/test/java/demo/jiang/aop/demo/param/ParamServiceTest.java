package demo.jiang.aop.demo.param;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParamServiceTest {

    @Autowired
    private ParamService paramService;

    @Test
    public void findAny() {
        paramService.findAny();
    }

    @Test
    public void findById() {
        paramService.findById(1L);
    }

    @Test
    public void deleteById() {
        paramService.deleteById(1L);
    }
}