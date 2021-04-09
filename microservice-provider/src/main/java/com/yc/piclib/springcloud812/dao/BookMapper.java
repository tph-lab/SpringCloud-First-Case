package com.yc.piclib.springcloud812.dao;

import com.yc.piclib.springcloud812.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends MisBaseMapper<Book> {
}
