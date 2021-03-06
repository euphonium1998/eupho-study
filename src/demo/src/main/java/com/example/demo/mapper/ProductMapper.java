package com.example.demo.mapper;

import com.example.demo.entity.Product;
import com.example.demo.entity.Vendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface ProductMapper {
    //select products with price greater than x
    List<Product> selectProductByPrice(BigDecimal priceLowerBound);

    Vendor selectVendorByProdId(@Param("id") String id);
}
