package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String prodID;
    private int vendID;
    private String prodName;
    private BigDecimal prodPrice;
    private String prodDesc;

}
