package com.example.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>{
    
}
