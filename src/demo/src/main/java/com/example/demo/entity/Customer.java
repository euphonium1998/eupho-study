package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int custId;
    private String custName;
    private String custAddress;
    private String custCity;
    private String custState;
    private String custZip;
    private String custCountry;
    private String custContact;
    private String custEmail;
}
