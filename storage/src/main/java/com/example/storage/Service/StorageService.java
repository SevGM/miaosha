package com.example.storage.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public interface StorageService {
    Map<String, Object> insertStorage(BigInteger skuID, BigInteger warehouseID, BigDecimal inQuanty,BigDecimal outQuanty);
}
