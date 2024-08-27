package com.exercise.BookstoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.BookstoreAPI.models.Book;
import com.exercise.BookstoreAPI.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public Book getBookById(long id) {
        log.info("BookService getBookById(id) invoked!");
        return repo.findById(id).orElse(null);
    }

    public List<Book> saveBooks(List<Book> bookList) {
        return repo.saveAll(bookList);
    }

    public Book saveBook(Book book) {
        log.info("BookService POST saveBook() invoked!");
        return repo.save(book);
    }

    public Book updateBook(Book book, long id) {
        Book b = repo.findById(id).orElse(null);
        b = book;
        return repo.save(b);
    }

    public Book deleteBook(long id) {
        Book b = repo.findById(id).orElse(null);
        if (b != null) {
            repo.deleteById(id);
        }
        return b;
    }

    public List<Book> getBooksByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    public List<Book> getBooksByTitle(String title) {
        return repo.findByTitle(title);
    }

}
