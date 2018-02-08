package com.example.service;

import com.example.domain.ImsiMakeCardPO;
import com.example.mapper.one.ImsiMakeCardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanglimin1 on 2016/12/9.
 */
@Service
public class DbService {

    @Autowired
    private ImsiMakeCardDAO imsiMakeCardDAO;

    public ImsiMakeCardPO selectByPrimaryKey(long id) {
        return imsiMakeCardDAO.selectByPrimaryKey(id);
    }

    public int addPo(ImsiMakeCardPO po){
        return imsiMakeCardDAO.insert(po);
    }
}
