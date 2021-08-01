package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 西云研究所
 * @date 2021/7/29
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer selectCustomerByOrderNum(int num) {
        Customer customer = customerMapper.selectCustomerByOrderNum(num);
        return customer;
    }

    @Override
    public void deleteCustomerByName(String name) {
        customerMapper.deleteCustomerByName(name);
    }

    @Override
    public int saveCustomer(Customer customer) {
        return customerMapper.saveCustomer(customer);
    }
}
