package com.example.stock.Service;

import com.alibaba.fastjson.JSON;
import com.example.stock.Dao.SkuMapper;
import com.example.stock.Entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SkuServiceImpl implements SkuService{
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Map<String, Object> getStockList() {
        /**
         * 查询数据库中存在库存的商品
         * 若查询成功返回result，msg,list
         * 其余未查询的项为null
         * 同时对于redis存储了秒杀政策的sku会将对应政策取出
         */
        List<Sku> skuList = this.skuMapper.getStockList();
        return this.getPolicy(skuList);
    }

    @Override
    public Map<String, Object> getStock(BigInteger skuID) {
        List<Sku> sku = this.skuMapper.getStock(skuID);
        return this.getPolicy(sku);
    }

    private Map<String, Object> getPolicy(List<Sku> skuList){
        /**
         * 将得到的sku，对应到redis中取出秒杀政策并返回
         */
        Map<String, Object> res = new HashMap<>();
        if(skuList.size() == 0 || skuList == null){
            res.put("msg", "数据库没有查询到sku数据！");
            res.put("result", false);
            return res;
        }
        List<Map<String, Object>> skus = new ArrayList<>();
        for(int i = 0; i < skuList.size(); ++i) {
            // 将sku实体转为Map，并对应添加政策信息
            // 取redis的政策
            Map sku = JSON.parseObject(JSON.toJSONString(skuList.get(i)), Map.class);
            String policy = stringRedisTemplate.opsForValue().get("LIMIT_POLICY_" + sku.get("id").toString());
            if(policy != null && !policy.equals("")){
                // 若redis中存在政策，则将政策信息加入sku中
                Map<String, Object> policyInfo = JSON.parseObject(policy, Map.class);
                // 时间格式化
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    // 判断时间是否符合要求
                    // 开始时间<=当前时间，当前时间<=结束时间
                    Date start = simpleDateFormat.parse(policyInfo.get("begin_time").toString());
                    Date end = simpleDateFormat.parse(policyInfo.get("end_time").toString());
                    Date now = simpleDateFormat.parse(restTemplate.getForObject("http://time-server/getTime", String.class));
                    if(start.getTime() <= now.getTime() && now.getTime() <= end.getTime()){
                        // 赋值：limit_price, limit_quanty, limit_begin_time, limit_end_time,now_time
                        sku.put("limit_price", policyInfo.get("price"));
                        sku.put("limit_quanty", policyInfo.get("quanty"));
                        sku.put("limit_begin_time", policyInfo.get("begin_time"));
                        sku.put("limit_end_time", policyInfo.get("end_time"));
                        sku.put("limit_end_time", now);
                    }
                }catch (ParseException e){
                    e.printStackTrace();
                    res.put("msg", "时间转换失败！");
                    res.put("result", false);
                    return res;
                }
            }
            skus.add(sku);

        }
        res.put("msg", "查询成功！");
        res.put("result", true);
        res.put("list", skus);
        return res;
    }
}
