package com.cooldelivery.delivery.util;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    private CustomerService customerService;
    @Autowired
    public CustomerValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if(customerService.loadUserByUsername(customer.getUsername()).isPresent()){
            errors.rejectValue("username","","Такий логін вже зареєстрований");
        }
    }
}
