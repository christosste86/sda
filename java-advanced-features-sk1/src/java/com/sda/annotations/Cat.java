package com.sda.annotations;


@VeryImportant
public class Cat {

    @ImportantString
    private  String color;
    private int age;

    // @VeryImportant
    public void meow() {
        System.out.println("meow");
    }

    @RunMethod(times =  3)
    public void poop() {
        System.out.println("poop");
    }

    public void setColor(String color) {
        this.color = color;
    }
}

