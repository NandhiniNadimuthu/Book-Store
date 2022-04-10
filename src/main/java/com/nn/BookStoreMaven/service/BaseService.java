package com.nn.BookStoreMaven.service;

import com.nn.BookStoreMaven.Model.Book;

import java.util.List;
import java.util.Optional;

public abstract class BaseService {

    public abstract List<Book> listAllBook();

    public abstract List<Book> findBookByName(String name);

    public abstract Optional<Book> findBookById(Integer id);

    public abstract Integer addNewBook(Book book);

    public abstract String deleteBookById(Integer id);

    public abstract String deleteBookByName(String name);
}
