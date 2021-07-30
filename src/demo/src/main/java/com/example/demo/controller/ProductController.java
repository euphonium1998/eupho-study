package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "selectProductByPrice", method = RequestMethod.POST)
    public List<Map<String,String>> selectProductByPrice (@RequestBody Product product){
        return productService.selectProductByPrice(product.getProdPrice());
    }

}
