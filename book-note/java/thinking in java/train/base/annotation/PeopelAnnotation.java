package base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ji.xie
 * @Filename PeopelAnnotation.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/24 17:19</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,PARAMETER,FIELD})
public @interface PeopelAnnotation {
    String name() default "xieji";
    int age() default 18;
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @interface List{
        PeopelAnnotation[] value();
    }
}