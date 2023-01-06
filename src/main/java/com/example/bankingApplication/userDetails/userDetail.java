package com.example.bankingApplication.userDetails;

import com.example.bankingApplication.model.Customer;

public class userDetail {

    public static UserDetails create(Customer customer){

        String id = customer.getId();
        String password = customer.getPassword();
        String firstName = customer.getFirstName();

        return new UserDetails(id, password, firstName);
    }

}
