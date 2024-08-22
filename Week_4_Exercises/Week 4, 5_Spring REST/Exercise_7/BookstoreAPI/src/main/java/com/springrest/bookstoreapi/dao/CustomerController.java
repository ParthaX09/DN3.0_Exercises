package com.springrest.bookstoreapi.dao;

import com.springrest.bookstoreapi.dto.CustomerDto;
import com.springrest.bookstoreapi.entity.Customer;
import com.springrest.bookstoreapi.repository.CustomerRepository;
import com.springrest.bookstoreapi.service.CustomerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customer")
    public CustomerDto postCustomerData(@RequestBody CustomerDto customerDto)
    {
        return customerService.createNewCustomer(customerDto);
    }
    @GetMapping("/customer")
    public List<CustomerDto> getEveryCustomer()
    {
        return customerService.getAllCustomerDto();
    }
    @PutMapping("/customer/{id}")
    public CustomerDto updateCustomerData(@RequestBody CustomerDto customerDto,@PathVariable int id)
    {
        return customerService.updateCustomer(customerDto,id);
    }
    @DeleteMapping("/customer/{id}")
    public void deleteCustomerData(@PathVariable int id)
    {
        customerService.deleteCustomer(id);
    }
    @GetMapping("/customer/{id}")
    public CustomerDto getCustomerDataById(@PathVariable int id)
    {
        return customerService.getCustomerUsingId(id);
    }
}
