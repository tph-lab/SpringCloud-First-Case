package com.yc.piclib.springcloud812.service;


import com.yc.piclib.springcloud812.bean.Book;
import com.yc.piclib.springcloud812.bean.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IZuulClientServiceCallbackFactory implements FallbackFactory<IZUUlClientService> {
    @Override
    public IZUUlClientService create(Throwable throwable) {
        return new IZUUlClientService() {


            @Override
            public Book getBook(long id) {
                Book p = new Book();
                p.setBookId(-1);
                p.setBookName("网络故障，请稍后重试");
                return p;
            }

            @Override
            public List<Book> listProduct() {
                return null;
            }


            @Override
            public User getUser(String id) {
                User user = new User();
                user.setName("网络故障，请稍后重试");
                return user;
            }

            @Override
            public User getUser2(String id) {
                return null;
            }


        };
    }
}
