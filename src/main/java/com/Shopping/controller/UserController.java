package com.Shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Shopping.model.BillingAddress;
import com.Shopping.model.Customer;
import com.Shopping.model.ShippingAddress;
import com.Shopping.model.User;
import com.Shopping.service.CustomerService;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    // Registration Form (GET)
    @GetMapping("/customer/registration")
    public String getRegistrationForm(Model model) {
        Customer customer = new Customer();
        User user = new User();
        BillingAddress ba = new BillingAddress();
        ShippingAddress sa = new ShippingAddress();
        customer.setShippingAddress(sa);
        customer.setBillingAddress(ba);
        customer.setUsers(user);

        model.addAttribute("customer", customer);
        return "register";
    }

    // Register Customer (POST)
    @PostMapping("/customer/registration")
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        customerService.addCustomer(customer);
        model.addAttribute("registrationSuccess", "Registered Successfully. Login using username and password");
        return "login";
    }
}
