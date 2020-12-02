package com.example.order.Dao;

import com.example.order.Entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO tb_order(order_id,total_fee,actual_fee,payment_type," +
            "post_fee,user_id) VALUES(#{orderId},#{totalFee},#{actualFee}," +
            "#{paymentType},#{postFee},#{userId})")
    int insertOrder(Order order);
}
