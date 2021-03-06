package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import com.example.demo.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/selectProductByPrice", method = RequestMethod.GET)
    public List<Product> selectProductByPrice (@RequestParam String priceLowerBound){
        return productService.selectProductByPrice(priceLowerBound);
    }

    @GetMapping(value = "/selectVendorByProdId")
    public Vendor selectVendorByProdId(@Param("id") String id) {
        return productService.selectVendorByProdId(id);
    }

}
