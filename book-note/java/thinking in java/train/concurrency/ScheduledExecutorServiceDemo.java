/**
 * msxf.com Inc.
 * Copyright (c) 2017-2026 All Rights Reserved.
 */
package concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ji.xie
 * @Filename ScheduledExecutorServiceDemo.java
 * @description ScheduledExecutorService的4个基本方法的使用实例:
 * a.schedule(Runnable command,long delay, TimeUnit unit);
 * b.schedule(Callable<V> callable,long delay, TimeUnit unit);
 * c.scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit);
 * d.scheduleWithFixedDelay(Runnable command,long initialDelay,long delay,TimeUnit unit);
 * - command：执行线程
 * - initialDelay：初始化延时
 * - period：两次开始执行最小间隔时间
 * - unit：计时单位
 * <p>
 * 参考 @link:
 * <a>http://blog.csdn.net/tsyj810883979/article/details/8481621</a>
 * <a>http://blog.csdn.net/lmj623565791/article/details/27109467</a>
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/14 17:22</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ScheduledExecutorServiceDemo {

    private int count;//定义计数

    @Test
    public void test() {
        //定义
        List<Future> futureList = new ArrayList<Future>();
        //定义定时执行器
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        int count = 0;
        do {
            //1.设置a  ps：请看类desc,理解a的定义 :定义延迟时间，在其后执行此进程
//            scheduledExecutorService.schedule(new RunTest(), 10, TimeUnit.MILLISECONDS);
            //2.设置b
//            Future future = scheduledExecutorService.schedule(new CallTest(), 10, TimeUnit.MILLISECONDS);
//            futureList.add(future);
//        //3.设置c
            scheduledExecutorService.scheduleAtFixedRate(new RunTest(), 0, 10, TimeUnit.MILLISECONDS);
//        //3.设置d
//        scheduledExecutorService.scheduleWithFixedDelay(new RunTest(), 0, 1, TimeUnit.SECONDS);
            count++;
        } while (count < 5);

        //显示执行结果
        for (Future future : futureList) {
            try {
                while (!future.isDone()) ;//执行完才打印结果
                System.out.println("任务结果：" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    /*run-test*/
    private class RunTest implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + count);
            count++;
        }
    }

    /*call-test*/
    private class CallTest implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + count);
            count++;
            return "call-test";
        }
    }

}
