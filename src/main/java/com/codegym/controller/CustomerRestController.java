package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    ICustomerService customerService;
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll (){
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer (@RequestBody Customer customer) {
        customerService.save(customer);
        return new  ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Customer>> editCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> customer1= customerService.findById(id);
        if(!customer1.isPresent()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customer1.get().getId());
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> editCustomer (@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new  ResponseEntity<>(customer.get(), HttpStatus.OK);

    }

}
