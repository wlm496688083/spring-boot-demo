package com.example.domain;

import java.util.Date;

public class ImsiMakeCardPO {
    private Long seqId;

    private String orderId;

    private String fileName;

    private String startImsi;

    private String endImsi;

    private Date operTime;

    private String resDesc;

    private Integer lockNum;

    private Integer successNum;

    private Long subImsi;

    private String status;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStartImsi() {
        return startImsi;
    }

    public void setStartImsi(String startImsi) {
        this.startImsi = startImsi;
    }

    public String getEndImsi() {
        return endImsi;
    }

    public void setEndImsi(String endImsi) {
        this.endImsi = endImsi;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public Integer getLockNum() {
        return lockNum;
    }

    public void setLockNum(Integer lockNum) {
        this.lockNum = lockNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Long getSubImsi() {
        return subImsi;
    }

    public void setSubImsi(Long subImsi) {
        this.subImsi = subImsi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ImsiMakeCardPO{" +
                "seqId=" + seqId +
                ", orderId='" + orderId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", startImsi='" + startImsi + '\'' +
                ", endImsi='" + endImsi + '\'' +
                ", operTime=" + operTime +
                ", resDesc='" + resDesc + '\'' +
                ", lockNum=" + lockNum +
                ", successNum=" + successNum +
                ", subImsi=" + subImsi +
                ", status='" + status + '\'' +
                '}';
    }
}