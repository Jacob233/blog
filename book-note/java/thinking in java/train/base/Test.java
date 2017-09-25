package base;


/**
 * @author ji.xie
 * @Filename base.Test.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/8 21:09</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Test {
    @org.junit.Test
    public void test() {
        //实现one
//        new TransParamsOne().originParams();
        //实现two
        new TransParamsTwo().originParams();
    }
}
