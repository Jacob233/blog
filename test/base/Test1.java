import com.alibaba.fastjson.JSON;
import org.junit.Test;
import util.templet.People;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author ji.xie
 * @Filename Test1.java
 * @description 1.测试数组为空转换list情况 2.测试List转Json日志打印情况
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/11/16 13:40</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Test1 {

    private List<String> list = new ArrayList<>();

    private Logger logger = Logger.getLogger("Test1");

    @Test
    public void printJsonTest() {
        //空的情况下，遍历
        for (String str :
                list) {
            logger.info(str);
        }
        logger.info("no error,list.size:" + list.size());

        list.add("12");
        list.add("34");
        list.add("56");

        //print:["12","34","56"]
        logger.info(JSON.toJSONString(list));
    }

    @Test
    public void nullIteratorTest() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            logger.info("come here?");
        }
        logger.info("finish");
    }

    @Test
    public void skipCircle() {
        list.add("12");
        list.add("34");
        list.add("56");

        List<String> tempList = new ArrayList<>();
        tempList.add("a");
        tempList.add("b");
        tempList.add("12");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            boolean flag = true;
            String str = iterator.next();
            for (String temp : tempList) {
                if (str.equals(temp)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                iterator.remove();
            }

        }
        logger.info(JSON.toJSONString(list));
    }

    @Test
    public void uuidTest() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        logger.info(String.valueOf(uuid.length()));
    }

    @Test
    public void dateTest() {
        System.out.println(new People("a", 1));
        System.out.println(new Date(532583980994L));
    }
}