package com.cooldelivery.delivery.services;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.repositories.CustomerRepository;
import com.cooldelivery.delivery.security.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if(customer.isEmpty()){
            throw  new UsernameNotFoundException("Користувача з таким логинои не знайдено");
        }
        return new CustomerDetails(customer.get());
    }
}
