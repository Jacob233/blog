package base.reflect;

import java.util.Scanner;

/**
 * @author ji.xie
 * @Filename ScannerTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 14:04</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ScannerTest {

    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        System.out.println("please input:");
        while (read.hasNext()){
            System.out.println(read.nextLine());
        }
    }
}