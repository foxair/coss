package com.github.coss.app.index.po;

import java.util.Date;

public class UserBill {

    private Long    billId;
    private Long    userId;
    private Long    mailId;
    private Date    billStartDate;
    private Date    billDate;
    private String  nameOnCard;
    private Date    paymentDueDate;
    private Long    creditLimit;
    private Long    usdcreditLimit;
    private Long    newBalance;
    private Long    usdnewBalance;
    private Long    minPayment;
    private Long    usdminPayment;
    private Long    pastDueAmount;
    private Long    usdpastDueAmount;
    private Long    cashLimit;
    private Long    usdcashLimit;
    private Long    cashAmount;
    private Long    usdcashAmount;
    private Long    lastBalance;
    private Long    usdlastBalance;
    private Long    lastPayment;
    private Long    usdlastPayment;
    private Long    newCharges;
    private Long    usdnewCharges;
    private Long    adjustment;
    private Long    usdadjustment;
    private Long    interest;
    private Long    usdinterest;
    private Integer integral;
    private Integer lastIntegral;
    private Integer integralAdd;
    private Integer integralAdjust;
    private Integer integralReward;
    private Integer integralUsed;
    private Integer integralTravel;
    private Integer failureintegral;
    private Date    integralLoseDate;
    private Integer integralValidUntil;
    private Integer integralValidUntil2;
    private Date    integralValidDate2;
    private Integer integralValidUntil3;
    private Date    integralValidDate3;
    private Long    goldCard;
    private Date    goldCardValidDate;
    private Integer featureIntegralAdd;
    private Integer featureIntegral;
    private String  autoReturnCard;
    private Date    createTime;
    private Date    lastModifyTime;
    private Long    bankId;
    private Integer isReturn;
    private Date    integralValidDate;
    private String  cardNums;
    private Long    ubid;
    private String  cardNo;
    private String  mailSender;
    private Integer status;
    private Date    orgBillDate;
    private Date    orgPaymentDueDate;
    private Long    returnAmount;
    private Integer gender;

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

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public Long getMailId() {
        return this.mailId;
    }

    public void setBillStartDate(Date billStartDate) {
        this.billStartDate = billStartDate;
    }

    public Date getBillStartDate() {
        return this.billStartDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getBillDate() {
        return this.billDate;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCard() {
        return this.nameOnCard;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Date getPaymentDueDate() {
        return this.paymentDueDate;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getCreditLimit() {
        return this.creditLimit;
    }

    public void setUsdcreditLimit(Long usdcreditLimit) {
        this.usdcreditLimit = usdcreditLimit;
    }

    public Long getUsdcreditLimit() {
        return this.usdcreditLimit;
    }

    public void setNewBalance(Long newBalance) {
        this.newBalance = newBalance;
    }

    public Long getNewBalance() {
        return this.newBalance;
    }

    public void setUsdnewBalance(Long usdnewBalance) {
        this.usdnewBalance = usdnewBalance;
    }

    public Long getUsdnewBalance() {
        return this.usdnewBalance;
    }

    public void setMinPayment(Long minPayment) {
        this.minPayment = minPayment;
    }

    public Long getMinPayment() {
        return this.minPayment;
    }

    public void setUsdminPayment(Long usdminPayment) {
        this.usdminPayment = usdminPayment;
    }

    public Long getUsdminPayment() {
        return this.usdminPayment;
    }

    public void setPastDueAmount(Long pastDueAmount) {
        this.pastDueAmount = pastDueAmount;
    }

    public Long getPastDueAmount() {
        return this.pastDueAmount;
    }

    public void setUsdpastDueAmount(Long usdpastDueAmount) {
        this.usdpastDueAmount = usdpastDueAmount;
    }

    public Long getUsdpastDueAmount() {
        return this.usdpastDueAmount;
    }

    public void setCashLimit(Long cashLimit) {
        this.cashLimit = cashLimit;
    }

    public Long getCashLimit() {
        return this.cashLimit;
    }

    public void setUsdcashLimit(Long usdcashLimit) {
        this.usdcashLimit = usdcashLimit;
    }

    public Long getUsdcashLimit() {
        return this.usdcashLimit;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Long getCashAmount() {
        return this.cashAmount;
    }

    public void setUsdcashAmount(Long usdcashAmount) {
        this.usdcashAmount = usdcashAmount;
    }

    public Long getUsdcashAmount() {
        return this.usdcashAmount;
    }

    public void setLastBalance(Long lastBalance) {
        this.lastBalance = lastBalance;
    }

    public Long getLastBalance() {
        return this.lastBalance;
    }

    public void setUsdlastBalance(Long usdlastBalance) {
        this.usdlastBalance = usdlastBalance;
    }

    public Long getUsdlastBalance() {
        return this.usdlastBalance;
    }

    public void setLastPayment(Long lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Long getLastPayment() {
        return this.lastPayment;
    }

    public void setUsdlastPayment(Long usdlastPayment) {
        this.usdlastPayment = usdlastPayment;
    }

    public Long getUsdlastPayment() {
        return this.usdlastPayment;
    }

    public void setNewCharges(Long newCharges) {
        this.newCharges = newCharges;
    }

    public Long getNewCharges() {
        return this.newCharges;
    }

    public void setUsdnewCharges(Long usdnewCharges) {
        this.usdnewCharges = usdnewCharges;
    }

    public Long getUsdnewCharges() {
        return this.usdnewCharges;
    }

    public void setAdjustment(Long adjustment) {
        this.adjustment = adjustment;
    }

    public Long getAdjustment() {
        return this.adjustment;
    }

    public void setUsdadjustment(Long usdadjustment) {
        this.usdadjustment = usdadjustment;
    }

    public Long getUsdadjustment() {
        return this.usdadjustment;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getInterest() {
        return this.interest;
    }

    public void setUsdinterest(Long usdinterest) {
        this.usdinterest = usdinterest;
    }

    public Long getUsdinterest() {
        return this.usdinterest;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getIntegral() {
        return this.integral;
    }

    public void setLastIntegral(Integer lastIntegral) {
        this.lastIntegral = lastIntegral;
    }

    public Integer getLastIntegral() {
        return this.lastIntegral;
    }

    public void setIntegralAdd(Integer integralAdd) {
        this.integralAdd = integralAdd;
    }

    public Integer getIntegralAdd() {
        return this.integralAdd;
    }

    public void setIntegralAdjust(Integer integralAdjust) {
        this.integralAdjust = integralAdjust;
    }

    public Integer getIntegralAdjust() {
        return this.integralAdjust;
    }

    public void setIntegralReward(Integer integralReward) {
        this.integralReward = integralReward;
    }

    public Integer getIntegralReward() {
        return this.integralReward;
    }

    public void setIntegralUsed(Integer integralUsed) {
        this.integralUsed = integralUsed;
    }

    public Integer getIntegralUsed() {
        return this.integralUsed;
    }

    public void setIntegralTravel(Integer integralTravel) {
        this.integralTravel = integralTravel;
    }

    public Integer getIntegralTravel() {
        return this.integralTravel;
    }

    public void setFailureintegral(Integer failureintegral) {
        this.failureintegral = failureintegral;
    }

    public Integer getFailureintegral() {
        return this.failureintegral;
    }

    public void setIntegralLoseDate(Date integralLoseDate) {
        this.integralLoseDate = integralLoseDate;
    }

    public Date getIntegralLoseDate() {
        return this.integralLoseDate;
    }

    public void setIntegralValidUntil(Integer integralValidUntil) {
        this.integralValidUntil = integralValidUntil;
    }

    public Integer getIntegralValidUntil() {
        return this.integralValidUntil;
    }

    public void setIntegralValidUntil2(Integer integralValidUntil2) {
        this.integralValidUntil2 = integralValidUntil2;
    }

    public Integer getIntegralValidUntil2() {
        return this.integralValidUntil2;
    }

    public void setIntegralValidDate2(Date integralValidDate2) {
        this.integralValidDate2 = integralValidDate2;
    }

    public Date getIntegralValidDate2() {
        return this.integralValidDate2;
    }

    public void setIntegralValidUntil3(Integer integralValidUntil3) {
        this.integralValidUntil3 = integralValidUntil3;
    }

    public Integer getIntegralValidUntil3() {
        return this.integralValidUntil3;
    }

    public void setIntegralValidDate3(Date integralValidDate3) {
        this.integralValidDate3 = integralValidDate3;
    }

    public Date getIntegralValidDate3() {
        return this.integralValidDate3;
    }

    public void setGoldCard(Long goldCard) {
        this.goldCard = goldCard;
    }

    public Long getGoldCard() {
        return this.goldCard;
    }

    public void setGoldCardValidDate(Date goldCardValidDate) {
        this.goldCardValidDate = goldCardValidDate;
    }

    public Date getGoldCardValidDate() {
        return this.goldCardValidDate;
    }

    public void setFeatureIntegralAdd(Integer featureIntegralAdd) {
        this.featureIntegralAdd = featureIntegralAdd;
    }

    public Integer getFeatureIntegralAdd() {
        return this.featureIntegralAdd;
    }

    public void setFeatureIntegral(Integer featureIntegral) {
        this.featureIntegral = featureIntegral;
    }

    public Integer getFeatureIntegral() {
        return this.featureIntegral;
    }

    public void setAutoReturnCard(String autoReturnCard) {
        this.autoReturnCard = autoReturnCard;
    }

    public String getAutoReturnCard() {
        return this.autoReturnCard;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
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

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Integer getIsReturn() {
        return this.isReturn;
    }

    public void setIntegralValidDate(Date integralValidDate) {
        this.integralValidDate = integralValidDate;
    }

    public Date getIntegralValidDate() {
        return this.integralValidDate;
    }

    public void setCardNums(String cardNums) {
        this.cardNums = cardNums;
    }

    public String getCardNums() {
        return this.cardNums;
    }

    public void setUbid(Long ubid) {
        this.ubid = ubid;
    }

    public Long getUbid() {
        return this.ubid;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setMailSender(String mailSender) {
        this.mailSender = mailSender;
    }

    public String getMailSender() {
        return this.mailSender;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setOrgBillDate(Date orgBillDate) {
        this.orgBillDate = orgBillDate;
    }

    public Date getOrgBillDate() {
        return this.orgBillDate;
    }

    public void setOrgPaymentDueDate(Date orgPaymentDueDate) {
        this.orgPaymentDueDate = orgPaymentDueDate;
    }

    public Date getOrgPaymentDueDate() {
        return this.orgPaymentDueDate;
    }

    public void setReturnAmount(Long returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Long getReturnAmount() {
        return this.returnAmount;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return this.gender;
    }

}
