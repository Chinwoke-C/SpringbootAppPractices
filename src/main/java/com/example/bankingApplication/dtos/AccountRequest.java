package com.example.bankingApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AccountRequest {
    private long customerId;
    private double accBalance;
    private String accNumber;
}
