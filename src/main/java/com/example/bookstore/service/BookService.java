package com.example.bookstore.service;
import java.util.List;

import com.example.bookstore.entity.Book;

public interface BookService {

    public List<Book> getall();

    public Book getone(int id);

    public Book addBook(Book book);

    public Book updateBook(Book book, int id);

    public void dltBook(int id);

    public Book detail(int id);
    
}
