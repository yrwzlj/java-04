package com.yrw.mvc.service;

import com.yrw.mvc.bean.Book;
import com.yrw.mvc.dao.BookConnetion;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    static  public Book BookSearchById(String name){
        Book book = BookConnetion.searchBookByName(name);
        System.out.println(book);
        if (book == null) System.out.println("网站中暂无此书");
        return book;
    }

    static  public List<Book> BookSearchByAuthor(String author){
        List<Book> list = BookConnetion.searchBookByAuthor(author);
        System.out.println(list);
        if (list == null) System.out.println("网站中暂无此书");
        return list;
    }

    static public void addbook(Book book){
        BookConnetion.addBook(book);
    }

}
