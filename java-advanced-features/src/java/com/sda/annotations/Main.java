package com.sda.annotations;

import com.sda.inheritence.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat();
        Car car = new Car();
        myCat.setName("Abby");
        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This cat class is very important");
        }

        if (!car.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This car class is not very important");
        }

        for (Method m : myCat.getClass().getDeclaredMethods()) {
            System.out.println(m);
            if (m.isAnnotationPresent(RunImmediatly.class)) {
                for (int i = 0; i < m.getAnnotation(RunImmediatly.class).times(); i++) {
                    m.invoke(myCat);
                }
            }
        }

        for (Field f : myCat.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(ImportantField.class)) {
                f.setAccessible(true);
                Object fieldValue = f.get(myCat);
                if (fieldValue instanceof String stringValue) {
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }

        try {
            myCat.setEmail("bla@gmail.com");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        System.out.println(myCat.getEmail());

    }

}
