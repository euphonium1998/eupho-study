package com.example.demo;

import com.example.demo.entity.ProductNote;
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

    @Test
    void contextLoads() {
        List<ProductNote> productNoteList = productNoteMapper.selectAllProductNote();
        log.debug("All product notes = {}", productNoteList);
    }

}
