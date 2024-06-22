package com.sda.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Garfield");
        names.add("Teoš");
        names.add("Felix");
        names.add("Melichard");

        for (String name : names) {
            if (!name.equals("Felix")) {
                Cat cat = new Cat(name);
                System.out.println(cat);
            }
        }

        System.out.println("...");

        names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !s.equals("Felix");
            }
        }).forEach(System.out::println);

        System.out.println("...");

        names.stream().filter(s -> !s.equals("Felix")).forEach(System.out::println);

        System.out.println("...");

        names.stream().filter(Main::isNotFelix).forEach(System.out::println);

        System.out.println("...");

        names.stream()
                .filter(Main::isNotFelix)
                .map(new Function<String, Cat>() {
                    @Override
                    public Cat apply(String s) {
                        Cat cat = new Cat(s);
                        return cat;
                    }
                })
                .forEach(System.out::println);

        System.out.println("...");

        names.stream()
                .filter(Main::isNotFelix)
                .map(s -> {
                    Cat cat = new Cat(s);
                    return cat;
                })
                .forEach(System.out::println);

        System.out.println("...");

        names.stream()
                .filter(Main::isNotFelix)
                .map(s -> new Cat(s))
                .forEach(System.out::println);

        System.out.println("...");

        names.stream()
                .filter(Main::isNotFelix)
                .map(Cat::new)
                .forEach(System.out::println);

        System.out.println("...");
        List<Cat> cats = Arrays.asList(new Cat("Garfield", 2, Arrays.asList("lasagne")),
                new Cat("Teoš", 4, Arrays.asList("fish fingers")),
                new Cat("Melichard", 7,Arrays.asList("fish", "chicken") ),
                new Cat("Felix", 3, Arrays.asList("beef", "ham")));

        Optional<String> meal = cats.stream()
                .map(cat -> cat.getFavoriteMeals().stream())
                .flatMap(stringStream -> stringStream.filter(m -> m.contains("fish")))
                .findAny();

        if (meal.isPresent()){
            String mealS = meal.get();
            System.out.println(mealS);
        }
    }

    private static boolean isNotFelix(String name) {
        return !name.equals("Felix");
    }
}
