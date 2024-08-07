package com.library.service;


import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void performService(){
        this.bookRepository.executeindexing();
        System.out.println("Performing Book Service");
    }
}
