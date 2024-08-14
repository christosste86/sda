package com.sda.abstractandinterfaces.animals.classes;

import com.sda.abstractandinterfaces.animals.classes.Animal;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("whoaf");
    } // inheritence - pes dedi z animal - zo superclass , parent class
    // pes je subclass, child class
}
