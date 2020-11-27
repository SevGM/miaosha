package com.example.storage.Dao;

import com.example.storage.Entity.Storage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Mapper
public interface StorageMapper {

    @Select("SELECT * FROM tb_stock_storage")
    List<Storage> getAllStorage();

    @Select("SELECT * FROM tb_stock_storage WHERE sku_id=#{skuID}")
    List<Storage> getStorage(BigInteger skuID);

    @Insert("INSERT INTO tb_stock_storage(warehouse_id,sku_id,quanty) VALUES" +
            "(#{warehouseID},#{skuID},#{quanty})")
    int insertStorage(BigInteger skuID, BigInteger warehouseID, BigDecimal quanty);

    @Update("UPDATE tb_stock_storage SET quanty = quanty + #{changeQuanty} " +
            "WHERE sku_id = #{skuID} AND quanty + #{changeQuanty} >= 0")
    int updateStorage(BigInteger skuID, BigDecimal changeQuanty);

    @Insert("INSERT INTO tb_stock_storage_history(stock_storage_id,in_quanty,out_quanty)" +
            "VALUES(#{stockStorageID},#{inQuanty},#{outQuanty})")
    int insertStockHistory(BigInteger stockStorageID, BigDecimal inQuanty, BigDecimal outQuanty);

}
