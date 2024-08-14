package com.sda.abstractandinterfaces.animals.classes;

import com.sda.enums.ZodiacSign;

public abstract class Animal {
    String color; //  fields su by default public
    public int height;
    protected int weight;
    private int age; // fields mozu byt public protected aj private

    private ZodiacSign zodiacSign;

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

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    // encapsulation - nastavim fields na private, pouzijem len potrebne getterry a settery - nie vsetky,
    // do setterov dam aj podmienky

    public abstract void makeSound(); // abstract method - bez tela - kluc slovicko abstract - mozu byt protected aj public

    public void poop() {
        System.out.println("poop");
    }

    private void sleep() {
        System.out.println("chrrrr");
    } // methods mozu byt public protected aj private

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {color='" + color + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", zodiacSign=" + zodiacSign +
                '}';
    }
}
