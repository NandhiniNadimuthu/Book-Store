package com.nn.BookStoreMaven.controller;

import com.google.gson.Gson;
import com.nn.BookStoreMaven.Model.Book;
import com.nn.BookStoreMaven.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController{

    public final BaseService service;

    @Autowired
    public BookController(BaseService service) {
        this.service = service;
    }

    Gson gson = new Gson();

    @GetMapping("/String")
    public String store(){
    return "book";
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBookDetails(){
        List<Book> books = service.listAllBook();
        return CollectionUtils.isEmpty(books) ? ResponseEntity.badRequest().body(books) : ResponseEntity.ok(books) ;
    }

    @GetMapping(value = "/findBook", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBookByName(@RequestParam String name){
        List<Book> books = service.findBookByName(name);
        return CollectionUtils.isEmpty(books) ? ResponseEntity.badRequest().body(books) : ResponseEntity.ok(books) ;
    }

    @GetMapping(value = "/findBook", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Book>> getBookById(@RequestParam Integer id){
        Optional<Book> books = service.findBookById(id);
        return CollectionUtils.isEmpty(Collections.singleton(books)) ? ResponseEntity.badRequest().body(books) : ResponseEntity.ok(books) ;
    }

    @PostMapping(value = "/addBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> addNewBook(@RequestBody Book book){
        Integer id = service.addNewBook(book);
        return StringUtils.isEmpty(id) ? ResponseEntity.badRequest().body(id) : ResponseEntity.ok(id) ;
    }

    @Transactional
    @DeleteMapping(value = "/deleteBook", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> DeleteBookById(@RequestParam Integer id){
        String delete = service.deleteBookById(id);
        return StringUtils.hasLength(delete) ? ResponseEntity.ok(gson.toJson(delete)) : ResponseEntity.badRequest().body(gson.toJson(delete)) ;
    }

    @Transactional
    @DeleteMapping(value = "/deleteBook", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> DeleteBookByName(@RequestParam String name){
        String delete = service.deleteBookByName(name);
        return StringUtils.hasLength(delete) ? ResponseEntity.ok(gson.toJson(delete)) : ResponseEntity.badRequest().body(gson.toJson(delete)) ;
    }
}
