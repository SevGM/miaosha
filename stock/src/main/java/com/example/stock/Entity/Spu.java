package com.example.stock.Entity;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Spu {
    // spu id
    BigInteger id;
    // 商品名称
    String name;
    // 副标题
    String subTitle;
    //1级类目id
    BigInteger cid1;
    //2级类目id
    BigInteger cid2;
    //3级类目id
    BigInteger cid3;
    // 商品所属品牌id
    BigInteger brand_id;
    // 是否上架，0下架，1上架
    Integer saleable;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BigInteger getCid1() {
        return cid1;
    }

    public void setCid1(BigInteger cid1) {
        this.cid1 = cid1;
    }

    public BigInteger getCid2() {
        return cid2;
    }

    public void setCid2(BigInteger cid2) {
        this.cid2 = cid2;
    }

    public BigInteger getCid3() {
        return cid3;
    }

    public void setCid3(BigInteger cid3) {
        this.cid3 = cid3;
    }

    public BigInteger getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(BigInteger brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getSaleable() {
        return saleable;
    }

    public void setSaleable(Integer saleable) {
        this.saleable = saleable;
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
        return "Spu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", cid1=" + cid1 +
                ", cid2=" + cid2 +
                ", cid3=" + cid3 +
                ", brand_id=" + brand_id +
                ", saleable=" + saleable +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
