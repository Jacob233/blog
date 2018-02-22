package com.xieji.cardbin;

import com.xieji.cardbin.com.xieji.util.ExcelUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename ExcelParse.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/6 11:27</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ExcelCardBinHelper {

    /**获取卡bin信息*/
    public static List<CardBinBean> getCardBins(File file,int flag){
        ArrayList<ArrayList<Object>> list=ExcelUtil.readExcel(file);
        List<CardBinBean> cardBinBeans=new ArrayList<>();
        list.forEach(item->{
            CardBinBean cardBinBean=getCardBinBean(item,flag);
            cardBinBeans.add(cardBinBean);
        });
        return cardBinBeans;
    }


    public static void writeFile(List<CardBinBean> cardBinBeans,String path){
           ArrayList<ArrayList<Object>> rows=new ArrayList<>();
           cardBinBeans.forEach(item->{
               ArrayList<Object> cells=new ArrayList<>();
               cells.add(item.getCardType());
               cells.add(item.getCardNumberLength());
               cells.add(item.getCardBin());
               cells.add(item.getStartWith());
               cells.add(item.getBankName());
               cells.add(item.getDeptCode());
               rows.add(cells);
           });
           ExcelUtil.writeExcelTest(rows,path);
    }

    private static CardBinBean getCardBinBean(List list,int flag){
        CardBinBean cardBinBean=new CardBinBean();
        if(0==flag){
            String cardBinTemp=(String)list.get(0);
            String cardBinTemp1=(String)list.get(0);

            int pos=cardBinTemp.indexOf("(");
            String bankName=cardBinTemp1.substring(0,pos);
            cardBinBean.setBankName(bankName);

            int start=cardBinTemp.lastIndexOf("(");
            int end=cardBinTemp.lastIndexOf(")");
            String cardBin=cardBinTemp.substring(start+1,end);

            cardBinBean.setCardBin(cardBin);
            cardBinBean.setCardNumberLength((String)list.get(8));
            cardBinBean.setStartWith((String)list.get(13));

            String cardTypeTemp=(String)list.get(15);
            String cardType= CardTypeEnum.getByCode(cardTypeTemp);
            cardBinBean.setCardType(cardType);
        }

        if(1==flag){
            cardBinBean.setCardType((String)list.get(0));
            cardBinBean.setCardNumberLength((String)list.get(1));
            cardBinBean.setCardBin((String)list.get(2));
            cardBinBean.setBankName((String)list.get(3));
            cardBinBean.setStartWith((String)list.get(4));
        }

        if(2==flag){
            cardBinBean.setDeptCode((String)list.get(0));
            cardBinBean.setBankName((String)list.get(1));
        }

        if(3==flag){
            cardBinBean.setCardType(String.valueOf(list.get(0)));
            cardBinBean.setCardNumberLength(String.valueOf(list.get(1)));
            cardBinBean.setCardBin(String.valueOf(list.get(2)));
            cardBinBean.setStartWith(String.valueOf(list.get(3)));
            cardBinBean.setBankName(String.valueOf(list.get(4)));
            cardBinBean.setDeptCode(String.valueOf(list.get(5)));
        }

        return cardBinBean;
    }

}