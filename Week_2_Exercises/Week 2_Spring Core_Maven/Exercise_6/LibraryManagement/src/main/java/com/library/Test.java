package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService obj=context.getBean("bookService", BookService.class);
        System.out.println(obj.getBookRepository().getTitle()+" is written by "+obj.getBookRepository().getAuthor());
        obj.performService();
    }
}
