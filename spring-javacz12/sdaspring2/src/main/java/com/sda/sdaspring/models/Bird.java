package com.sda.sdaspring.models;

public class Bird {
    private long id;

    private String name;

    private boolean canFly;
    private int weight;

    public Bird() {
    }

    public Bird(long id, String name, boolean canFly, int weight) {
        this.id = id;
        this.name = name;
        this.canFly = canFly;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getWeight() {
        return weight;
    }
}
