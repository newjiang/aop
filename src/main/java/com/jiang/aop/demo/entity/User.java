package com.jiang.aop.demo.entity;

import com.jiang.aop.demo.anno.NeedSecured;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NeedSecured
public class User {

    private String id;
    private String name;
    private String role;

}
