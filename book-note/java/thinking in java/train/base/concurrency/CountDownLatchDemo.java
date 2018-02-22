package base.concurrency;

import java.util.concurrent.*;

/**
 * @author ji.xie
 * @Filename base.concurrency.CountDownLatchDemo.java
 * @description 使用countDownLach实现一个小demo:模仿10人组百米赛跑
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/11 15:05</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CountDownLatchDemo {
    /**定义当前线程等待线程数:比赛开始*/
    CountDownLatch start = new CountDownLatch(1);
    /**比赛结束*/
    CountDownLatch end = new CountDownLatch(10);
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void test() {
        for (int i = 0; i < 10; i++) {
            //名次
            int no = i + 1;
            Runnable runnable = ()-> {
                    try {
                        System.out.println("come?"+no);
                        start.await();
                        System.out.println("threadName:"+Thread.currentThread().getName()+" NO." + no + "到达终点");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
            };
            executorService.execute(runnable);
        }

        System.out.println("---------比赛开始---------");
            start.countDown();
            try {
                end.await();
                System.out.println("---------比赛结束---------");
                executorService.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        new CountDownLatchDemo().test();
    }
}
