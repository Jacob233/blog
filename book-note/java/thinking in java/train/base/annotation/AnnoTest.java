package base.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author ji.xie
 * @Filename AnnoTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/24 17:31</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@PeopelAnnotation
public class AnnoTest {

    @PeopelAnnotation.List( {
            @PeopelAnnotation(name="hh"),
            @PeopelAnnotation
    } )
    private String name;
    private int age;

    public AnnoTest() {
        this.name = "sb";
    }

    @Test
    public void Test(){
        annoDeal();
        System.out.println("name:"+name+" age:"+age);
    }

    private void annoDeal(){
        try {
            Annotation anno=AnnoTest.class.getAnnotation(PeopelAnnotation.class);

            PeopelAnnotation pa=(PeopelAnnotation) anno;

            Field[] fields=AnnoTest.class.getDeclaredFields();
            for(Field field:fields){
                if(field.getType().equals(String.class)){
                    Annotation ano=field.getAnnotation(PeopelAnnotation.List.class);

                    PeopelAnnotation.List p=(PeopelAnnotation.List) ano;
                    for(PeopelAnnotation value:p.value()){
                        System.out.println(value.name());
                    }
                }
            }

            if(0==this.age){
                this.age=pa.age();
            }
        }catch (Exception e){
        }
    }
}