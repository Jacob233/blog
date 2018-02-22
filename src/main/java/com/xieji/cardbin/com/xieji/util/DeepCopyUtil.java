package com.xieji.cardbin.com.xieji.util;

import java.io.*;
import java.util.List;

/**
 * @author ji.xie
 * @Filename DeepCopy.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/2/6 16:48</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class DeepCopyUtil {
    public static <T>List<T> deepCopy(List<T> src)throws IOException, ClassNotFoundException{
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
    ObjectOutputStream out = new ObjectOutputStream(byteOut);  
    out.writeObject(src);  
  
    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());  
    ObjectInputStream in = new ObjectInputStream(byteIn);  
    @SuppressWarnings("unchecked")  
    List<T> dest = (List<T>) in.readObject();  
    return dest;  
    }  
}