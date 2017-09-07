/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package base.interfaceTest.test;

import base.interfaceTest.ChildInterface;
import base.interfaceTest.ParentInterface;
import base.interfaceTest.impl.TestInterface;

/**
 * @author ji.xie
 * @Filename Test.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/4 17:21</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class Test {

    @org.junit.Test
    public void test(){
        ParentInterface test=new TestInterface();
        test.test();
    }

}