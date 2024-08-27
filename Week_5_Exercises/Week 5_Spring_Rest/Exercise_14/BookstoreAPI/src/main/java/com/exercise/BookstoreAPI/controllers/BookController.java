package com.exercise.BookstoreAPI.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.service.BookService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Slf4j
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String index() {
        return "Welcome to BookAPI project";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(@PathParam("title") String title,
            @PathParam("author") String author) {
        List<Book> list;
        if (author != null) {
            list = service.getBooksByAuthor(author);
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            else
                return ResponseEntity.ok(list);
        } else if (title != null) {
            list = service.getBooksByTitle(title);
            if (list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            else
                return ResponseEntity.ok(list);
        }
        list = service.getBooks();
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {

        log.info("BookController GET /books/{id} invoked!");

        Book b = service.getBookById(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @PostMapping("/books/save-all")
    public ResponseEntity<List<Book>> saveBooks(@RequestBody List<Book> bookList) {
        List<Book> list = service.saveBooks(bookList);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        else
            return ResponseEntity.ok(list);
    }

    @PostMapping("/books/save-one")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        log.info("BookController POST /books/save-one invoked!");

        Book b = service.saveBook(book);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable long id) {
        Book b = service.updateBook(book, id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id) {
        Book b = service.deleteBook(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.ok(b);
        }
    }

}
