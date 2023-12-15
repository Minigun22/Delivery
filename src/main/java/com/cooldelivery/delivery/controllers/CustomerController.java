package com.cooldelivery.delivery.controllers;

import com.cooldelivery.delivery.modells.customer.Customer;
import com.cooldelivery.delivery.security.CustomerDetails;
import com.cooldelivery.delivery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/myaccount")
    public String show(Model model){
        model.addAttribute("customer",showUserInfo());
        return "customer/show";
    }

    private Customer showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerDetails customerDetails = (CustomerDetails) authentication.getPrincipal();
        return customerDetails.getCustomer();
    }

}
