package com.example.mapper.two;


import com.example.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOtherMapper {
    Order getOrderSingleton(Long id);
}