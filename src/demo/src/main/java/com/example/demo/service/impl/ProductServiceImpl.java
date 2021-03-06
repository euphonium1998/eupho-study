package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> selectProductByPrice(String priceLowerBound) {
        return productMapper.selectProductByPrice(new BigDecimal(priceLowerBound));
    }

    @Override
    public Vendor selectVendorByProdId(String id) {
        return  productMapper.selectVendorByProdId(id);
    }
}
