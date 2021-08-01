package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductNote;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.ProductNoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private ProductNoteMapper productNoteMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void contextLoads() {
        List<ProductNote> productNoteList = productNoteMapper.selectAllProductNote();
        log.debug("All product notes = {}", productNoteList);
    }

    @Test
    void selectProductTest() {
        List<Product> productList = productMapper.selectProductByPrice(new BigDecimal("10.00"));
        List<String> prodNames = productList.stream().map(Product::getProdName).collect(Collectors.toList());
        List<String> prodDescriptions = productList.stream().map(Product::getProdDesc).collect(Collectors.toList());
        for(int i = 0; i < productList.size(); i++) {
            log.debug("product name:"+prodNames.get(i)+" product description:"+prodDescriptions.get(i));
        }
    }

    @Test
    void saveCustomerTest() {
        Customer newCustomer = new Customer(0, "testName2", "testAddress2", "testCity2", "CHINA", "testZip2",
                "testCountry2", "testContact2",
                "testEmail2");
        int ret = customerMapper.saveCustomer(newCustomer);
        if(ret == 1) {
            log.debug("customer insert success:"+newCustomer);
        }
    }


}
