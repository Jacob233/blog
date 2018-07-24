package test;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename ThreadInvokerTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/3/30 17:14</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ThreadInvokerTest {

    private String hello() {
        Thread oneThread = new Thread(() -> {
            try {
                Thread.sleep(10 * 1000);
                System.out.println("hello!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        );

        oneThread.setName("oneThread");
        oneThread.start();
        return "success";
    }

    public static void main(String[] args) {
        System.out.println(new ThreadInvokerTest().hello());
    }

//    @Test
//    public void Test(){
//        System.out.println(hello());
//    }
}