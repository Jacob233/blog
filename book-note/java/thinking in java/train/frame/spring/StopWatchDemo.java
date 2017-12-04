package frame.spring;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author ji.xie
 * @Filename StopWatchDemo.java
 * @description StopWatchDemo
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/10/26 16:56</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class StopWatchDemo {

    private void code() throws InterruptedException {
        //1.想
        StopWatch sw = new StopWatch();
        sw.start("想问题");
        long thinkTime = (long) Math.random() * 1000;
        Thread.sleep(thinkTime);
        sw.stop();

        //2.写
        sw.start("写代码");
        long codeTime = 1;
        Thread.sleep(codeTime);
        sw.stop();

        //3.调
        sw.start("调bug");
        double dice = Math.random();
        long bugTime;
        if (0.4 > dice) {
            bugTime = 10000;
        } else {
            bugTime = 0;
        }
        Thread.sleep(bugTime);
        sw.stop();

        //显示统计时间
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
        System.out.println(sw.isRunning());
        System.out.println(sw.shortSummary());
        System.out.println(sw.toString());
    }

    @Test
    public void test() throws InterruptedException {
        code();
    }
}