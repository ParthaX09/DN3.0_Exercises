package com.library.repository;

import org.springframework.beans.factory.annotation.Value;



public class BookRepository {

    private String title;
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
