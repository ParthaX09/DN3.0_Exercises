package com.springrest.bookstoreapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private int statusCode;
    private String message;
    private String description;
    private Date timestamp;

}
