/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */

/**
 * @author ji.xie
 * @Filename TransParamsTestTwo.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/8 21:08</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class TransParamsTwo extends AbstractTransParams {
    @Override
    public void changeParams(StringBuilder str, int num, String strTest) {
        strTest = "strTestChangeTwo";
        num = 2;
        str = str.append("changeTwo");
    }
}
