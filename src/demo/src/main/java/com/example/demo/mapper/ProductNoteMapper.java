package com.example.demo.mapper;

import com.example.demo.entity.ProductNote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductNoteMapper {

    List<ProductNote> selectAllProductNote();

    ProductNote selectByNoteId(@Param("id") int id);

    void updateProdTextById(@Param("id") int id, @Param("text") String text);
}
