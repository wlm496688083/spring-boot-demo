package com.example.web;

import com.example.domain.Order;
import com.example.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanglimin1 on 2016/12/8.
 */
@RestController
public class DbController {

    @Autowired
    private DbService dbService;


    @GetMapping("/db1")
    public Order index1() {
        return dbService.getOrderSingleton1(42746860760L);
    }

    @GetMapping("/db2")
    public Order index2() {
        return dbService.getOrderSingleton2(42746860760L);
    }
}
