package com.sda.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailFormat {
    String pattern() default "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
}
