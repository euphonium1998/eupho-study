package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
@Mapper
@Component
public interface CustomerMapper {
    Customer selectCustomerByOrderNum(@Param("num") int num);

    void deleteCustomerByName(@Param("name")String name);
    int saveCustomer(@Param("customer") Customer customer);
}
