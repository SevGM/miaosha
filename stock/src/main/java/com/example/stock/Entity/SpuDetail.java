package com.example.stock.Entity;

import java.io.Serializable;
import java.math.BigInteger;

public class SpuDetail implements Serializable {
    /**
     * spu的详情，包括从tb_spu、tb_spu_detail中查询到的数据
     */
    // spu id
    BigInteger id;
    // 商品名称
    String name;
    // 副标题
    String subTitle;
    // 商品描述
    String description;
    // 商品所属品牌id
    BigInteger brandId;
    // 是否上架，0下架，1上架
    Integer saleable;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getBrandId() {
        return brandId;
    }

    public void setBrandId(BigInteger brandId) {
        this.brandId = brandId;
    }

    public Integer getSaleable() {
        return saleable;
    }

    public void setSaleable(Integer saleable) {
        this.saleable = saleable;
    }
}
