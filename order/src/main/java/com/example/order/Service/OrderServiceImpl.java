package com.example.order.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.order.Entity.Order;
import com.example.order.Entity.Policy;
import com.example.order.Entity.Sku;
import com.example.order.Queue.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService{
//    @Autowired
//    OrderMapper orderMapper;
//
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 传入skuID,userID, 判断政策是否有效，若有效则生成相应的order,
     * 将order信息放入消息队列，等待其他模块消费
     *
     * @param skuId
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> createOrder(String skuId, String userId) {
        Map<String, Object> res = new HashMap<>();

        BigInteger orderId = BigInteger.valueOf(System.currentTimeMillis());
        String policyString = stringRedisTemplate.opsForValue().get("LIMIT_POLICY_" + skuId); // redis中取出的是String
        if(policyString == null || policyString.equals("")) {
            res.put("msg", "当前sku不存在秒杀政策");
            res.put("result", false);
            return res;
        } else {
            Policy policy = JSONObject.parseObject(policyString, Policy.class); // 将String转为Policy类型

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date now = simpleDateFormat.parse(restTemplate.getForObject("http://time-server/getTime", String.class));
                Date start = simpleDateFormat.parse(policy.getBeginTime().toString());
                Date end = simpleDateFormat.parse(policy.getEndTime().toString());
                if(start.getTime() <= now.getTime() && now.getTime() <= end.getTime()){
                    // 时间符合
                    // 判断商品数量
                    int limitQuanty = Integer.parseInt(policy.getQuanty().toString());
                    // increment(), redis计数器，获取指定key的值进行加1
                    // 如果value不是integer类型，会抛异常，如果key不存在会创建一个，默认value为0
                    if(stringRedisTemplate.opsForValue().increment("SKU_QUANTY_" + skuId, 1) <= limitQuanty){
                        // 还有余量，此时redis中已经将商品售出的数量+1
                        // 获取对应sku的详细信息，以便生成订单
                        String skuString = stringRedisTemplate.opsForValue().get("SKU_"+skuId);
                        Sku sku = JSONObject.parseObject(skuString, Sku.class);

                        Order orderInfo = new Order();
                        orderInfo.setOrderId(orderId);
                        orderInfo.setTotalFee(sku.getPrice());
                        orderInfo.setActualFee(sku.getPrice());
                        orderInfo.setPaymentType(1);
                        orderInfo.setPostFee(BigInteger.valueOf(11));
                        orderInfo.setUserId(BigInteger.valueOf(Long.valueOf(userId)));
//                        orderInfo.setCreateTime(Timestamp.valueOf(simpleDateFormat.format(now.toString())));
                        try {
                            // 送入消息队列，等待修改数据库
                            rabbitTemplate.convertAndSend(RabbitConfig.orderExchange, RabbitConfig.orderRouting, orderInfo);
                        } catch (Exception e){
                            res.put("msg", "写入队列失败");
                            res.put("result", false);
                            return res;
                        }
                    }else{
                        res.put("msg", "商品已售完！");
                        res.put("result", false);
                        return res;
                    }

                }else{
                    res.put("msg", "已经过了秒杀期限！");
                    res.put("result", false);
                    return res;
                }

            } catch (ParseException e){
                e.printStackTrace();
                res.put("msg", "时间转换失败！");
                res.put("result", false);
                return res;
            }

        }
        res.put("result", true);
        res.put("msg", "订单生成成功，请付款");
        res.put("order_id", orderId);
        return res;
    }

    @Override
    public Map<String, Object> insertOrder(Order order) {
        return null;
    }
}
