package com.example.demo.mapper;

import com.example.demo.entity.Vendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper {

    Vendor selectVendorByProdId(@Param("id") String id);

}
