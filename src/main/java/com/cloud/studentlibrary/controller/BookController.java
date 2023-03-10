package com.cloud.studentlibrary.controller;

import com.cloud.studentlibrary.entity.Book;
import com.cloud.studentlibrary.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/10
 * @Time 18:44
 */
@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;



    @GetMapping("/bookList")
    public List<Book> selectBookList() {

        List<Book> books = bookService.bookList();
        return books;
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {

        bookService.addBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {

        bookService.deleteBook(id);

    }

    @PutMapping("/updateBook")
    public void updateBook(@RequestBody String json) {

        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        Book book = null;

        try {
            book = objectMapper.readValue(json, Book.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        bookService.updateBook(book);

    }



}
