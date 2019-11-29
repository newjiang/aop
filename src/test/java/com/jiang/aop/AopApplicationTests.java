package com.jiang.aop;

import com.jiang.aop.demo.entity.User;
import com.jiang.aop.demo.log.LogService;
import com.jiang.aop.demo.service.TestService;
import com.jiang.aop.demo.service.sub.SubTestService;
import com.jiang.aop.pit.DemoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {

    @Autowired
    TestService testService;

    @Autowired
    SubTestService subTestService;

    @Autowired
    LogService logService;

    @Autowired
    DemoService demoService;

    @Before
    public void before(){
        System.out.println("----------- 开始测试 -----------");
    }

    @After
    public void after(){
        System.out.println("----------- 结束测试 -----------");
    }

    // Within表达式,匹配包/类型
    @Test
    public void testWithinExpression() {

        testService.findById(1);
        subTestService.subTest();

    }

    @Test
    public void testObject(){
        logService.log();
        testService.log();
    }

    @Test
    public void testArgs(){
        testService.findById(1);
        testService.findByTwoArgs(1, "name");
    }

    @Test
    public void testAnnotation() {
        testService.getName(new User());
        testService.findById(1);
        testService.findByTwoArgs(1, "name");
    }

    @Test
    public void testv() {
        testService.getName(new User());
        testService.findById(1);
        testService.findByTwoArgs(1, "name");
    }

    @Test
    public void testPit(){
        System.out.println(demoService.innerCall());
        System.out.println(demoService.innerCall());
    }
}
