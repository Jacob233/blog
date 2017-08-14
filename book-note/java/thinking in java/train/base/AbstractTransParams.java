package base; /**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */

/**
 * @author ji.xie
 * @Filename base.AbstractTransParams.java
 * @description 测试一个函数a中的局部函数x作为变量，传入另一个函数b中,并在其中修改x,再在a中输出x,观察结果并分析
 * 分析结果： 基本类型按值传递，对象按引用传递，String是特殊对象，每次赋值相当于重新创建对象，故类似于基本类型
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/8 18:55</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public abstract class AbstractTransParams {

    /**
     * 初始函数，原始参数值
     */
    public void originParams() {
        StringBuilder str = new StringBuilder("origin");//选择用StringBuilder,屏蔽基本元素带来的不客观结果
        int num = 0;//基本元素对比
        String strTest = "strTest";//特殊类String,每次赋值相当于重新创建了一个对象
        //调用变参函数
        changeParams(str, num, strTest);
        //打印结果
        System.out.println("params:" + str + " | " + "num:" + num + " | " + strTest);
    }

    public abstract void changeParams(StringBuilder str, int num, String strTest);
//        strTest="strTestChange";
//        num=1;
//        str = str.append("change");
//    }
}
