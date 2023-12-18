package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.modells.customer.Roles;
import com.cooldelivery.delivery.repositories.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;


    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void save(Customer user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.ROLE_USER);
        customerRepository.save(user);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Optional<Customer> loadUserByUsername(String username){
        return customerRepository.findByUsername(username);
    }
}
