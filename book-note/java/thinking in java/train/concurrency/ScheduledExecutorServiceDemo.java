package concurrency;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * <p>
 * 总结：
 * rate和delay(都是简称)两个方法的区别：
 * rate是以周期性为主，举例：像地铁，时间是固定的，但是当延迟了的话，还是会依次顺延
 * delay是以上一次任务执行为主：举例：像接力，只有上一棒来了才开始延迟（跑的这段时间）
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
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        int num = 0;
//        do {
        //1.设置a  ps：请看类desc,理解a的定义 :定义延迟时间，在其后执行此进程
//            scheduledExecutorService.schedule(new RunTest(), 3, TimeUnit.SECONDS);
        //2.设置b
//            Future future = scheduledExecutorService.schedule(new CallTest(), 1, TimeUnit.SECONDS);
//            futureList.add(future);
//        //3.设置c
        scheduledExecutorService.scheduleAtFixedRate(new RunTest(), 0, 3, TimeUnit.SECONDS);
//        //3.设置d
//        scheduledExecutorService.scheduleWithFixedDelay(new RunTest(), 0, 5, TimeUnit.SECONDS);
//            num++;
//        } while (num < 5);

        //显示执行结果
        for (Future fr : futureList) {
            try {
                while (!fr.isDone()) ;//执行完才打印结果
                System.out.println("任务结果：" + fr.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new ScheduledExecutorServiceDemo().test();
    }

    /*run-test*/
    private class RunTest implements Runnable {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");

        @Override
        public void run() {
            String start = sf.format(new Date());
            long s = System.currentTimeMillis();
            System.out.println("线程执行开始时间：" + start + "|" + s);
            try {
                Thread.sleep(5000);
                System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + count);
                String end = sf.format(new Date());
                long e = System.currentTimeMillis();
                System.out.println("线程执行结束时间：" + end);
                System.out.println("总执行时间：" + (e - s));
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
