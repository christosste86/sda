package com.sda.annotations;

import com.sda.inheritence.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        Dog dog = new Dog();

        if (cat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("this cat is very important");
        }

        if (!dog.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("this dog is not very important");
        }

        for (Method m : cat.getClass().getDeclaredMethods()){
            if (m.isAnnotationPresent(RunMethod.class)){
                RunMethod runMethod = m.getAnnotation(RunMethod.class);
                for (int i = 0; i < runMethod.times(); i++) {
                    m.invoke(cat);
                }

            }
        }

        cat.setColor("white");

        for (Field f : cat.getClass().getDeclaredFields()){
            if (f.isAnnotationPresent(ImportantString.class)){
                f.setAccessible(true);
                Object fieldVaule = f.get(cat);
                if (fieldVaule instanceof String stringValue){
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
