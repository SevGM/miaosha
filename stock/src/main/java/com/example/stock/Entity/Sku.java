package com.example.stock.Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Sku implements Serializable {
    // sku id
    BigInteger id;
    // spu id
    BigInteger spuId;
    // 商品标题
    String title;
    // 商品图片链接
    String images;
    // 库存
    Integer stock;
    // 价格,单位为分
    BigInteger price;
    // 特有规格属性在spu属性模板中的对应下标组合
    String indexes;
    // sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序
    String ownSpec;
    // 是否有效，0无效，1有效
    Integer enable;
    // 创建时间
    Timestamp creatTime;
    // 更新时间
    Timestamp updateTime;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getSpuId() {
        return spuId;
    }

    public void setSpuId(BigInteger spuId) {
        this.spuId = spuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", title='" + title + '\'' +
                ", images='" + images + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", indexes='" + indexes + '\'' +
                ", ownSpec='" + ownSpec + '\'' +
                ", enable=" + enable +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
