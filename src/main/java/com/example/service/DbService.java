package com.example.service;

import com.example.domain.Order;
import com.example.mapper.one.OrderMapper;
import com.example.mapper.two.OrderOtherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanglimin1 on 2016/12/9.
 */
@Service
public class DbService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderOtherMapper orderOtherMapper;

    public Order getOrderSingleton1(long l) {
        return orderMapper.getOrderSingleton(l);
    }

    public Order getOrderSingleton2(long l) {
        return orderOtherMapper.getOrderSingleton(l);
    }
}
