package com.springrest.bookstoreapi.controller;

import com.springrest.bookstoreapi.entity.Customer;
import com.springrest.bookstoreapi.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers()
    {
        List<Customer> list=customerRepository.findAll();
        for(Customer customer:list)
        {
            customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel());
            customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withRel("View Customer"));
            customer.add(linkTo(methodOn(CustomerController.class).deleteCustomer(customer.getId())).withRel("Delete customer"));
            customer.add(linkTo(methodOn(CustomerController.class).updateCustomer(customer.getId(),null)).withRel("update customer"));
            customer.add(linkTo(methodOn(CustomerController.class).saveCustomerDetails(null)).withRel("add customer"));
        }
        return list;
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
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer=customerRepository.findCustomerById(id);
        customer.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
        customer.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("View all customer"));
        customer.add(linkTo(methodOn(CustomerController.class).deleteCustomer(customer.getId())).withRel("Delete customer"));
        customer.add(linkTo(methodOn(CustomerController.class).updateCustomer(customer.getId(),null)).withRel("update customer"));
        customer.add(linkTo(methodOn(CustomerController.class).saveCustomerDetails(null)).withRel("add customer"));
        return customer;
    }
}
