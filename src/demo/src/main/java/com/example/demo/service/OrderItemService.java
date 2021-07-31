package com.example.demo.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author 西云研究所
 * @date 2021/7/30
 */
public interface OrderItemService {
    void deleteByNumAndItem(int num, int item);
}
