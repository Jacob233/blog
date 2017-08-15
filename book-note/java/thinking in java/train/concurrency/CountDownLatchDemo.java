package concurrency; /**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ji.xie
 * @Filename concurrency.CountDownLatchDemo.java
 * @description 使用countDownLach实现一个小demo:模仿10人组百米赛跑
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/11 15:05</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CountDownLatchDemo {
    CountDownLatch start = new CountDownLatch(1);//定义当前线程等待线程数：比赛开始
    CountDownLatch end = new CountDownLatch(10);//比赛结束
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void test() {
        for (int i = 0; i < 10; i++) {

            final int no = i + 1;//名次 ;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        System.out.println("NO." + no + "到达终点");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            executorService.execute(runnable);
        }

        start.countDown();
        System.out.println("---------比赛开始---------");
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
