package com.yc.piclib.springcloud812.controller;


import com.yc.piclib.springcloud812.domin.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/consumer")
public class BookController {

    private final static String URl = "http://localhost:8888/book/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") Integer id) {

        return restTemplate.getForObject(URl + id, Book.class);
    }

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return restTemplate.getForObject(URl + "findAll", List.class);
    }
}
