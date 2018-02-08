package com.example.mapper.one;


import com.example.domain.ImsiMakeCardPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImsiMakeCardDAO {

    ImsiMakeCardPO selectByPrimaryKey(Long seqId);

    int insert(ImsiMakeCardPO po);
}