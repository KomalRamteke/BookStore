package com.example.bookstore.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.repo.BookRepo;
import com.example.bookstore.service.BookService; 
 
    @Service
    public class BookImple implements BookService{
        @Autowired
         private BookRepo bookRepo;
    
    
        @Override
        public List<Book> getall() {
            return bookRepo.findAll();
        }
    
        @Override
        public Book getone(int id) {
            return bookRepo.findById(id).get();
        }
    
        @Override
        public Book addBook(Book book) {
            return bookRepo.save(book);
           
           
        }
    
        @Override
        public Book updateBook(Book nbook, int id) {
            Book book=bookRepo.findById(id).orElseThrow();
                {
                    book.setId(id);
                    book.setName(nbook.getName());
                    book.setAuthor(nbook.getAuthor());          
                  book.setPrice(nbook.getPrice());

                    return bookRepo.save(book);
                }
            
       
        }
    
        @Override
        public void dltBook(int id) {
            bookRepo.deleteById(id);
        }

        @Override
        public Book detail(int id) {
            return bookRepo.findById(id).get();
        }
    
    }

