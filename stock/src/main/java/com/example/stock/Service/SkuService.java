package com.example.stock.Service;

import com.example.stock.Entity.Sku;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface SkuService {
    Map<String, Object> getStockList();

    Map<String, Object> getStock(BigInteger skuID);


}
