package com.sda.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws Exception {
        R2D2 r2D2 = new R2D2("Artoo-Detoo", "white-blue");

        Field[] r2D2Fields = r2D2.getClass().getDeclaredFields();

        for (Field f : r2D2Fields){
//            System.out.println(f.getName());
            if(f.getName().equals("model")){
                f.setAccessible(true);
                f.set(r2D2, "new model");
            }
        }

        System.out.println(r2D2);

        Method[] r2D2Methods = r2D2.getClass().getDeclaredMethods();

        for (Method m : r2D2Methods){
//            System.out.println(m.getName());
           if (m.getName().equals("setColor")){
               m.invoke(r2D2, "blue-white");
           }
        }
        System.out.println(r2D2);

        for (Method m : r2D2Methods){
            if (m.getName().equals("beep")){
                m.invoke(r2D2);
            }
        }

        for (Method m : r2D2Methods){
            if (m.getName().equals("privateBeep")){
                m.setAccessible(true);
                m.invoke(r2D2);
            }
        }

        for (Method m : r2D2Methods){
            if (m.getName().equals("staticBeep")){
                m.invoke(null);
            }
        }

        for (Method m : r2D2Methods){
            if (m.getName().equals("privateStaticBeep")){
                m.setAccessible(true);
                m.invoke(null);
            }
        }
    }
}
