package com.example.demo.controller;

import com.example.demo.entity.ProductNote;
import com.example.demo.service.ProductNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productNote")
public class ProductNoteController {

    @Autowired
    private ProductNoteService productNoteService;

    @RequestMapping(value = "/selectAllProductNote", method = RequestMethod.GET)
    public List<ProductNote> selectAllProductNote() {
        return productNoteService.selectAllProductNote();
    }

    @RequestMapping(value = "/selectByNoteId", method = RequestMethod.POST)
    public ProductNote selectByNoteId(@RequestBody ProductNote productNote) {
        return productNoteService.selectByNoteId(productNote.getNoteId());
    }
}
