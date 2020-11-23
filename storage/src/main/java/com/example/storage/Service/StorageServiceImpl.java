package com.example.storage.Service;

import com.example.storage.Dao.StorageMapper;
import com.example.storage.Entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    /**
     *
     * @param skuID
     * @param warehouseID
     * @param inQuanty
     * @param outQuanty
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> insertStorage(BigInteger skuID, BigInteger warehouseID,
                                             BigDecimal inQuanty, BigDecimal outQuanty) {
        /**
         * 插入库存
         */
        Map<String, Object> res = new HashMap<>();
        List<Storage> storageList = storageMapper.getStorage(skuID);
        if(storageList == null || storageList.size() == 0) {
            // 主表中不存在，直接插入
            // 判断outquanty是否合法
            if(outQuanty.compareTo(BigDecimal.ZERO) != 0){
                res.put("msg", "库存中不存在该物品，只能进行添加操作！");
                res.put("result", false);
                return res;
            }
            // 插入库存主表
            storageMapper.insertStorage(skuID, warehouseID, inQuanty); // 在storage表中添加记录
            BigInteger storageID = storageMapper.getStorage(skuID).get(0).getId();
            storageMapper.insertStockHistory(storageID, inQuanty, outQuanty);
        } else {
            storageMapper.insertStockHistory(storageList.get(0).getId(),
                    inQuanty, outQuanty); // 先修改历史表
            BigDecimal changeQuanty= inQuanty.subtract(outQuanty); // 增加的
            storageMapper.updateStorage(skuID,changeQuanty); // 修改主表
        }
        res.put("msg", "库存更改成功！");
        res.put("result", true);
        return res;
    }
}
