package com.sda.functionalprogramming;

import java.util.List;

public class Cat {
    private String name;
    private int age;
    private List<String> favoriteMeals;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age, List<String> favoriteMeals) {
        this.name = name;
        this.age = age;
        this.favoriteMeals = favoriteMeals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFavoriteMeals() {
        return favoriteMeals;
    }

    public void setFavoriteMeals(List<String> favoriteMeals) {
        this.favoriteMeals = favoriteMeals;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteMeals=" + favoriteMeals +
                '}';
    }
}
