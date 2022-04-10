package com.nn.BookStoreMaven.repository;

import com.nn.BookStoreMaven.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByName(String name);

    Optional<Book> findById(Integer id);

    void deleteByName(String name);
}
