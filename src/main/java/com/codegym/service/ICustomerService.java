package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface ICustomerService {
    Iterable<Customer> findAll();
    void save(Customer customer );
    void delete (Long id);
    Optional<Customer> findById (Long id);
    Iterable<Customer> findAllByFirstName  (String firstName);
}


