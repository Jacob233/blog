package base.concurrency;

/**
 * @author ji.xie
 * @Filename DaemonDemo.java
 * @description 守护线程实例 :应用程序在非守护线程结束就已结束，即使还有守护线程在执行
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/15 9:48</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class DaemonDemo {

    //    @Test
    public void test() {
        //0.创建线程
        Thread thread = new DaemonThread();
        //1.设置守护线程
        thread.setDaemon(true);
        //2.执行守护线程，看顺序
        thread.start();
        //3.测试
        System.out.println("当前线程开始执行");
        try {
            Thread.sleep(1000);
            System.out.println("当前线程执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class DaemonThread extends Thread {
        @Override
        public void run() {
            int count = 5;
            System.out.println("守护线程开始倒数执行:");
            try {
                Thread.sleep(1000);//先睡眠一秒
                while (count > 0) {
                    System.out.println(count);
                    count--;
                }
                System.out.println("守护线程结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DaemonDemo().test();
    }
}
