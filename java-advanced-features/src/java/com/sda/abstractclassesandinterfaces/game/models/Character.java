package com.sda.abstractclassesandinterfaces.game.models;

import com.sda.abstractclassesandinterfaces.game.interfaces.BasicFights;

import java.util.ArrayList;
import java.util.List;

public abstract class Character implements BasicFights {
    String name; // attributes be default public
    private int level; // atributes can be private protected or public
    private double hp;
    private double dmg;

    public Character(String name, int level, double hp, double dmg) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.dmg = dmg;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public double getDmg() {
        return dmg;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    abstract void speak(); // all functions be default protected
    abstract void walk(); // abstract methods can be just public or protected

    private boolean checkIfNameIsNotVulgare(String name){
        List<String> swear_words = new ArrayList<>();
        return swear_words.contains(name);
    } // non abstract / concrete functions can be private protected or public

}
