package com.example.order.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Policy implements Serializable {
    BigInteger id;
    BigInteger skuId;
    BigInteger quanty;
    BigInteger price;
    Timestamp beginTime;
    Timestamp endTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getSkuId() {
        return skuId;
    }

    public void setSkuId(BigInteger skuId) {
        this.skuId = skuId;
    }

    public BigInteger getQuanty() {
        return quanty;
    }

    public void setQuanty(BigInteger quanty) {
        this.quanty = quanty;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", skuId=" + skuId +
                ", quantity=" + quanty +
                ", price=" + price +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
