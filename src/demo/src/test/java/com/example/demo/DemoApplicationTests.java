package com.example.demo;

import com.example.demo.entity.ProductNote;
import com.example.demo.entity.Vendor;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.ProductNoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private ProductNoteMapper productNoteMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<ProductNote> productNoteList = productNoteMapper.selectAllProductNote();
        System.out.println(productNoteList);
        log.debug("All product notes = {}", productNoteList);
    }

    @Test
    void testVendor() {
        Vendor vendor = productMapper.selectVendorByProdId("FB");
        System.out.println(vendor);
    }

    @Test
    void testUpdate() {
        ProductNote productNote =  productNoteMapper.selectByNoteId(101);
        System.out.println(productNote.getNoteText());
        productNoteMapper.updateProdTextById(101,"HITSZ");
        ProductNote productNote1 = productNoteMapper.selectByNoteId(101);
        System.out.println(productNote1.getNoteText());
    }

}
