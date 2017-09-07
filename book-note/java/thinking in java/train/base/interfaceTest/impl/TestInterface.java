/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package base.interfaceTest.impl;

import base.interfaceTest.ChildInterface;

/**
 * @author ji.xie
 * @Filename TestInterface.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/4 17:20</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class TestInterface implements ChildInterface {
    @Override
    public void test() {
        System.out.println("继承子类接口的方法test");
    }
}