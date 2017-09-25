package base;


/**
 * @author ji.xie
 * @Filename TransParamsTestOne.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/8 21:08</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class TransParamsOne extends AbstractTransParams {
    @Override
    public void changeParams(StringBuilder str, int num, String strTest) {
        strTest = "strTestChangeOne";
        num = 1;
        str = str.append("changeOne");
    }
}
