package exception_test;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ji.xie
 * @Filename ExceptionTest.java
 * @description 异常测试
 * @Version 1.0
 * 理解参考：
 * <a>http://www.cnblogs.com/xiohao/p/3547443.html</a>
 * <a>http://bbs.csdn.net/topics/350230556<a/>
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/12 15:26</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ExceptionTest {

    @Test
    public void test() {
        Test1();
//        test2();

        System.out.println("this program has done");
    }

    //模拟编译异常
    private void Test1() {
        Class clz = MyException.class;
        try {
            Method method = clz.getMethod("test");
        } catch (Exception e) {
            System.out.println("will catch the exception");
//            e.printStackTrace();
            //测试两张捕获情况 ：第一种没有Caused by
//            throw new MyException("抛异常了");
//            throw new MyException("抛异常了", e);
        } finally {
            System.out.println("finish");
        }

        System.out.println("the function of foot");
    }

    //模拟运行异常
    private void test2() {

        //模拟算法异常
        int i = 1 / 0;
    }
}