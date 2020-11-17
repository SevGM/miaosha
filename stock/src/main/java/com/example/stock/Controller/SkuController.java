package com.example.stock.Controller;

import com.example.stock.Service.SkuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
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

    @PostMapping(value = "/getStock")
    public Map<String, Object> getStock(@RequestParam("sku_id") BigInteger skuId){
        return skuService.getStock(skuId);
    }
}
