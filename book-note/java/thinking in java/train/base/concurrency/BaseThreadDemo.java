package base.concurrency;

/**
 * @author ji.xie
 * @Filename BaseThreadDemo.java
 * @description 线程基础连写的实例：sleep、yield、wait、join……
 * 参考blog@link：
 * <a>http://dylanxu.iteye.com/blog/1322066</a>
 * <a>http://www.jquerycn.cn/a_21390</a>
 * <a>http://www.cnblogs.com/pangyang/articles/5916349.html</a>
 * <a>http://www.cnblogs.com/aboutblank/p/3631453.html</a>
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/15 11:32</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class BaseThreadDemo {
    public static void main(String[] args) {
        new BaseThreadDemo().test();
    }

    public void test() {
        MyThread myThread = new MyThread();//定义同级线程
        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        long start = System.currentTimeMillis();
        try {
            System.out.println("当前执行线程：" + Thread.currentThread().getName());

            //第一种形式：t1、t2并行
//            t1.start();
//            t2.start();//启动
//            t1.join();//加入到当前线程
//            t2.join();

            //第二种形式：t1、t2顺行
//            t1.start();
//            t1.join();//加入到当前线程
//            t2.start();//启动
//            t2.join();

            //第三种种形式：t1、当前线程并行
            t1.start();

            System.out.println("间隔时间：" + (System.currentTimeMillis() - start) + "ms");
            System.out.println("当前线程执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyThread extends Thread {

        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);//模拟每次循环执行的时间1秒
                    System.out.println(Thread.currentThread().getName() + "running" + i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
