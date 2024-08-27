package com.springrest.bookstoreapi.repository;

import com.springrest.bookstoreapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findCustomerById(int id);
}
