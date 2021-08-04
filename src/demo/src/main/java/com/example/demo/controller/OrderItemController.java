package com.example.demo.controller;

import com.example.demo.service.OrderItemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 西云研究所
 * @date 2021/7/30
 */
@CrossOrigin
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/deleteByNumAndItem")
    public void deleteByNumAndItem(@Param("num")int num, @Param("item")int item){
        orderItemService.deleteByNumAndItem(num, item);
    }
}
