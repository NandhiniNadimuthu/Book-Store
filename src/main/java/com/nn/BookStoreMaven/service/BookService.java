package com.nn.BookStoreMaven.service;


import com.nn.BookStoreMaven.Model.Book;
import com.nn.BookStoreMaven.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService{

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> listAllBook(){
        return (List<Book>) bookRepo.findAll();
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepo.findByName(name);
    }
}
