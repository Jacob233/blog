package com.xieji.cardbin;

/**
 * @author ji.xie
 * @Filename CardTypeEnum.java
 * @description 卡类型枚举
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/6 13:53</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public enum CardTypeEnum {
    DEBIT_CARD("借记卡", "1"),
    CREDIT_CARD("贷记卡", "2"),
    SEMI_CREDIT_CARD("准贷记卡", "3"),
    PREPAID_CARD("预付费卡", "4");

    CardTypeEnum(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    /**枚举信息*/
    private String msg;
    /**枚举码*/
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**通过信息找到对应的码*/
    public static String getByCode(String msg){
         for(CardTypeEnum _cardTye:values()){
             if(msg.equals(_cardTye.getMsg())){
                 return _cardTye.getCode();
             }
         }
         return "";
    }

}