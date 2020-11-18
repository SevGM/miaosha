package com.example.storage.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Storage implements Serializable {
    // id
    BigInteger id;
    // 库房id
    BigInteger warehouseId;
    // sku id
    BigInteger skuId;
    // 剩余数量
    BigDecimal quanty;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(BigInteger warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigInteger getSkuId() {
        return skuId;
    }

    public void setSkuId(BigInteger skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getQuanty() {
        return quanty;
    }

    public void setQuanty(BigDecimal quanty) {
        this.quanty = quanty;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", skuId=" + skuId +
                ", quanty=" + quanty +
                '}';
    }
}
