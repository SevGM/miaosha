package com.example.stock.Controller;

import com.example.stock.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

@RestController
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @PostMapping("/insertPolicy")
    public Map<String, Object> insertPolicy(@RequestParam("sku_id") BigInteger skuId,
                                            @RequestParam("price") BigInteger price,
                                            @RequestParam("quanty") BigInteger quanty,
                                            @RequestParam("begin_time") Timestamp beginTime,
                                            @RequestParam("end_time") Timestamp endTime) {
        return policyService.insertPolicy(skuId, price, quanty, beginTime, endTime);
    }
}
