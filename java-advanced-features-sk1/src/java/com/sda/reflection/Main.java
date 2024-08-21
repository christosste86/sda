package com.sda.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.sda.reflection.Cat.staticPoop;

public class Main {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("black", 2);

        Field[] catFields = cat.getClass().getDeclaredFields();

//        cat.poop();
//        staticPoop();

//        for (Field field : catFields){
//            System.out.println(field);
//        }

        for (Field field : catFields) {
            if (field.getName().equals("color")) {
                field.setAccessible(true);
                field.set(cat, "white");
            }
        }

        System.out.println(cat);

        Method[] catMethoods = cat.getClass().getDeclaredMethods();

//        for (Method method : catMethoods){
//            System.out.println(method.getName());
//        }

        for (Method method : catMethoods) {
            if (method.getName().equals("setAge")) {
                method.invoke(cat, 8);
            }
        }


        System.out.println(cat);

        for (Method method : catMethoods) {
            if (method.getName().equals("poop")) {
                method.invoke(cat);
            }
        }

        for (Method method : catMethoods) {
            if (method.getName().equals("privatePoop")) {
                method.setAccessible(true);
                method.invoke(cat);
            }
        }

        for (Method method : catMethoods) {
            if (method.getName().equals("staticPoop")) {
                method.invoke(null);
            }
        }

        for (Method method : catMethoods) {
            if (method.getName().equals("privateStaticPoop")) {
                method.setAccessible(true);
                method.invoke(null);
            }
        }
    }
}
