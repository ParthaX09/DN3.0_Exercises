package com.exercise.BookstoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.BookstoreAPI.models.Customer;
import com.exercise.BookstoreAPI.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    public Customer saveCustomer(Customer c) {
        return repo.save(c);
    }
}
