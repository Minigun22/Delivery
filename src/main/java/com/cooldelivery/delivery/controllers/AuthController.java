package com.cooldelivery.delivery.controllers;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.services.CustomerService;
import com.cooldelivery.delivery.util.CustomerValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final CustomerValidator customerValidator;
    private final CustomerService customerService;
    @Autowired
    public AuthController(CustomerValidator customerValidator, CustomerService customerService) {
        this.customerValidator = customerValidator;
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "customer/login";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("customer")Customer customer){
        return "customer/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("customer") @Valid Customer customer,
                                      BindingResult bindingResult){
        customerValidator.validate(customer,bindingResult);
        if(bindingResult.hasErrors()){
            return "/customer/registration";
        }
        customerService.save(customer);
        return "redirect:/login";
    }

}

