package com.yc.piclib.springcloud812.service;


import com.yc.piclib.springcloud812.bean.Book;

import java.util.List;

public interface BookService {
    public Book getBook(Integer id);

    public List<Book> findAll();
}