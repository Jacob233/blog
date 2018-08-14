import org.junit.Test;
import templet.Callback;
import templet.ServiceTemplet;

/**
 * @author ji.xie
 * @Filename CommandTest.java
 * @description 测试指令集
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:18</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CommandTest {

    @Test
    public void test() {
//       new MorningComandChain().execute();
        System.out.println(new ServiceTemplet().execute(new Callback<Integer, String>() {

            @Override
            public Integer prepare() {
                return 1;
            }

            @Override
            public void execute(Integer integer) {
                System.out.println("xj+" + integer);
            }

            @Override
            public String result(Integer integer) {
                return integer.toString();
            }
        }));
    }
}