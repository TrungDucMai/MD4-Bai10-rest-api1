package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepo customerRepo;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);

    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public Iterable<Customer> findAllByFirstName(String firstName) {
        return customerRepo.findAllByFirstName(firstName);
    }
}
