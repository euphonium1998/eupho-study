package com.example.demo.service;

import com.example.demo.entity.Vendor;

public interface ProductService {

    Vendor selectVendorByProdId(String id);
}
