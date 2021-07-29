package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 西云研究所
 * @date 2021/7/29
 */
public interface CustomerService {
    Map selectCustomerByOrderNum(int num);

    void deleteCustomerByName(String name);
}
