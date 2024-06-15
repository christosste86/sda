package com.sda.abstractclassesandinterfaces.game.models;

import com.sda.abstractclassesandinterfaces.game.interfaces.Castable;
import com.sda.abstractclassesandinterfaces.game.interfaces.Healable;

public class Mage extends Character implements Healable, Castable {

    public Mage(String name) {
        super(name, 1, 50, 5);
    }

    public Mage() {
    }

    @Override
    void speak() {
        System.out.println("Hi, I am mage.");
    }

    @Override
    void walk() {

    }

    @Override
    public void waterSpell(Character character) {

    }

    @Override
    public void smallHeal(Character character) {

    }

    @Override
    public void bigHeal(Character character) {

    }


    @Override
    public void basicFightWithYourGun(Character character, double dmg) {
        if(dmg <= this.getDmg()){
            character.setHp(character.getHp() - dmg);
        } else {
            System.out.println("cheeeaaater");
        }
        if (character.getHp() <= 0) {
            System.out.println("you are dead");
        }
    }
}
