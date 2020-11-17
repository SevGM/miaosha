package com.example.stock.Service;

import com.example.stock.Dao.PolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class PolicyServiceImpl implements PolicyService{
    @Autowired
    PolicyMapper policyMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, Object> insertPolicy(BigInteger skuId, BigInteger price,
                                            BigInteger quanty, Timestamp beginTime, Timestamp endTime) {
        /**
         * 插入秒杀政策到mysql，如果插入成功，将政策写入redis
         */
        // 判断是否插入成功
        boolean insertSuccess = policyMapper.insertPolicy(skuId, price, quanty, beginTime, endTime) != 0 ? true:false;
        Map<String, Object> res = new HashMap<>();
//        if(isSuccess){
//            res.put("msg", "插入成功");
//            res.put("result", true);
//        }
        // 插入mysql失败，返回提示信息
        if(!insertSuccess){
            res.put("msg", "插入政策失败");
            res.put("result", false);
        }


        return res;
    }
}
