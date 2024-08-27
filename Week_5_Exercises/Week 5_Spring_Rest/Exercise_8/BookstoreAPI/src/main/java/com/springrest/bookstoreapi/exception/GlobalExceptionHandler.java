package com.springrest.bookstoreapi.exception;

import com.springrest.bookstoreapi.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.Time;
import java.sql.Timestamp;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundExceptionHandler(ResourceNotFoundException e,WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(HttpStatus.NOT_FOUND.value(),e.getMessage(),webRequest.getDescription(false),new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception e,WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),webRequest.getDescription(false),new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
