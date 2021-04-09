package com.yc.piclib.springcloud812.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;
    private int age;
    private String sex;

}