package com.yc.piclib.springcloud812.service;

import com.yc.piclib.springcloud812.bean.Book;
import com.yc.piclib.springcloud812.bean.User;
import com.yc.piclib.springcloud812.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * fegin访问zuul的接口
 */
@FeignClient(name = "microservice-zuul-gateway", configuration = FeignClientConfig.class, fallbackFactory = IZuulClientServiceCallbackFactory.class)
public interface IZUUlClientService {

    //相当于客户端通过fegin访问zuul，然后通过zuul再访问到真正的客户端
    @RequestMapping("/yc-api/product-proxy/book/{id}")
    public Book getBook(@PathVariable("id") long id);

    @RequestMapping("/yc-api/product-proxy/book/findAll")
    public List<Book> listProduct();


    @RequestMapping("/yc-api/user1-proxy/user/get/{id}")
    public User getUser(@PathVariable("id") String id);

    @RequestMapping("/yc-api/user2-proxy/user/get/{id}")
    public User getUser2(@PathVariable("id") String id);
}
