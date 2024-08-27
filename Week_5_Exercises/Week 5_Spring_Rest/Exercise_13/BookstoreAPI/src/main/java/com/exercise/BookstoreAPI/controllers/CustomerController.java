package com.exercise.BookstoreAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("")
    private ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = service.getCustomers();

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    // Accept form data
    @PostMapping("/save/form")
    @ResponseStatus(code = HttpStatus.CREATED)
    private Customer saveCustomerForm(@ModelAttribute Customer c) {
        return service.saveCustomer(c);
    }

    // Accept JSON data
    @PostMapping("/save/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    private Customer saveCustomerJson(@RequestBody Customer c) {
        return service.saveCustomer(c);
    }

}
