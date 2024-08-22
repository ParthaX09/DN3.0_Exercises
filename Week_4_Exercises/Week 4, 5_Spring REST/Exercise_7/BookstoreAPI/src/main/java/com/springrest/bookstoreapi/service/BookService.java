package com.springrest.bookstoreapi.service;


import com.springrest.bookstoreapi.dto.BookDto;
import com.springrest.bookstoreapi.entity.Book;
import com.springrest.bookstoreapi.repository.BookStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookStoreRepository bookStoreRepository;

    public BookDto getBookByIsbn(Long isbn)
    {
        Book book=bookStoreRepository.findBookByIsbn(isbn);
        BookDto bookDto=bookToDto(book);
        return bookDto;
    }

    public Book dtoToBook(BookDto bookDto){
        Book book=this.modelMapper.map(bookDto,Book.class);
        return book;
    }
    public BookDto bookToDto(Book book){
        BookDto bookDto=modelMapper.map(book,BookDto.class);
        return bookDto;
    }
}
