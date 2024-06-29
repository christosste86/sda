package com.sda.abstractclassesandinterfaces.comparable;

public class Player implements Comparable<Player>{
    private String name;
    private  int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.score, o.getScore());
    }
}
