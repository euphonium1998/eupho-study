package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.impl.CustomerServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="saveCustomer", method = RequestMethod.POST)
    @ResponseBody
    public int saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    @GetMapping("/selectCustomerByOrderNum")
    public Customer getCustomerByOrderNum(@Param("num")int num){
        return customerService.selectCustomerByOrderNum(num);
    }

    @PostMapping("/deleteCustomerByName")
    public void deleteCustomerByName(@Param("name")String name){
        customerService.deleteCustomerByName(name);
    }

}
