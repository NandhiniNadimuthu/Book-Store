package com.nn.BookStoreMaven.controller;

import com.nn.BookStoreMaven.Model.Book;
import com.nn.BookStoreMaven.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController{

    public final BaseService service;

    @Autowired
    public BookController(BaseService service) {
        this.service = service;
    }

    @GetMapping("/String")
    public String store(){
    return "book";
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBookDetails(){
        List<Book> books = service.listAllBook();
        return CollectionUtils.isEmpty(books) ? ResponseEntity.badRequest().body(books) : ResponseEntity.ok(books) ;
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBookByName(@RequestParam("name") String name){
        List<Book> books = service.findBookByName(name);
        return CollectionUtils.isEmpty(books) ? ResponseEntity.badRequest().body(books) : ResponseEntity.ok(books) ;
    }


}
