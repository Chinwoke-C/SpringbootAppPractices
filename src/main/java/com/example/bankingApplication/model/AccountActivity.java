package com.example.bankingApplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class AccountActivity {
    @Id
    private String id;
    private long accountId;
    private double amount;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private double currentBalance;
}
