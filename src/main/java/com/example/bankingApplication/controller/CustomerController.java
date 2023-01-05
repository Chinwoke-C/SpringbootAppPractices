package com.example.bankingApplication.controller;

import com.example.bankingApplication.dtos.CustomerRequest;
import com.example.bankingApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    public String addNewCustomer(@RequestBody CustomerRequest request){
        service.addCustomer(request);

        return "Customer Added Successfully ";
    }
}
