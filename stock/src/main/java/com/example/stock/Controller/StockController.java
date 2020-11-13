package com.example.stock.Controller;

import com.example.stock.Entity.Stock;
import com.example.stock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;

    @RequestMapping(value = "/getAll")
    public List<Stock> getAll(){
        return stockService.getAll();
    }
}
