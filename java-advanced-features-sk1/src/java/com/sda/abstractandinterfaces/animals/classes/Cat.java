package com.sda.abstractandinterfaces.animals.classes;

import com.sda.abstractandinterfaces.animals.classes.Animal;

public class Cat extends Animal { // inheritence - macka dedi z animal - zo superclass , parent class
    // macka je subclass, child class

    public Cat(String color, int height, int weight, int age) {
        super(color, height, weight, age);
    }

    public Cat() {
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

}
