package base.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @author ji.xie
 * @Filename InvokeDemoII.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/28 15:56</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class InvokeDemoII {

    public void print(String string)
    {
        System.out.println("print(String string)");
        System.out.println(string);
    }

    public void print(String ... strings)
    {
        System.out.println("print(String ... string)");

        for(String string: strings)
            System.out.println(string);
    }

    public static void main(String[] args) throws Exception
    {
        InvokeDemoII InvokeDemoII = new InvokeDemoII();

        // 调用 print(String string)  
        Method method1 = InvokeDemoII.getClass().getMethod("print", String.class);
        method1.invoke(InvokeDemoII, "a");

        // 调用 print(String ... strings)  
        Method method2 = InvokeDemoII.getClass().getMethod("print", Array.newInstance(String.class, 0).getClass());
        method2.invoke(InvokeDemoII, new String[][]{new String[]{"a", "b"}});
    }
}