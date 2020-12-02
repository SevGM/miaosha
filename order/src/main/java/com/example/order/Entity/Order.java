package com.example.order.Entity;

import org.bouncycastle.asn1.cms.TimeStampAndCRL;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Order implements Serializable {
    // 订单id
    BigInteger orderId;
    // 总金额
    BigInteger totalFee;
    // 实付金额
    BigInteger actualFee;
    // 优惠活动id,多个以，隔开
    String promotionIds;
    // 支付方式
    Integer paymentType;
    // 邮费
    BigInteger postFee;

    BigInteger userId;
    Long invoiceType;
    Long sourceType;
    Integer status;
    Timestamp createTime;
    Timestamp payTime;
    Timestamp consignTime;
    Timestamp endTime;
    Timestamp closeTime;
    Timestamp commentTime;
    Timestamp updateTime;

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public BigInteger getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigInteger totalFee) {
        this.totalFee = totalFee;
    }

    public BigInteger getActualFee() {
        return actualFee;
    }

    public void setActualFee(BigInteger actualFee) {
        this.actualFee = actualFee;
    }

    public String getPromotionIds() {
        return promotionIds;
    }

    public void setPromotionIds(String promotionIds) {
        this.promotionIds = promotionIds;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigInteger getPostFee() {
        return postFee;
    }

    public void setPostFee(BigInteger postFee) {
        this.postFee = postFee;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Long getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Long invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Long getSourceType() {
        return sourceType;
    }

    public void setSourceType(Long sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Timestamp getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Timestamp consignTime) {
        this.consignTime = consignTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", totalFee=" + totalFee +
                ", actualFee=" + actualFee +
                ", promotionIds='" + promotionIds + '\'' +
                ", paymentType=" + paymentType +
                ", postFee=" + postFee +
                ", userId=" + userId +
                ", invoiceType=" + invoiceType +
                ", sourceType=" + sourceType +
                ", status=" + status +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", consignTime=" + consignTime +
                ", endTime=" + endTime +
                ", closeTime=" + closeTime +
                ", commentTime=" + commentTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
