package com.springrest.bookstoreapi.controller;

import com.springrest.bookstoreapi.entity.Customer;
import com.springrest.bookstoreapi.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
    @PostMapping("/customer")
    public Customer saveCustomerDetails(@Valid @RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable int id,@Valid@RequestBody Customer customer){
        customer.setId(id);
        return customerRepository.save(customer);
    }
    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerRepository.findCustomerById(id);
    }
}
