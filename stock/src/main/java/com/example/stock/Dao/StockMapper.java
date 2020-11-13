package com.example.stock.Dao;

import com.example.stock.Entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockMapper {

    @Select("SELECT * FROM tb_stock_storage")
    List<Stock> getAllStock();

}
