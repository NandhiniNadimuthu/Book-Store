package com.nn.BookStoreMaven.service;


import com.nn.BookStoreMaven.Model.Book;
import com.nn.BookStoreMaven.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> findBookById(Integer id) {
        return bookRepo.findById(id);
    }

    @Override
    public Integer addNewBook(Book book) {
        Book newBook = bookRepo.save(book);
        return newBook.getId();
    }

    @Override
    public String deleteBookById(Integer id){
        bookRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public String deleteBookByName(String name){
        bookRepo.deleteByName(name);
        return "Deleted Successfully";
    }
}
