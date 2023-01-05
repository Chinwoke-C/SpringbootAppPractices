package com.example.bankingApplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document
public class MoneyTransfer {
    @Id
    private String id;
    private long accountIdFrom;
    private long accountIdTo;
    private double amount;
    private LocalDateTime transferTime = LocalDateTime.now();
}
