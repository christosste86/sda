package com.sda.abstractandinterfaces.animals.classes;


import com.sda.abstractandinterfaces.animals.interfaces.FlyAble;
import com.sda.abstractandinterfaces.animals.interfaces.SwimAble;

public class Duck extends Animal implements SwimAble, FlyAble { // mozem extednut len jednu classu- vysvetlenie v diamond problem
    // mozem implementnut viac interfacov
    @Override // nemusime pouzit anotaciu, ale upozorni nas na chybi pri prepisovani methody z parent classy ako nespravny return type alebo partametre
    public void makeSound() {
        System.out.println("Kvak kvak");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }

    @Override
    public void dive() {
        System.out.println("Duck is diving");
    }

    @Override
    public void floatOnWater() {
        System.out.println("Duck is floating");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public void flyDive() {
        System.out.println("Duck is flying down");
    }

    @Override
    public void flyAscent() {
        System.out.println("Duck is flying up");
    }
}
