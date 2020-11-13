package com.example.stock.Dao;

import com.example.stock.Entity.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface SkuMapper {
    @Select("SELECT id,title,stock,price,indexes,own_spec FROM tb_sku")
    List<Sku> getStockList();
}
