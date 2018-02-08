package com.example.web;

import com.example.domain.ImsiMakeCardPO;
import com.example.service.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanglimin1 on 2016/12/8.
 */
@RestController
public class DbController {

    private Logger logger = LoggerFactory.getLogger(DbController.class);

    @Autowired
    private DbService dbService;

    @GetMapping("/db")
    public ImsiMakeCardPO index() {
        logger.info("============i am exec . ===============");
        return dbService.selectByPrimaryKey(28);
    }


    @GetMapping("/db1")
    @Transactional(value = "txManager1")
    public int index1() {
        ImsiMakeCardPO po = new ImsiMakeCardPO();
        po.setOrderId("900");
        dbService.addPo(po);
        //throw new RuntimeException("my");
        return 1;
    }
}
