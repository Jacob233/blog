package base.array_test;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename Array2Test.java
 * @description 测试2维转一维
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/28 16:18</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Array2Test {
    @Test
    public void test() {
        String[][] strs = new String[][]{new String[]{"a", "b","c","d"},{"e","f"}};
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
                System.out.println("第" + i + "行" + j + "列" + strs[i][j]);
            }
        }
    }
}