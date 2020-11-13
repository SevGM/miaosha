package com.example.stock.Service;

import com.example.stock.Entity.Sku;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface SpuService {
    Map<String, Object> searchSpu(BigInteger spuId);

    Map<String, Object> spuDetail(BigInteger spuId);
}
