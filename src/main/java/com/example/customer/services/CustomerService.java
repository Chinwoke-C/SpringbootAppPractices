package com.example.customer.services;

import com.example.customer.dtos.CustomerRequest;
import com.example.customer.model.Customer;
import com.example.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    public void addCustomer(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAge(request.getAge());
        repository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    public void deleteCustomerById(String id) {
        repository.deleteById(id);
    }
}
