package com.jiang.aop.demo.log;

import com.jiang.aop.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LogService implements Loggable {

    @Override
    public void log() {
        System.out.println("log from LogService");
    }

    public void annoArgs(User user) {
        System.out.println("execute log service annoArg");
    }
}
