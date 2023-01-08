package com.example.bankingApplication.controller;

import com.example.bankingApplication.dtos.CustomerRequest;
import com.example.bankingApplication.model.Customer;
import com.example.bankingApplication.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl service;
@PostMapping("/add")
    public String addNewCustomer(@RequestBody CustomerRequest request){
        service.addCustomer(request);
        return "Customer Added Successfully ";
    }
    @GetMapping("/all")
    public List<Customer> viewAllCustomers(){
        return service.getAllCustomer();
    }
    @DeleteMapping("{Id}")
    public String deleteCustomer(@PathVariable("Id") String id){
    service.deleteCustomerById(id);
        return "Deleted Successfully";
    }
    @GetMapping("{customerId}")
    public CustomerRequest viewCustomer(@PathVariable("customerId") String id){
        return service.findCustomer(id);
    }
    @PutMapping("{customerId}")
    public String updateCustomerDetails(@PathVariable("customerId") String id,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String phoneNumber,
        @RequestParam(required = false) String password,
        @RequestParam(required = false) String pin,
        @RequestParam(required = false) Integer age
    ){
service.updateCustomer(id, firstName, lastName, phoneNumber, password, pin, age);
        return "Updated Successfully";
    }
}
