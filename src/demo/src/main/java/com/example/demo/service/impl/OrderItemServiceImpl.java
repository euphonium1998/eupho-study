package com.example.demo.service.impl;

import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 西云研究所
 * @date 2021/7/30
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void deleteByNumAndItem(int num, int item) {
        orderItemMapper.deleteByNumAndItem(num, item);
    }
}
