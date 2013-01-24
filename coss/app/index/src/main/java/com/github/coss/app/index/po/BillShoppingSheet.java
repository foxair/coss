package com.github.coss.app.index.po;

import java.util.Date;

public class BillShoppingSheet {
    private Long    autoId;
    private Long    billId;
    private Long    userId;
    private Date    transDate;
    private Date    postDate;
    private String  discription;
    private String  transType;
    private Integer currencytype;
    private Float   amountMoney;
    private Float   transOrgAmount;
    private String  transAddr;
    private Date    createTime;
    private String  cardNo;
    private Date    lastModifyTime;
    private Long    bankId;
    private Integer categoryId;
    private Integer keywordId;
    private Integer tcategoryId;
    private Integer tkeywordId;
    private String  tkeywordIds;

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public Long getAutoId() {
        return this.autoId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getBillId() {
        return this.billId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getTransDate() {
        return this.transDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDate() {
        return this.postDate;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDiscription() {
        return this.discription;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransType() {
        return this.transType;
    }

    public void setCurrencytype(Integer currencytype) {
        this.currencytype = currencytype;
    }

    public Integer getCurrencytype() {
        return this.currencytype;
    }

    public Float getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Float amountMoney) {
        this.amountMoney = amountMoney;
    }

    public Float getTransOrgAmount() {
        return transOrgAmount;
    }

    public void setTransOrgAmount(Float transOrgAmount) {
        this.transOrgAmount = transOrgAmount;
    }

    public void setTransAddr(String transAddr) {
        this.transAddr = transAddr;
    }

    public String getTransAddr() {
        return this.transAddr;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getBankId() {
        return this.bankId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public Integer getKeywordId() {
        return this.keywordId;
    }

    public void setTcategoryId(Integer tcategoryId) {
        this.tcategoryId = tcategoryId;
    }

    public Integer getTcategoryId() {
        return this.tcategoryId;
    }

    public void setTkeywordId(Integer tkeywordId) {
        this.tkeywordId = tkeywordId;
    }

    public Integer getTkeywordId() {
        return this.tkeywordId;
    }

    public void setTkeywordIds(String tkeywordIds) {
        this.tkeywordIds = tkeywordIds;
    }

    public String getTkeywordIds() {
        return this.tkeywordIds;
    }

}
