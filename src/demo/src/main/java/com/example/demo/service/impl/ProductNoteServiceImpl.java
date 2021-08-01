package com.example.demo.service.impl;

import com.example.demo.entity.ProductNote;
import com.example.demo.mapper.ProductNoteMapper;
import com.example.demo.service.ProductNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductNoteServiceImpl implements ProductNoteService {

    @Autowired
    private ProductNoteMapper productNoteMapper;


    @Override
    public List<ProductNote> selectAllProductNote() {
        return productNoteMapper.selectAllProductNote();
    }

    @Override
    public ProductNote selectByNoteId(int id) {
        return productNoteMapper.selectByNoteId(id);
    }

    @Override
    public void updateProdTextById(int id, String text) {
        productNoteMapper.updateProdTextById(id, text);
    }
}
