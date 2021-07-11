package demo.jiang.aop.pit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PitServiceTest {

    @Autowired
    private PitService pitService;

    @Test
    public void errorCall() {
        // 连续调用两次错误的调用方法
        pitService.errorCall();
        pitService.errorCall();
    }

    @Test
    public void correctCall() {
        // 连续调用两次正确的调用方法
        pitService.correctCall();
        pitService.correctCall();
    }

    @Test
    public void staticMethod() {
        PitService.staticMethod();
    }

    @Test
    public void finalMethod() {
        pitService.finalMethod();
    }

    @Test
    public void executePrivateMethod() {
        pitService.executePrivateMethod();
    }

}