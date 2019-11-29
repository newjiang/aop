package com.jiang.aop.demo.service;


import com.jiang.aop.demo.anno.AdminOnly;
import com.jiang.aop.demo.anno.NeedSecured;
import com.jiang.aop.demo.anno.NeedSecuredClass;
import com.jiang.aop.demo.anno.NeedSecuredSource;
import com.jiang.aop.demo.entity.User;
import com.jiang.aop.demo.log.Loggable;
import org.springframework.stereotype.Component;

@Component
@NeedSecured
@NeedSecuredSource
@NeedSecuredClass
public class TestService implements Loggable {

    @AdminOnly
    public String getName(User user){
        System.out.println("execute get name");
        return "I am TestService";
    }

    public void executeException() throws IllegalAccessException{
        System.out.println("execute Exception demo");
        throw new IllegalAccessException("Test Exception");
    }

    public void findById(int id){
        System.out.println("execute find by id");
    }


    public void findByTwoArgs(int id, String name) {
        System.out.println("execute find by id and name");
    }

    @Override
    public void log() {
        System.out.println("log from product service");
    }
}
