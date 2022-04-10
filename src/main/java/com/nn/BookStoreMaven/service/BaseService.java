package com.nn.BookStoreMaven.service;

import com.nn.BookStoreMaven.Model.Book;

import java.util.List;

public abstract class BaseService {

    public abstract List<Book> listAllBook();
    public abstract List<Book> findBookByName(String name);
}
