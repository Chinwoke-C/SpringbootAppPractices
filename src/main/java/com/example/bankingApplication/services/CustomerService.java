package com.example.bankingApplication.services;

import com.example.bankingApplication.dtos.CustomerRequest;
import com.example.bankingApplication.model.Customer;
import com.example.bankingApplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    public void addCustomer(CustomerRequest request) {
        Customer customer = mapFromDto(request);
        repository.save(customer);

    }

    private Customer mapFromDto(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .phoneNumber(request.getPhoneNumber())
                .pin(request.getPin())
                .password(request.getPassword())
                .build();
    }

}
