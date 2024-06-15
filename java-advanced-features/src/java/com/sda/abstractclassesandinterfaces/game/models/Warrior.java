package com.sda.abstractclassesandinterfaces.game.models;

import com.sda.abstractclassesandinterfaces.game.models.Character;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 1, 100, 10);
    }

    public Warrior() {
    }

    @Override
    public void basicFightWithYourGun(Character character, double dmg) {

    }

    @Override
    void speak() {

    }

    @Override
    void walk() {

    }
}
