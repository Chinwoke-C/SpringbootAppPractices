package com.example.customer.controller;

import com.example.customer.dtos.CustomerRequest;
import com.example.customer.model.Customer;
import com.example.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @PostMapping("/add")
    public String addNewCustomer(@RequestBody CustomerRequest request){
        service.addCustomer(request);
        return "Successful";
    }
    @GetMapping("/all")
    public List<Customer> viewAllCustomer(){

        return service.getAllCustomer();
    }
    @DeleteMapping("{customerId}")
    public String deleteCustomer(@PathVariable("customerId") String id){
        service.deleteCustomerById(id);
        return "Deleted";
    }
}
