package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> selectProductByPrice(String priceLowerBound);

    Vendor selectVendorByProdId(String id);
}
