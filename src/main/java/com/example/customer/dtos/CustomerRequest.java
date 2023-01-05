package com.example.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
}
