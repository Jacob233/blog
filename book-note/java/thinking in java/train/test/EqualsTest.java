package test;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename EqualsTest.java
 * @description equalsTest  :常理：hashCode对应相应的对象 （ps:java无法直接获取地址）
 * 但是重写了hashCode方法的上述常理不适用 f.g：String
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/10/27 10:30</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class EqualsTest {

    @Test
    public void test() {
        String a = "test";
        System.out.println(a.hashCode());
        String b = "test";
        System.out.println(b.hashCode());
        //string的直接赋值也相当于新创建了对象
        a = "retest";
        System.out.println(a.hashCode());

        StringBuilder b1 = new StringBuilder("testBuilder");
        System.out.println(b1.hashCode());
        StringBuilder b2 = new StringBuilder("testBuilder");
        System.out.println(b2.hashCode());
    }
}