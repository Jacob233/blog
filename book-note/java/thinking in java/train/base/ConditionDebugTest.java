package base;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename ConditionDebugTest.java
 * @description 条件debug测试
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/15 16:56</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ConditionDebugTest {

    @org.junit.Test
    public void test() {
        List<String> names = new ArrayList<String>();
        names.add("小a");
        names.add("小b");
        names.add("小c");
        names.add("小d");
        names.add("小e");

        for (String name : names) {
            System.out.println("test的name:" + name);
        }

        //buffer实际""
        StringBuffer buffer=new StringBuffer();
        if(buffer.toString()==null||buffer.toString().length()==0){
            System.out.println("true");
        }
        System.out.println(buffer);
    }
}
