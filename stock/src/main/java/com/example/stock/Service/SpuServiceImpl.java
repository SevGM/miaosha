package com.example.stock.Service;

import com.example.stock.Dao.SpuMapper;
import com.example.stock.Entity.Spu;
import com.example.stock.Entity.SpuDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService{
    @Autowired
    private SpuMapper spuMapper;

    @Override
    public Map<String, Object> searchSpu(BigInteger spuId) {
        List<Spu> searchRes = spuMapper.searchSpu(spuId);
        Map<String, Object> res = new HashMap<>();
        if(searchRes == null || searchRes.size() == 0){
            res.put("msg", "查询失败");
            res.put("result", false);
        }else {
            res.put("msg", "查询成功");
            res.put("result", true);
            res.put("list", searchRes);
        }
        return res;
    }


    @Override
    public Map<String, Object> spuDetail(BigInteger spuId) {
        List<SpuDetail> spuDetail = spuMapper.spuDetail(spuId);
        Map<String, Object> res = new HashMap<>();
        if(spuDetail == null || spuDetail.size() == 0){
            res.put("msg", "查询失败");
            res.put("result", false);
        }else {
            res.put("msg", "查询成功");
            res.put("result", true);
            res.put("list", spuDetail);
        }
        return res;
    }
}
