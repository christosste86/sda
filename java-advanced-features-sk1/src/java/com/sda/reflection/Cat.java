package com.sda.reflection;

public class Cat {
    private final String color;
    private int age;

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void poop() {
        System.out.println("poop");
    }

    private void privatePoop() {
        System.out.println("private poop");
    }

    public static void staticPoop() {
        System.out.println("static poop");
    }

    private static void privateStaticPoop() {
        System.out.println("private static poop");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

