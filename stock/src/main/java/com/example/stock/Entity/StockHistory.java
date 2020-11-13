package com.example.stock.Entity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StockHistory {
    // id
    BigInteger id;
    // 库存主表id
    BigInteger stockStorageId;
    // 入库数量
    BigDecimal inQuanty;
    // 出库数量
    BigDecimal outQuanty;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getStockStorageId() {
        return stockStorageId;
    }

    public void setStockStorageId(BigInteger stockStorageId) {
        this.stockStorageId = stockStorageId;
    }

    public BigDecimal getInQuanty() {
        return inQuanty;
    }

    public void setInQuanty(BigDecimal inQuanty) {
        this.inQuanty = inQuanty;
    }

    public BigDecimal getOutQuanty() {
        return outQuanty;
    }

    public void setOutQuanty(BigDecimal outQuanty) {
        this.outQuanty = outQuanty;
    }

    @Override
    public String toString() {
        return "StockHistory{" +
                "id=" + id +
                ", stockStorageId=" + stockStorageId +
                ", inQuanty=" + inQuanty +
                ", outQuanty=" + outQuanty +
                '}';
    }
}
