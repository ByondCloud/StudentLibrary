package com.cloud.studentlibrary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.studentlibrary.entity.Book;
import com.cloud.studentlibrary.mapper.BookMapper;
import com.cloud.studentlibrary.mapper.UserMapper;
import com.cloud.studentlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/10
 * @Time 18:45
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> bookList() {

        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.ge("book_price", 40);

//        List<Book> books = bookMapper.selectList(wrapper);
        List<Book> books = bookMapper.selectList(null);
        return books;
    }

    @Override
    public void addBook(Book book) {
        bookMapper.insert(book);

    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateById(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteById(id);
    }
}
