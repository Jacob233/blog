package com.xieji.cardbin;

import org.junit.Test;

import java.io.File;

/**
 * @author ji.xie
 * @Filename CardBinExecutor.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/9 11:55</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CardBinExecutorTest {

    /**
     * @Description 文件处理器
     * @Params
     * @Return
     * @Exceptions
     */
    @Test
    public void excecutor(){
//        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\2017年12月25日版单位结算卡卡表.xls");
//        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\2017年12月25日版非标卡表.xls");
//        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\2017年12月25日版卡表.xls");
//        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\2017年12月25日版跨行转账卡表总信息.xls");
//        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\2017年12月25日版农民工卡表.xls");
        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\online_cardBin_add.xls");
        File file2=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\online_cardBin.xls");
        String outPath="C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\output_cardBin.xls";
        CardBincomparator.writeDiff(file1,file2,outPath);
    }

    @Test
    public void fillExcecutor(){
        File file1=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\output_cardBin.xls");
        File file2=new File("C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\online_cardBin.xls");
        String outPath="C:\\Users\\ji.xie\\Desktop\\卡bin\\Buscardbin20171225\\add_cardBin_new.xls";
        CardBincomparator.fillDeptCode(file1,file2,outPath);
    }
}