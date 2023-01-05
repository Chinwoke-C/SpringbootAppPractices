package com.example.bankingApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private int age;
    private int pin;
}
