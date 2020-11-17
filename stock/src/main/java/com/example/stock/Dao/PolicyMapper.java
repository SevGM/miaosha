package com.example.stock.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.sql.Timestamp;

@Mapper
public interface PolicyMapper {


    // 插入成功返回1，否则返回0
    @Insert("INSERT INTO tb_limit_policy(sku_id,quanty,price,begin_time,end_time) " +
            "VALUES(#{skuId},#{quanty},#{price},#{beginTime},#{endTime})")
    int insertPolicy(BigInteger skuId, BigInteger price, BigInteger quanty,
                     Timestamp beginTime, Timestamp endTime);
}
