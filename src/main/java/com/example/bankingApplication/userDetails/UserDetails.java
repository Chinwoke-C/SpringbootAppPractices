package com.example.bankingApplication.userDetails;

import com.example.bankingApplication.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private  String id;
    private String firstName;
    private String password;


}
