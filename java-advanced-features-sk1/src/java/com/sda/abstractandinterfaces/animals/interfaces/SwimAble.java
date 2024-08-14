package com.sda.abstractandinterfaces.animals.interfaces;

public interface SwimAble {

    public final int swimSpeed = 50; // fields su public a final by default - nemusime pouzivat tieto keyword
    public abstract void swim(); // methody su public a abstract by default - nemusime pouzivat tieto keyword
    void dive();
    void floatOnWater();
}
