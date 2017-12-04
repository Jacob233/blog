package base;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ji.xie
 * @Filename Global2valueTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/10/9 17:46</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Global2valueTest {

    private StringBuilder str;
    private Logger logger = Logger.getLogger(String.valueOf(Global2valueTest.class));

    @Test
    public void test() {
        setStr();
        logger.info(str.toString());

//        List<String> list=new ArrayList();
//        for(String str:list){
//            System.out.println(str);
//        }

        String str = null;
        List list = new ArrayList();
        list.add(str);
        list.add(1);
        System.out.println(list.get(0));

        //浮点数测试精度
        float a = 10f;
        System.out.println(a - 0.01);
    }

    private void setStr() {
        str = new StringBuilder("test");
    }
}