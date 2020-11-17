package com.example.stock.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.stock.Dao.PolicyMapper;
import com.example.stock.Dao.SkuMapper;
import com.example.stock.Entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class PolicyServiceImpl implements PolicyService{
    @Autowired
    PolicyMapper policyMapper;

    @Autowired
    SkuMapper skuMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Override
    @Transactional // 将方法中的数据库操作变成事务
    public Map<String, Object> insertPolicy(BigInteger skuId, BigInteger price,
                                            BigInteger quanty, Timestamp beginTime, Timestamp endTime) {
        /**
         * 插入秒杀政策到mysql，如果插入成功，将政策写入redis
         * 同时将相关的sku信息插入
         */
        // 判断是否插入成功
        boolean insertSuccess = policyMapper.insertPolicy(skuId, price, quanty, beginTime, endTime) != 0 ? true:false;
        Map<String, Object> res = new HashMap<>();
        if(!insertSuccess){
            res.put("msg", "插入政策失败");
            res.put("result", false);
            return res;
        }

        // 写入redis
        // 政策：key:LIMIT_POLICY_skuid, value: policy --> String
        // redis有效期：结束时间减去当前时间

        // 将政策存入HashMap,方便后面转为JSON存入redis
        Map<String, Object> policyMap = new HashMap<>();
        policyMap.put("sku_id", skuId);
        policyMap.put("price", price);
        policyMap.put("quanty", quanty);
        policyMap.put("begin_time", beginTime);
        policyMap.put("end_time", endTime);
        String policy = JSONObject.toJSONStringWithDateFormat(policyMap, "yyyy-MM-dd HH:mm:ss",
                SerializerFeature.WriteDateUseDateFormat);
        // 时间格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long diff = 0; // 数据在redis中的过期时间
        String now = restTemplate.getForObject("http://time-server/getTime", String.class); // 使用微服务名
        // 计算保存的时间
        try {
            Date end_time = simpleDateFormat.parse(endTime.toString());
            Date now_time = simpleDateFormat.parse(now);
            diff = (end_time.getTime() - now_time.getTime()) / 1000;
            if (diff <= 0){
                res.put("msg", "结束时间需要晚与当前的时间！");
                res.put("result", false);
                return res;
            }
        } catch (ParseException e){
            e.printStackTrace();
            res.put("msg", "时间转换失败！");
            res.put("result", false);
            return res;

        }
        // 政策写入redis
        stringRedisTemplate.opsForValue().set("LIMIT_POLICY_" + skuId, policy, diff, TimeUnit.SECONDS);
        List<Sku> skuList = skuMapper.getStock(skuId);

        // sku写入redis
        stringRedisTemplate.opsForValue().set("SKU_" + skuId ,JSON.toJSONString(skuList.get(0)),
                diff, TimeUnit.SECONDS);
        res.put("msg", "政策写入完毕！");
        res.put("result", true);
        return res;
    }
}
