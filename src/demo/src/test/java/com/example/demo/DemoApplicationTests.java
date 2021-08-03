package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductNote;
import com.example.demo.entity.Vendor;
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
    void selectVendorTest() {
        Vendor vendor = productMapper.selectVendorByProdId("FB");
        System.out.println(vendor);
    }

}
