package com.springrest.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    @JsonIgnore
    private int id;
    @JsonProperty("Book_Isbn")
    private long isbn;
    @JsonProperty("Book_Name")
    private String title;
    @JsonProperty("Book_Author")
    private String author;
}
