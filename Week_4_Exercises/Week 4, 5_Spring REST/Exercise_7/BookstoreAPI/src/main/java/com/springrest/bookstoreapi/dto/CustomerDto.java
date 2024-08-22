package com.springrest.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDto {
    @JsonIgnore
    private int id;
    @JsonProperty("Customer_Name")
    private String name;
    @JsonProperty("Customer_Email")
    private String email;
    @JsonProperty("Customer_Password")
    private String password;
}
