package com.example.bankingApplication.services;

import com.example.bankingApplication.dtos.CustomerRequest;
import com.example.bankingApplication.model.Customer;
import com.example.bankingApplication.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements CustomerService{
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

    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    public void deleteCustomerById(String id) {
        repository.deleteById(id);
    }
    public CustomerRequest findCustomer(String id) {
        return repository.findCustomerById(id);
    }

    public void updateCustomer(String id, String firstName, String lastName,
                               String phoneNumber, String password, String pin, Integer age) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isEmpty()) throw new IllegalArgumentException("Customer With Id "+id+" Not Found");
        if (firstName != null && firstName.length() > 0) customer.get().setFirstName(firstName);
        if (lastName != null && lastName.length() > 0) customer.get().setLastName(lastName);
        if (phoneNumber != null && phoneNumber.length() > 0) customer.get().setPhoneNumber(phoneNumber);
        if (password != null && password.length() > 0) customer.get().setPassword(password);
        if (pin != null && pin.length() > 0) customer.get().setPin(pin);
        if (age != null && age.toString().length() > 0) customer.get().setAge(age);
        repository.save(customer.get());
    }
}
