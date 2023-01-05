package com.example.bankingApplication.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Customer {
    @Id
    private  String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private int pin;
    private int age;

}
