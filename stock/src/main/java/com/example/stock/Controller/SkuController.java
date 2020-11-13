package com.example.stock.Controller;

import com.example.stock.Service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SkuController {
    @Autowired
    private SkuService skuService;

    @RequestMapping(value = "/getStockList")
    public Map<String, Object> getStockList(){
        return skuService.getStockList();
    }

}
