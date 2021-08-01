package com.example.demo.service.impl;

import com.example.demo.entity.Vendor;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductNoteService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Vendor selectVendorByProdId(String id) {
        Vendor vendor = productMapper.selectVendorByProdId(id);
        return vendor;
    }
}
