package demo.jiang.aop.introduction;

import demo.jiang.aop.context.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class IntroductionServiceTest {
    @Test
    public void test() {
        IntroductionInterface service = ApplicationContextHolder.getContext().getBean("introductionService", IntroductionInterface.class);
        service.request();
    }
}