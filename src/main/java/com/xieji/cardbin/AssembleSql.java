package com.xieji.cardbin;

import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ji.xie
 * @Filename AssembleSql.java
 * @description 组装插入卡bin信息的sql
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/7 0:01</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class AssembleSql {

    private Logger logger=Logger.getLogger("AssembleSql");

    @Test
    public void assemble(){
         StringBuilder sql=new StringBuilder("INSERT INTO `paygw`.`bank_card_bin` (\n" +
                 "\t`start_with`,\n" +
                 "\t`card_bin`,\n" +
                 "\t`bank_name`,\n" +
                 "\t`bank_code`,\n" +
                 "\t`card_number_length`,\n" +
                 "\t`card_type`\n" +
                 ")\n" +
                 "VALUES");
        File file=new File("C:\\\\Users\\\\ji.xie\\\\Desktop\\\\final_card_bin.xls");

        List<CardBinBean> cardBinBeans= ExcelCardBinHelper.getCardBins(file,3);
        cardBinBeans.forEach(item->{
            sql.append("(").append("'").append(item.getStartWith().trim()).append("'").append(",")
                    .append("'").append(item.getCardBin().trim()).append("'").append(",")
                    .append("'").append(item.getBankName().replace("\n","").trim()).append("'").append(",")
                    .append("'").append(item.getDeptCode().trim()).append("'").append(",")
                    .append("'").append(item.getCardNumberLength().trim()).append("'").append(",")
                    .append("'").append(item.getCardType().trim()).append("'")
                    .append(")").append(",");
        });
        int lastComma=sql.lastIndexOf(",");
        logger.info(sql.substring(0,lastComma));
    }
}