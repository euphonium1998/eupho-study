package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author 西云研究所
 * @date 2021/7/29
 */
@Mapper
@Component
public interface CustomerMapper {
    Customer selectCustomerByOrderNum(@Param("num") int num);

    void deleteCustomerByName(@Param("name")String name);
}
