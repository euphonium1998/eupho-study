package com.example.demo.controller;

import com.example.demo.entity.ProductNote;
import com.example.demo.service.ProductNoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productNote")
@CrossOrigin
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

    @PostMapping(value = "/updateNoteTextByNoteId")
    public void updateNoteTextByNoteId(@RequestBody int id, @RequestBody String text) {
        productNoteService.updateNoteTextByNoteId(id, text);
    }
}
