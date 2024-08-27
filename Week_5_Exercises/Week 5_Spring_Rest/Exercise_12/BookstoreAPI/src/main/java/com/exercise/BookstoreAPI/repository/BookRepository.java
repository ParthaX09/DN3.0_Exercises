package com.exercise.BookstoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.BookstoreAPI.models.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);
}