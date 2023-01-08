package com.example.bankingApplication.services;

import com.example.bankingApplication.dtos.CustomerRequest;
import com.example.bankingApplication.model.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerRequest request);
    List<Customer> getAllCustomer();
     void deleteCustomerById(String id);
     CustomerRequest findCustomer(String id);
     void updateCustomer(String id, String firstName, String lastName,
                               String phoneNumber, String password, String pin, Integer age);
}
