package com.example.stock.Service;

import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

public interface PolicyService {
    Map<String, Object> insertPolicy(BigInteger skuId, BigInteger price,
                                     BigInteger quanty, Timestamp beginTime,
                                     Timestamp endTime);
}
