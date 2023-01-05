package com.example.customer.controller;

import com.example.customer.dtos.CustomerRequest;
import com.example.customer.exception.CustomerNotFoundException;
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
        try{
            service.addCustomer(request);
        return "Successful";
        }
        catch (CustomerNotFoundException e){
           return e.getMessage();
        }
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
    @GetMapping("{customerId}")
    public CustomerRequest findCustomerUsingId(@PathVariable("customerId") String id){
        return service.findCustomer(id);
    }
    @PutMapping("{customerId}")
    public String updateCustomerDetails(@PathVariable("customerId") String id,
                                        @RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName,
                                        @RequestParam(required = false) String phoneNumber){
        service.updateCustomer(id, firstName, lastName, phoneNumber);
        return "Updated Successfully";

    }
}
