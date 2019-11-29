package com.jiang.aop.pit;

import com.jiang.aop.config.ApplicationContextHolder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DemoService {

    @Cacheable(cacheNames = {"cache"})
    public List<String> getData(){
        System.out.println("select from database");
        return Arrays.asList("AAA","BBB","CCC");
    }

    public List<String> innerCall(){
        DemoService proxy = ApplicationContextHolder.getContext().getBean(DemoService.class);
        return proxy.getData();
    }

    /*
    return getData(),实际是return this.getData(),this是该bean,不是经过AOP代理的bean
    public List<String> innerCall(){
        return getData();
    }
    */
}
