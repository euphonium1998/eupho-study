package com.example.demo.service;

import com.example.demo.entity.ProductNote;

import java.util.List;

public interface ProductNoteService {

    List<ProductNote> selectAllProductNote();

    ProductNote selectByNoteId(int id);

    void updateProdTextById(int id, String text);
}
