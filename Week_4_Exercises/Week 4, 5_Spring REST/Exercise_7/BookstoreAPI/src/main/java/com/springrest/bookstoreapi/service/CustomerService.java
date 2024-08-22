package com.springrest.bookstoreapi.service;

import com.springrest.bookstoreapi.dto.CustomerDto;
import com.springrest.bookstoreapi.entity.Customer;
import com.springrest.bookstoreapi.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDto createNewCustomer(CustomerDto customerDto)
    {
        Customer customer=dtoToCustomer(customerDto);
        Customer savedCustomer=customerRepository.save(customer);
        return customerToDto(savedCustomer);
    }
    public CustomerDto updateCustomer(CustomerDto customerDto,Integer id){
        Customer customer=dtoToCustomer(customerDto);
        customer.setId(id);
        Customer savedCustomer=customerRepository.save(customer);
        return customerToDto(savedCustomer);
    }
    public List<CustomerDto> getAllCustomerDto()
    {
        List<Customer> customer=customerRepository.findAll();
        List<CustomerDto> fetchedCustomerDto=new ArrayList<>();
        for(int i=0;i<customer.size();i++)
        {
            Customer customerObj=customer.get(i);
            fetchedCustomerDto.add(customerToDto(customerObj));
        }
        return fetchedCustomerDto;

    }
    public void deleteCustomer(Integer id)
    {
        customerRepository.deleteById(id);
    }
    public CustomerDto getCustomerUsingId(Integer id)
    {
        Customer customer=customerRepository.findCustomerById(id);
        CustomerDto fetchedCustomerDto=customerToDto(customer);
        return fetchedCustomerDto;
    }

    public Customer dtoToCustomer(CustomerDto customerDto){
        Customer customer=this.modelMapper.map(customerDto,Customer.class);
        return customer;
    }
    public CustomerDto customerToDto(Customer customer){
        CustomerDto customerDto=modelMapper.map(customer,CustomerDto.class);
        return customerDto;
    }
}
