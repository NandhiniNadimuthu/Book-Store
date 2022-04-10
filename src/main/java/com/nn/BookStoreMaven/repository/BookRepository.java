package com.nn.BookStoreMaven.repository;

import com.nn.BookStoreMaven.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByName(String name);
}
