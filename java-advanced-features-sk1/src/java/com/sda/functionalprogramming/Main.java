package com.sda.functionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    final static int AGE = 2;

    public static void main(String[] args) {
        Food food1 = new Food("Fish", 200);
        Food food2 = new Food("Chicken", 150);
        Food food3 = new Food("Ham", 250);
        List<Cat> cats = List.of(new Cat("Garfield", 2, List.of(food1, food2)),
                new Cat("Blacky", 5, List.of(food1)),
                new Cat("Whity", 3, List.of(food1, food3)));


        for (Cat cat : cats) {
            if (cat.getAge() > AGE) {
                System.out.println(cat);
            }
        }

        System.out.println("...");

        cats.stream()
                .filter(new Predicate<Cat>() {
                    @Override
                    public boolean test(Cat cat) {
                        return cat.getAge() > AGE;
                    }
                })
                .forEach(System.out::println);

        System.out.println("...");

        cats.stream()
                .filter(cat -> cat.getAge() > AGE)
                .forEach(System.out::println);

        System.out.println("...");

        cats.stream()
                .filter(Main::isOverAge)
                .forEach(System.out::println);

        System.out.println("...");

        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }

        System.out.println("...");

        cats.stream()
                .map(new Function<Cat, String>() {
                    @Override
                    public String apply(Cat cat) {
                        return cat.getName();
                    }
                })
                .forEach(System.out::println);

        System.out.println("...");

        cats.stream()
                .map(cat -> {
                    return cat.getName();
                })
                .forEach(System.out::println);

        System.out.println("...");

        cats.stream()
                .map(cat -> cat.getName())
                .forEach(System.out::println);

        System.out.println("...");

        cats.stream()
                .map(Cat::getName)
                .forEach(System.out::println);

        System.out.println("...");

        List<Food> foods = new ArrayList<>();

        for (Cat cat : cats) {
            foods.addAll(cat.getFavoriteMeals());
        }

        System.out.println(foods);

        System.out.println("...");

        List<Food> foods2 = cats.stream()
                .flatMap(cat -> cat.getFavoriteMeals().stream())
                .toList();

        System.out.println(foods2);

        System.out.println("...");

        String name = "Garfield";

        Cat foundCat = null;

        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                foundCat = cat;
                break;
            }
        }

        if (foundCat != null) {
            System.out.println(foundCat);
        } else {
            System.out.println("Can not found cat");
        }

        System.out.println("...");

        Optional<Cat> foundCat2 = cats.stream()
                .filter(cat -> cat.getName().equals(name))
                .findFirst();

        if (!foundCat2.isEmpty()) {
            System.out.println(foundCat2.get());
        } else {
            System.out.println("Can not found cat");
        }

//        Cat cat = foundCat2.get();
//        System.out.println(cat);

    }

    private static boolean isOverAge(Cat cat) {
        return cat.getAge() > AGE;
    }
}
