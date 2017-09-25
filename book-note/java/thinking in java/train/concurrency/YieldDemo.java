package concurrency;


/**
 * @author ji.xie
 * @Filename YieldDemo.java
 * @description yield给>=同级的线程退让资源
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/12 19:38</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class YieldDemo {

    public static void main(String[] args) {

        TestThread test = new TestThread();
        Thread t1 = new Thread(test, "t1");
        Thread t2 = new Thread(test, "t2");

        //设置优先级
        t1.setPriority(1);
        t2.setPriority(2);

        //开启线程
        t1.start();
        t2.start();
    }

    private static class TestThread extends Thread {
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (i == 30) {
                    System.out.println("-----------------------------------");
                    Thread.yield();//当前线程退让
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}