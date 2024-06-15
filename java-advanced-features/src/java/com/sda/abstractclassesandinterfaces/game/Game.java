package com.sda.abstractclassesandinterfaces.game;

import com.sda.abstractclassesandinterfaces.game.models.Character;
import com.sda.abstractclassesandinterfaces.game.models.Mage;
import com.sda.abstractclassesandinterfaces.game.models.Warrior;

public class Game {
    public static void main(String[] args) {
        Character character = new Mage("Gandalf");
        // character.speak(); protected
        Warrior warrior = new Warrior("Konan");
        Mage mage = new Mage("Merlin");

        character.basicFightWithYourGun(warrior, 5);
        character.basicFightWithYourGun(mage, character.getDmg());

        System.out.println(warrior.getName() + " " + warrior.getHp());
        System.out.println(mage.getName() + " " + mage.getHp());
    }
}
