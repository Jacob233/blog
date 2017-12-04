package base.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ji.xie
 * @Filename HashMapDemo.java
 * @description 测试顺序
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/25 11:30</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class HashMapDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 1000; i++) {
            map.put(i + "test", i + "test");
        }

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Set set = map.keySet();
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