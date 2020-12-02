package com.example.order.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class OrderDetail implements Serializable {
    BigInteger id;
    // 订单id
    BigInteger orderId;
    BigInteger skuId;
    Long num;
    String title;
    String ownSpec;
    Long price;
    String image;
    Timestamp createTime;
    Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getSkuId() {
        return skuId;
    }

    public void setSkuId(BigInteger skuId) {
        this.skuId = skuId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", skuId=" + skuId +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", ownSpec='" + ownSpec + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
