package base.concurrency;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @param corePoolSize    the number of threads to keep in the pool, even
 *                        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 * @param maximumPoolSize the maximum number of threads to allow in the
 *                        pool
 * @param keepAliveTime   when the number of threads is greater than
 *                        the core, this is the maximum time that excess idle threads
 *                        will wait for new tasks before terminating.
 * @param unit            the time unit for the {@code keepAliveTime} argument
 * @param workQueue       the queue to use for holding tasks before they are
 *                        executed.  This queue will hold only the {@code Runnable}
 *                        tasks submitted by the {@code execute} method.
 * @param threadFactory   the factory to use when the executor
 *                        creates a new thread
 * @param handler         the handler to use when execution is blocked
 *                        because the thread bounds and queue capacities are reached
 * @author ji.xie
 * @Filename ThreadPoolDemoTwo.java
 * @description 參考blog@link:
 * <a>http://blog.csdn.net/ns_code/article/details/17465497<a/>
 * <a>http://825635381.iteye.com/blog/2184680</a>
 * <a>http://freeheron.iteye.com/blog/664278</a>
 * <a>http://blog.csdn.net/aitangyong/article/details/38822505</a>
 * <p>
 * 線程池參數參考：
 * * Creates a new {@code ThreadPoolExecutor} with the given initial
 * parameters.
 * @throws IllegalArgumentException if one of the following holds:<br>
 * {@code corePoolSize < 0}<br>
 * {@code keepAliveTime < 0}<br>
 * {@code maximumPoolSize <= 0}<br>
 * {@code maximumPoolSize < corePoolSize}
 * @throws NullPointerException if {@code workQueue}
 * or {@code threadFactory} or {@code handler} is null
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/14 14:04</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ThreadPoolDemo {

    @Test
    public void test() {
        //0.創建工作緩存隊列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(20);
        // 1.创建线程池 ：参数参考类desc
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, workQueue);
        //2.创建线程
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();
        //3.将线程添加入线程池
        threadPoolExecutor.execute(t1);
        threadPoolExecutor.execute(t2);
        threadPoolExecutor.execute(t3);
        threadPoolExecutor.execute(t4);
        threadPoolExecutor.execute(t5);
        threadPoolExecutor.execute(t6);
        threadPoolExecutor.execute(t7);
        //4.關閉线程池
        //打印workQueue中的线程
        for (Runnable thread :
                workQueue) {
            System.out.println("工作隊列中的任務：" + thread.toString());
        }

        System.out.println("线程池的活跃：" + threadPoolExecutor.getActiveCount());
        System.out.println("线程池的完成：" + threadPoolExecutor.getCompletedTaskCount());
        System.out.println("线程的拒接访问线程：" + threadPoolExecutor.getRejectedExecutionHandler());
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPoolDemo().test();//单元测试不支持多线程
    }

    private class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行！");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
