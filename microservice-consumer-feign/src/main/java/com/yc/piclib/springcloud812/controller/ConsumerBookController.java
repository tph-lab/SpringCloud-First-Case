package com.yc.piclib.springcloud812.controller;


import com.yc.piclib.springcloud812.bean.Book;
import com.yc.piclib.springcloud812.service.IProductClientService;
import com.yc.piclib.springcloud812.service.IZUUlClientService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerBookController {

    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private IZUUlClientService izuulClientService;

    //添加日志
    private static Logger log = LoggerFactory.getLogger(ConsumerBookController.class);

    @Resource
    private LoadBalancerClient loadBalancerClient;//因为ribbon是客户端的负载均衡，所以他可以在客户端记录访问的日志

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return this.iProductClientService.get(id);
    }


    @GetMapping("/findAll")
    public List<Book> findAll() {
        return this.iProductClientService.list();
    }

    @RequestMapping("all/{id}")
    public Object getBookAndUser(@PathVariable("id") long id) {
        log.info("*******" + id);
        Map<String, Object> result = new HashMap();
        result.put("book", izuulClientService.getBook(id));

        result.put("user", izuulClientService.getUser(id + ""));
        result.put("user", izuulClientService.getUser2(id + ""));
        result.put("productList", izuulClientService.listProduct());
        log.info("*******" + result);
        return result;
    }


}
