package com.sda.generics;

public class Main {
    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass(5);
        MyClass<Double> myClass1 = new MyClass<>(5.);
        MyClass<String> myClass2 = new MyClass<>("Hello");
        System.out.println(myClass);
        System.out.println(myClass1);
        System.out.println(myClass2);
    }
}
