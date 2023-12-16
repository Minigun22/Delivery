package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void save(Customer user){
        customerRepository.save(user);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Optional<Customer> loadUserByUsername(String username){
        return customerRepository.findByUsername(username);
    }
}
