package com.github.coss.app.index.vo;

import java.util.Date;

public class IndexData {
    private Date    partDate;
    private Float   amount     = 0F;
    private Integer transCount = 0;

    @Override
    public String toString() {
        return "{partDate : " + partDate + ", amount : " + amount + ", transCount : " + transCount
                + "}";
    }

    public IndexData() {
        super();
    }

    public IndexData(Date partDate) {
        super();
        this.partDate = partDate;
    }

    public Date getPartDate() {
        return partDate;
    }

    public void setPartDate(Date partDate) {
        this.partDate = partDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getTransCount() {
        return transCount;
    }

    public void setTransCount(Integer transCount) {
        this.transCount = transCount;
    }

}
