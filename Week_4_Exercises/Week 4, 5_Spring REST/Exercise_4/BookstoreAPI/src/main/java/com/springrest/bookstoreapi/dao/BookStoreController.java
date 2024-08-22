package com.springrest.bookstoreapi.dao;

import com.springrest.bookstoreapi.entity.Book;
import com.springrest.bookstoreapi.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreController {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @PostMapping("/book")
    public Book registerBook(@RequestBody Book book){
        return bookStoreRepository.save(book);
    }
    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookStoreRepository.findAll();
    }
    @DeleteMapping("book/{id}")
    public String deleteBook(@PathVariable int id){
        bookStoreRepository.deleteById(id);
        return "successfully deleted";
    }
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody Book book){
        book.setId(id);
        return bookStoreRepository.save(book);
    }
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        return bookStoreRepository.findBookById(id);
    }
    @GetMapping("/book/{title}/{author}")
    public Book getBookByTitleAndAuthor(@PathVariable String title,@PathVariable String author){
        return bookStoreRepository.findBookByTitleAndAuthor(title,author);
    }
}
