package concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ji.xie
 * @Filename concurrency.ExecutorServiceRunnable.java
 * @description ExecutorServiceDemo
 * 参考blog@link：
 * <a>http://blog.csdn.net/vking_wang/article/details/9619137</a>
 * <a>http://blog.csdn.net/chenaini119/article/details/51849222</a>
 * <a>http://www.cnblogs.com/zhaoyan001/p/7049627.html</a>
 * <a>http://blog.csdn.net/ns_code/article/details/17465497</a>
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/14 15:18</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        new ExecutorServiceDemo().test();
    }

    public void test() {

        //0.创建ExecutorService（4个实现：静态工厂的设计模式）
        //newFixedThreadPool：有一个固定大小的线程池 使用场景：稳定固定的并发编程
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        //cachedThreadPool :每60s会自动清除idle的线程，无需自己关闭  使用场景：生存期短的异步任务
        //ps：其与newFixedThreadPool 底层实现机制一样，只是newFixedThreadPool的idle为0
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //newSingleThreadExecutor :只有一个单线程执行任务，每次都重建  使用场景，保证了任务执行的顺序
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //scheduledExecutorService :定时任务，以后要详解这个类
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        //1.0 执行线程之run
        run(fixedThreadPool);
//        run(cachedThreadPool);
//        run(newSingleThreadExecutor);
//        run(scheduledExecutorService);
        //1.1 执行线程之call
//        call(fixedThreadPool);
//        call(cachedThreadPool);
//        call(newSingleThreadExecutor);
//        call(scheduledExecutorService);
    }

    /*将要执行的任务*/
    private void run(ExecutorService executorService) {
        for (int i = 1; i < 4; i++) {
            final int task = i;
            // 创建线程
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + task);
//                }
//            };
//            //执行线程
//            executorService.execute(runnable);
            //每个任务执行3次
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j < 4; j++) {
                        try {
                            Thread.sleep(200);
                            System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行,第" + task + "次任务的" + j + "次执行");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        //关闭线程池
        executorService.shutdown();
//        executorService.shutdownNow(); //比较两者区别：前者是小卖店，后者是银行柜台
    }

    /*将要执行的任务*/
    private void call(ExecutorService executorService) {
        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0; i < 3; i++) {
            final int num = i;
            // 创建线程
            Callable callable = new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + num);
                    return num;
                }
            };
            //执行线程
            Future<String> future = executorService.submit(callable);
            futureList.add(future);
            //每个任务执行3次
//            executorService.submit(new Callable() {
//                @Override
//                public Object call() throws Exception {
//                    for (int j = 0; j < 3; j++) {
//                        System.out.println("当前线程:" + Thread.currentThread().getName() + "正在执行" + j);
//                    }
//                    return "执行完成" ;
//                }
//            });
        }

        //显示执行结果
        for (Future future : futureList) {
            try {
                while (!future.isDone()) ;//执行完才打印结果
                System.out.println("任务结果：" + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //关闭线程池
                executorService.shutdown();
//        executorService.shutdownNow(); //比较两者区别：前者是小卖店，后者是银行柜台
            }
        }
    }
}
