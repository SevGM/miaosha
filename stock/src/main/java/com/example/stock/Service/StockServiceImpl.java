package com.example.stock.Service;

import com.example.stock.Dao.StockMapper;
import com.example.stock.Entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    StockMapper stockMapper;

    @Override
    public List<Stock> getAll() {
        return stockMapper.getAllStock();
    }
}
