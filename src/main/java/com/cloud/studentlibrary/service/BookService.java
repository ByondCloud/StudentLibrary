package com.cloud.studentlibrary.service;

import com.cloud.studentlibrary.entity.Book;

import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/10
 * @Time 18:45
 */
public interface BookService {
    List<Book> bookList();

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int id);
}
