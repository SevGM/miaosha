package com.example.stock.Controller;

import com.example.stock.Service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Map;

@RestController
public class SpuController {
    @Autowired
    SpuService spuService;

    @RequestMapping(value = "/searchSpu", method = RequestMethod.POST)
    public Map<String, Object> searchSpu(@RequestParam("spuId") BigInteger spuId){
        /**
         * 传入商品spuid，获得商品简介
         */
        return spuService.searchSpu(spuId);
    }

    @RequestMapping(value = "/spuDetail", method = RequestMethod.POST)
    public Map<String, Object> spuDetail(@RequestParam("spuId") BigInteger spuId){
        /**
         * 传入商品id（spuid）,查询商品详情
         */
        return spuService.spuDetail(spuId);
    }
}
