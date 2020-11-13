package com.example.stock.Service;

import com.example.stock.Dao.SkuMapper;
import com.example.stock.Entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements SkuService{
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Map<String, Object> getStockList() {
        /**
         * 查询数据库中存在库存的商品
         * 若查询成功返回result，msg,list
         */
        Map<String, Object> res = new HashMap<>();
        List<Sku> skuList =  this.skuMapper.getStockList();
        if(skuList.size() == 0 || skuList == null){
            res.put("msg", "数据库没有查询到数据！");
            res.put("result", false);
        }else{
            res.put("msg", "查询成功！");
            res.put("result", true);
            res.put("list", skuList);
        }
        return res;
    }
}
