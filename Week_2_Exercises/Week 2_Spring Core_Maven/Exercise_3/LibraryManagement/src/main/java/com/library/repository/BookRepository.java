package com.library.repository;

public class BookRepository {
    private String title;

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
