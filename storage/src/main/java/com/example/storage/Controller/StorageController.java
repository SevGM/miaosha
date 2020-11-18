package com.example.storage.Controller;

import com.example.storage.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

@RestController
public class StorageController {
    @Autowired
    StorageService storageService;

    @PostMapping(value = "/insertStorage")
    public Map<String, Object> insertStorage(@RequestParam("sku_id") BigInteger skuID,
                                             @RequestParam("warehouse_id") BigInteger warehouseID,
                                             @RequestParam("in_quanty") BigDecimal inQuanty,
                                             @RequestParam("out_quanty") BigDecimal outQuanty){
        return storageService.insertStorage(skuID, warehouseID, inQuanty, outQuanty);
    }
}
