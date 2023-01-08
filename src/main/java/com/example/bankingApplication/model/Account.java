package com.example.bankingApplication.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
@Builder
public class Account {
    @Id
    private String id;
    private Long customerId;
    private double accBalance;
    private String accNumber;
  private LocalDateTime creationDate = LocalDateTime.now();

}
