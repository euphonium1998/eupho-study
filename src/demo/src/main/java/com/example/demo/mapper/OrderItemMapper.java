package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author 西云研究所
 * @date 2021/7/30
 */
@Mapper
@Component
public interface OrderItemMapper {
    void deleteByNumAndItem(@Param("num")int num,@Param("item")int item);
}
