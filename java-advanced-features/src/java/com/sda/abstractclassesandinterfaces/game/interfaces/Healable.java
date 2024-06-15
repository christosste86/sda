package com.sda.abstractclassesandinterfaces.game.interfaces;

import com.sda.abstractclassesandinterfaces.game.models.Character;

public interface Healable {
    int mana = 50; // musia byt public final
    abstract void smallHeal(Character character); // abstract is redundant
    void bigHeal(Character character); // by default public, can be just public
}
