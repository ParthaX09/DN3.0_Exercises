package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService=context.getBean("bookService", BookService.class);
        BookRepository bookRepository=context.getBean("bookRepository",BookRepository.class);
        System.out.println("The name of the book is "+bookService.getBookRepository().getTitle());
        bookRepository.performIndexing();
        bookService.performService();
    }
}
