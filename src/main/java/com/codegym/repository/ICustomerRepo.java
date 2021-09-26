package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer, Long>{
  Iterable<Customer> findAllByFirstName (String firstName);
}
