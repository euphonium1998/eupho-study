package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

    private int vendId;
    private String vendName;
    private String vendAddress;
    private String vendCity;
    private String vendState;
    private String vendZip;
    private String vendCountry;
}
