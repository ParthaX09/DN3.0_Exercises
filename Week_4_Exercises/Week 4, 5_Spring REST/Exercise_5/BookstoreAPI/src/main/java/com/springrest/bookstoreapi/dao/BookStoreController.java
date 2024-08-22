package com.springrest.bookstoreapi.dao;

import com.springrest.bookstoreapi.entity.Book;
import com.springrest.bookstoreapi.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BookStoreController {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerBook(@RequestBody Book book){
        return bookStoreRepository.save(book);
    }

    @GetMapping("/book")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        List<Book> b=bookStoreRepository.findAll();
        if(b.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No books available");
        }
        return b;
    }

    @DeleteMapping("book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBook(@PathVariable int id){
        if(!bookStoreRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book does not exist");
        }
        bookStoreRepository.deleteById(id);
        return "successfully deleted";
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable int id,@RequestBody Book book){
        if(!bookStoreRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book does not exist");
        }
        book.setId(id);
        return bookStoreRepository.save(book);
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id){
        Book b=null;
        b=bookStoreRepository.findBookById(id);
        if(b==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found");
        }
        return b;
    }


    @GetMapping("/book/{title}/{author}")
    public ResponseEntity<Book> getBookByTitleAndAuthor(@PathVariable String title, @PathVariable String author){
       Book b=bookStoreRepository.findBookByTitleAndAuthor(title,author);
       if(b!=null){
           return ResponseEntity.ok().header("custom header","Book retrieved").body(b);
       }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).header("custom header","Book not found").build();
       }
    }
}
