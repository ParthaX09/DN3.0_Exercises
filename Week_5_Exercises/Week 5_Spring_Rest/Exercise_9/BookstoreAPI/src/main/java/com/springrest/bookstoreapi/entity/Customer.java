package com.springrest.bookstoreapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Data
public class Customer extends RepresentationModel<Customer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Name is mandatory")
    @Size(min = 1,max = 255,message = "The Name of the customeer should be between 1 -255 charcters")
    private String name;
    @NotNull(message = "email cannot be null")
    @Email(message = "The email should be valid")
    private String email;
    @NotNull(message = "password is required")
    @Size(min = 5,message = "The password should be atleast 5 characters long")
    private String password;
    @Version
    private long version;
}
