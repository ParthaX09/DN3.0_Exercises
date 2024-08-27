package com.springrest.bookstoreapi.controller;

import com.springrest.bookstoreapi.entity.Book;
import com.springrest.bookstoreapi.exception.ResourceNotFoundException;
import com.springrest.bookstoreapi.repository.BookStoreRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() throws Exception {
        List<Book> b = bookStoreRepository.findAll();
        for(Book book:b){
            book.add(linkTo(methodOn(BookStoreController.class).getBookById(book.getId())).withSelfRel());
            book.add(linkTo(methodOn(BookStoreController.class).getAllBooks()).withRel("View All Books"));
            book.add(linkTo(methodOn(BookStoreController.class).deleteBook(book.getId())).withRel("Delete Book"));
            book.add(linkTo(methodOn(BookStoreController.class).registerBook(null)).withRel("Add a new Book"));
            book.add(linkTo(methodOn(BookStoreController.class).getBookByTitleAndAuthor(book.getTitle(),book.getAuthor())).withRel("Get Book by Title and Author"));
            book.add(linkTo(methodOn(BookStoreController.class).updateBook(book.getId(),null)).withRel("edit Book"));
        }
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
    public ResponseEntity<?> getBookById(@PathVariable int id) throws Exception {
        Book b = null;
        b = bookStoreRepository.findBookById(id);
        b.add(linkTo(methodOn(BookStoreController.class).getBookById(b.getId())).withSelfRel());
        b.add(linkTo(methodOn(BookStoreController.class).getAllBooks()).withRel("View All Books"));
        b.add(linkTo(methodOn(BookStoreController.class).deleteBook(b.getId())).withRel("Delete Book"));
        b.add(linkTo(methodOn(BookStoreController.class).registerBook(null)).withRel("Add a new Book"));
        b.add(linkTo(methodOn(BookStoreController.class).getBookByTitleAndAuthor(b.getTitle(),b.getAuthor())).withRel("Get Book by Title and Author"));
        b.add(linkTo(methodOn(BookStoreController.class).updateBook(b.getId(),null)).withRel("edit Book"));

    if (b == null) {
            throw new ResourceNotFoundException("No Book with id : " + id + " Found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(b);
    }

    @GetMapping("/book/{title}/{author}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getBookByTitleAndAuthor(@PathVariable String title, @PathVariable String author) throws Exception {
        Book b = bookStoreRepository.findBookByTitleAndAuthor(title, author);
        b.add(linkTo(methodOn(BookStoreController.class).getBookByTitleAndAuthor(b.getTitle(),b.getAuthor())).withSelfRel());
        b.add(linkTo(methodOn(BookStoreController.class).getAllBooks()).withRel("View All Books"));;
        b.add(linkTo(methodOn(BookStoreController.class).deleteBook(b.getId())).withRel("Delete Book"));
        b.add(linkTo(methodOn(BookStoreController.class).registerBook(null)).withRel("Add a new Book"));
        b.add(linkTo(methodOn(BookStoreController.class).getBookById(b.getId())).withRel("Get Book by id"));
        b.add(linkTo(methodOn(BookStoreController.class).updateBook(b.getId(),null)).withRel("edit Book"));
        if (b != null) {
            return ResponseEntity.ok().header("custom header", "Book retrieved").body(b);
        } else {
            throw new ResourceNotFoundException("No Book with title : " + title + " and author : " + author + " found");
        }
    }
}

