package com.example.customer.services;

import com.example.customer.dtos.CustomerRequest;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.model.Customer;
import com.example.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    public void addCustomer(CustomerRequest request) {
//        Customer customer = new Customer();
//        customer.setFirstName(request.getFirstName());
//        customer.setLastName(request.getLastName());
//        customer.setPhoneNumber(request.getPhoneNumber());
//        customer.setAge(request.getAge());
       Customer customer = mapFromDto(request);
        repository.save(customer);
    }

    private Customer mapFromDto(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .age(request.getAge())
                .build();
    }


    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    public void deleteCustomerById(String id) {
        repository.deleteById(id);
    }

    public CustomerRequest findCustomer(String id) {
        Customer customer = repository.findCustomerById(id).orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot Find Customer By Id: %s", id)));
        return mapToDto(customer);
    }

    private CustomerRequest mapToDto(Customer customer) {
        return CustomerRequest.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getPhoneNumber())
                .age(customer.getAge())
                .build();
    }

    public void updateCustomer(String id, String firstName, String lastName, String phoneNumber) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isEmpty()) throw new IllegalArgumentException("Customer with id"+id+"not found");
        if (firstName != null && firstName.length() > 0) {customer.get().setFirstName(firstName);}
        if (lastName != null && lastName.length() > 0) {customer.get().setLastName(lastName);}
        if (phoneNumber != null && phoneNumber.length() > 0) {customer.get().setPhoneNumber(phoneNumber);}
        repository.save(customer.get());
    }
}
