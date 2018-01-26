package dp.command;

/**
 * @author ji.xie
 * @Filename Test.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 18:36</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Test {

    @org.junit.Test
    public void test() {
        SimpleCommandChain simpleCommandChain = new SimpleCommandChain();
        simpleCommandChain.execute();
    }
}