package base.collection.hashmap;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ji.xie
 * @Filename HashSetDemo.java
 * @description 结论：无序是指，逻辑无序，实际：是内部通过hashcode有序存储
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/25 14:11</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class HashSetDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            set.add(i + "test");
        }

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (Object i : set) {
                    System.out.println(i);
                }

                System.out.println("1------------------------------------1");

                try {
                    Thread.sleep(3000);
                    for (Object i : set) {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("2------------------------------------2");

                try {
                    Thread.sleep(2000);
                    for (Object i : set) {
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}