import org.junit.Test;


/**
 * @author ji.xie
 * @Filename GoToTest.java
 * @description 递归测试
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/7/24 17:10</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class GoToTest {

    @Test
    public void test() {
        System.out.println(add(3));
    }

    public int add(int i) {
        if (0 != i) {
            i += add(i - 1);
        }
        return i;
    }
}