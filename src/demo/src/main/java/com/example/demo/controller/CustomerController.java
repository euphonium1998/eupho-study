package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="saveCustomer", method = RequestMethod.POST)
    @ResponseBody
    public int saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
