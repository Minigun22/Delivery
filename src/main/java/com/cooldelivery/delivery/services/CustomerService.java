package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository userRepository;

    public CustomerService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(Customer user){
        userRepository.save(user);
    }
}
