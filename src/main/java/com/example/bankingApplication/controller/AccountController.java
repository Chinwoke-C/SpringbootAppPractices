package com.example.bankingApplication.controller;

import com.example.bankingApplication.dtos.AccountRequest;
import com.example.bankingApplication.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody AccountRequest request){
    accountService.saveAccount(request);
    return "Saved Successfully";
    }
}
