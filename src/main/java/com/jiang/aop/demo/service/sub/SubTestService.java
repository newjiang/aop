package com.jiang.aop.demo.service.sub;

import com.jiang.aop.demo.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class SubTestService extends TestService {

    public void subTest(){
        System.out.println("execute Sub Service Method");
    }
}
