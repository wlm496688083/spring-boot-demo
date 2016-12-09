package com.example.mapper.one;


import com.example.domain.Order;
import org.springframework.stereotype.Repository;

//Mapper
@Repository
public interface OrderMapper {
    Order getOrderSingleton(Long id);
}