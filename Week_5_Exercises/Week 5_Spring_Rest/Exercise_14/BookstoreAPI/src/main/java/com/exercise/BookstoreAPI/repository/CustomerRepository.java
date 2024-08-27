package com.exercise.BookstoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exercise.BookstoreAPI.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
