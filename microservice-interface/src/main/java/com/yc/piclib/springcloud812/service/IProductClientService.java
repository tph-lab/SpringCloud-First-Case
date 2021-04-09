package com.yc.piclib.springcloud812.service;

import com.yc.piclib.springcloud812.bean.Book;
import com.yc.piclib.springcloud812.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//此接口中的方法与服务提供方的功能（ProductController）一致
//即将Rest的调用转为了接口中的方法的调用，这个接口的调用要与提供方的服务要完全一样
@FeignClient(name = "microservice-provider",
        configuration = FeignClientConfig.class, fallbackFactory = IProductClientServiceFallbackFactory.class)
//配置要按自定义的类FeignClientConfig
public interface IProductClientService {


    @RequestMapping("/book/{id}")//这个springMVC的调用地址要与服务提供方要求的完全一样
    public Book get(@PathVariable("id") long id);

    @RequestMapping("/book/findAll")
    public List<Book> list();

/*
restemplate
    feign:
        http://microservice-provider
        _>
        http://localhost:8888
        ->
        再加入路径
        http://localhost:8888/book/{id}
 */


}
