package com.springrest.bookstoreapi.repository;

import com.springrest.bookstoreapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<Book,Integer> {
    public Book findBookById(int id);
    public Book findBookByTitleAndAuthor(String title,String author);
    public Book findBookByIsbn(long isbn);
}
