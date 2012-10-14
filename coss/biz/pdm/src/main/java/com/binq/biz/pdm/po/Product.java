package com.binq.biz.pdm.po;

public class Product {

    private Long           id;
    private java.util.Date gmtCreate;
    private String         productCode;
    private String         productName;
    private Float          retailPrice;
    private String         skuDefinition;
    private String         remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGmtCreate(java.util.Date value) {
        this.gmtCreate = value;
    }

    public java.util.Date getGmtCreate() {
        return this.gmtCreate;
    }

    public void setProductCode(String value) {
        this.productCode = value;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductName(String value) {
        this.productName = value;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setRetailPrice(Float value) {
        this.retailPrice = value;
    }

    public Float getRetailPrice() {
        return this.retailPrice;
    }

    public void setSkuDefinition(String value) {
        this.skuDefinition = value;
    }

    public String getSkuDefinition() {
        return this.skuDefinition;
    }

    public void setRemark(String value) {
        this.remark = value;
    }

    public String getRemark() {
        return this.remark;
    }

}
