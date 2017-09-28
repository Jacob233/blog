package base.reflect;

import org.junit.Test;
import util.templet.People;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename InvokeDemo.java
 * @description method.invoke()
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/25 15:32</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class InvokeDemo {

    @Test
    public void test() {
        {
            List list = new ArrayList();
            People people = new People();
            people.setAge(1);
            people.setName("baby");

            PropertyDescriptor propertyDescriptor = null;

            try {
                Field field = People.class.getDeclaredField("name");

                propertyDescriptor = new PropertyDescriptor(field.getName(), People.class);
                System.out.println("propertyDescriptor:" + propertyDescriptor);

                Method readMethod = propertyDescriptor.getReadMethod();
                System.out.println("readMethod:" + readMethod);

                list.add(people);
                Object value = readMethod.invoke(list.get(0));
                System.out.println("value:" + value);

//                Method testMethod=People.class.getMethod("test");
//                Object testValue=testMethod.invoke(list.get(0));
//                System.out.println("testValue:" + testValue);
//
//                Method testStaticMethod=People.class.getMethod("staticTest");
//                Object testStaticValue=testStaticMethod.invoke(null);//invoke是返回有返回值的值，静态方法不需要实例来调用
//                System.out.println("testStaticValue:" + testStaticValue);

//                Method test1 = People.class.getMethod("test", People.class);//确定方法传入参数的类型
//                People getPeople = (People) test1.invoke(list.get(0), people);
//                System.out.println("getPeopleAge:" + getPeople.getAge());

//                Method test2 = People.class.getMethod("test", Array.newInstance(String.class, 0).getClass());
////                Object[] arys=(Object[]) test2.invoke("a", "b");//这样写：可变参数被理解为一个参数，故传参不匹配
//                //解决方案1:
//                Object[] arys = (Object[]) test2.invoke(list.get(0), (Object) new String[]{"a", "b"});
//                //解决方案2:
//                //数组这样写的原因：invoke的后一个参数是Object数组，单纯传一个数组，会被识别去与Object类型匹配，抛异常
////                Object[] arys = (Object[]) test2.invoke(list.get(0), new String[][]{new String[]{"a", "b"}});
//                System.out.println("arys:" + arys[0]);

                Method test3 = People.class.getMethod("test", String.class, int.class);//确定方法传入参数的类型
                String test = (String) test3.invoke(list.get(0), "test", 3);
                System.out.println(test);

            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

}