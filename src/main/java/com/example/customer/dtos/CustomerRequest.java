package com.example.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
}
