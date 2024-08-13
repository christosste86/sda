package com.sda.inheritence;

import com.sda.enums.ZodiacSign;

public class Animal { // superclass , parent class
    String color; //  fields su by default public
    private int height;
    private int weight;
    private int age;

    private ZodiacSign zodiacSign;

    private HairType hairType; // composition - v classe pouzijem inu classu ako field

    public Animal(String color, int height, int weight, int age) {
        this.color = color;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public Animal() {
        this("brown", 30, 30, 0);
    }

    String getColor() {
        return color;
    } // methods are be default protected

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            this.age = age;
        } // encapsulation - priklad podmienky v settery
    }

    public HairType getHairType() {
        return hairType;
    }

    public void setHairType(HairType hairType) {
        this.hairType = hairType;
    }

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    // encapsulation - nastavim fields na private, pouzijem len potrebne getterry a settery - nie vsetky,
    // do setterov dam aj podmienky

    public void makeSound() {

    }

    public void poop() {
        System.out.println("poop");
    }

    public void sleep() {
        System.out.println("chrrrr");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {color='" + color + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", zodiacSign=" + zodiacSign +
                ", hairType=" + hairType +
                '}';
    }
}
