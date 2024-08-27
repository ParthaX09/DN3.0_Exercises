package com.springrest.bookstoreapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "isbn cannot be null")
    private Long isbn;
    @NotNull(message = "title of the book must be given")
    @Size(min=1,max=255,message = "The title of the Book should be between 1 -255 charcters")
    private String title;
    @NotNull(message = "The author name should be present")
    @Size(min=1,max=255,message = "The Name of the author should be between 1 -255 charcters")
    private String author;
    @NotNull(message = "Book needs to have a price")
    @Min(value = 1,message = "Price needs to be above 0")
    private Double price;
    @Version
    private Long version;
}
