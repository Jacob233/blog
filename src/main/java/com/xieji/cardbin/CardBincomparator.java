package com.xieji.cardbin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename CardBinCompare.java
 * @description  cardBin信息比较
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/6 11:27</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CardBincomparator {

    /**多文件比较并输出*/
    public void mutilCompare(List<String> inPaths){
        int fileNum=inPaths.size();
        for(int i=0;i<fileNum;i++){
            File file=new File(inPaths.get(i));

        }
    }


    /**比较两个Excel文件，并将差异信息写出*/
    public static void writeDiff(File file1,File file2,String outFilePath){
        List<CardBinBean> list1=ExcelCardBinHelper.getCardBins(file1,3);

        List<CardBinBean> list2=ExcelCardBinHelper.getCardBins(file2,3);
        List<CardBinBean> diffList=getDiffList(list1,list2);
//        diffList.addAll(list2);
        ExcelCardBinHelper.writeFile(diffList,outFilePath);
    }

    /**cardBin信息填充银行码*/
    public static void fillDeptCode(File file1,File file2,String outFilePath){
        List<CardBinBean> list1=ExcelCardBinHelper.getCardBins(file1,3);

        List<CardBinBean> list2=ExcelCardBinHelper.getCardBins(file2,3);

        List<CardBinBean> comList=new ArrayList<>();

        list1.forEach(item1->{
            for(CardBinBean item2:list2){
                String bankName=tranferBankName(item1.getBankName()).replace("\n","");
                if(bankName.equals(item2.getBankName())){
                    item1.setDeptCode(item2.getDeptCode());
                    item1.setBankName(bankName);
                    comList.add(item1);
                    break;
                }
            }
        });

        ExcelCardBinHelper.writeFile(comList,outFilePath);
    }

    /**银行名转换*/
    private static String tranferBankName(String bankName){

        if(bankName.contains("邮储")){
           return "邮政储蓄银行";
        }
        if(bankName.contains("建行")){
            return "建设银行";
        }
        if(bankName.contains("工行")){
            return "工商银行";
        }
        if(bankName.contains("农行")){
            return "农业银行";
        }
        return bankName;
    }

    /**取Clist1(list1 ∩ list2) 即:取list1中所有不属于 list1和list2交集的元素*/
    private static List<CardBinBean> getDiffList(List<CardBinBean> list1,List<CardBinBean> list2){
        List<CardBinBean> diffList=new ArrayList<>();
        //list1不包含list2中的值
        list1.forEach(item1->{
            boolean flag=true;
            for(CardBinBean item2:list2){
                if(item1.getCardBin().equals(item2.getCardBin())
                        &&item1.getCardNumberLength().equals(item2.getCardNumberLength())
                        &&item1.getCardBin().equals(item2.getCardBin())
                        &&item1.getStartWith().equals(item2.getStartWith())){
                    flag=false;
                    break;
                }
            }
            if(flag){
                diffList.add(item1);
            }
        });
        return diffList;
    }
}