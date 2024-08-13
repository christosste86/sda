package com.sda.inheritence;

import com.sda.enums.ZodiacSign;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.poop();

        cat.setColor("black");

        Cat cat2 = new Cat("blue", 50, 50, 2);
        System.out.println(cat);
        System.out.println(cat2);

        Animal animal = new Animal();
        System.out.println(animal);
        Animal animal2 = new Cat();
        System.out.println(animal2); // polymorfizmus - viem ich napr. dat spolu do listu

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        animals.add(animal);

        System.out.println(animals);

        cat.setZodiacSign(ZodiacSign.ARIES);

        System.out.println(cat);
    }
}
