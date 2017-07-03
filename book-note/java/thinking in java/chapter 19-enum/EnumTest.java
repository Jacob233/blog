/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename EnumTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2016/12/27 17:12</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public enum EnumTest {
    //可以理解为一个类的实例;fp:E(类似于):EnumTest E=new EnumTest();
    //每个实例默认为static final修饰的，所以是不能进行修改的
    //枚举其实可以理解为一个特殊的类，它甚至可以有main函数
    E, N, U, M;

    //注意点：枚举的构造方法不能是public，故JUnit用不了
    EnumTest() {
    }

    ;

    enum COlOR {
        //实例是代表的一个标识，但是你可以通过构造函数来增加标识性，例子如下：
        RED("红色", "01"), GREEN("绿色", "02"), YELLOW;
        //属性也是可以定义的
        public String param = "param";

        private String message;
        private String code;

        //构造函数的例子
        COlOR(String message, String code) {
            this.message = message;
            this.code = code;
        }

        //可以重载的
        COlOR() {
        }

        ;

        //可以定义方法，并可以通过实例调用
        public void test() {
            System.out.println("test");
        }
    }

    //main方法也是可以存在的
    public static void main(String[] args) {
        //通过实例调用属性值
        System.out.println(COlOR.RED.param);
        //values相当于枚举实例的数组
        for (COlOR _enum : COlOR.values()) {
            System.out.println(_enum);
        }
        //实例.name():相当于toString()，实例的常量，即RED,GREEN……
        System.out.println(COlOR.RED.name());
        //得到详细的类
        System.out.println(COlOR.RED.getDeclaringClass());
        //得到类
        System.out.println(COlOR.RED.getClass());
        //enum继承了comparable，故有equals()方法
        System.out.println(COlOR.RED.equals("1") + " " + COlOR.RED.equals(COlOR.GREEN) + " " + COlOR.RED.equals(COlOR.RED));
        //实例.ordinal()):相当于调取数组的下标
        System.out.println(COlOR.RED.ordinal());
        //调取扩展标识，即属性的调用
        System.out.println(COlOR.RED.code + COlOR.RED.message + COlOR.YELLOW.message);
        //valueOf()可以通过实例的name来调取实例，是static方法
        System.out.println(COlOR.valueOf("RED"));
        COlOR.RED.test();
    }

    @Test
    public void test() {
        System.out.println("不可以0.0");
    }
}

