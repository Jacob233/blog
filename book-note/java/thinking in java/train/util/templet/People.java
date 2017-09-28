package util.templet;

/**
 * @author ji.xie
 * @Filename Parent.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/25 15:38</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class People {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String test() {
        return "test";
    }

    public People test(People people) {
        System.out.println(people.getName());
        return people;
    }

    public String[] test(String... str) {
        return str;
    }

    public String test(String str, int i) {
        return str + ":" + i;
    }

    public static String staticTest() {
        return "staticTest";
    }

}