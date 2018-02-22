package com.xieji.cardbin;

import java.io.Serializable;

/**
 * @author ji.xie
 * @Filename CardBin.java
 * @description 卡bin-bean
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/6 11:23</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CardBinBean implements Serializable {

    private String cardType;
    private String cardNumberLength;
    private String cardBin;
    private String bankName;
    private String startWith;
    private String deptCode;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(String cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String cardBin) {
        this.cardBin = cardBin;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStartWith() {
        return startWith;
    }

    public void setStartWith(String startWith) {
        this.startWith = startWith;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}