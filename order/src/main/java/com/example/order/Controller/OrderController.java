package com.example.order.Controller;

import com.example.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/creatOrder")
    public Map<String, Object> creatOrder(@RequestParam("sku_id") String skuID,
                                          @RequestParam("user_id") String userID){
        return orderService.createOrder(skuID, userID);
    }
}
