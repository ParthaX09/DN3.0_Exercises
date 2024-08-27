package com.springrest.bookstoreapi.controller;

import com.springrest.bookstoreapi.entity.Book;
import com.springrest.bookstoreapi.exception.ResourceNotFoundException;
import com.springrest.bookstoreapi.repository.BookStoreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStoreController {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @PostMapping("/book")
    public ResponseEntity<?> registerBook(@Valid @RequestBody Book book) throws Exception {
        Book b = bookStoreRepository.save(book);
        if (b == null) {
            throw new Exception("internal server error");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }

    @GetMapping(value = "/book")
    public ResponseEntity<?> getAllBooks() {
        List<Book> b = bookStoreRepository.findAll();
        if (b.isEmpty()) {
            throw new ResourceNotFoundException("No books available");
        }
        return ResponseEntity.ok(b);
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        if (!bookStoreRepository.existsById(id)) {
            throw new ResourceNotFoundException("No Book with id : " + id + " Found");
        }
        bookStoreRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        if (!bookStoreRepository.existsById(id)) {
            throw new ResourceNotFoundException("No Book with id : " + id + " Found");
        }
        book.setId(id);
        Book b = bookStoreRepository.save(book);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book b = null;
        b = bookStoreRepository.findBookById(id);
        if (b == null) {
            throw new ResourceNotFoundException("No Book with id : " + id + " Found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(b);
    }


    @GetMapping("/book/{title}/{author}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getBookByTitleAndAuthor(@PathVariable String title, @PathVariable String author) {
        Book b = bookStoreRepository.findBookByTitleAndAuthor(title, author);
        if (b != null) {
            return ResponseEntity.ok().header("custom header", "Book retrieved").body(b);
        } else {
            throw new ResourceNotFoundException("No Book with title : " + title + " and author : " + author + " found");

        }
    }
}

