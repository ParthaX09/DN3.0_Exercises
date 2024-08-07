package com.library.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Value("To kill a Mockingbird")
    private String title;
    @Value("Harper Lee")
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void performIndexing(){
        System.out.println("Performing Book Repository Indexing..");
    }
}
