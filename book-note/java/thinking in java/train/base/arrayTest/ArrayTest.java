/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package base.arrayTest;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename ArrayTest.java
 * @description 数组的一些小细节测试
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/5 18:31</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ArrayTest {
    private String[] strs;

    @Test
    public void test() {
        String[] arys = new String[]{"1", "2"};
        transArray();
//        transArray(arys);
    }

    private void transArray(String... str) {
        this.strs = str;
        if (str.length > 0) {
            for (String s : this.strs) {
                System.out.println(s);
            }
        } else {
            System.out.println("未传入数据");
        }
    }
}

