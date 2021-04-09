package com.yc.piclib.springcloud812.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yc.piclib.springcloud812.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand(fallbackMethod = "errorCallBack")
    public Object get(@PathVariable("name") String name) {
        User users = new User();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }

    public Object errorCallBack(@PathVariable("name") String name) {
        //Book p=new Book();
        //p.setBookId(     (int)id);
        // p.setBookName("服务器烦忙,请稍后访问");
        // return p;
        return ("查无此人，服务不可用");
    }
}