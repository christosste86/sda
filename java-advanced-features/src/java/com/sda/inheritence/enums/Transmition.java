package com.sda.inheritence.enums;

public enum Transmition {
    MANUAL(4, "manual"),
    AUTOMATIC(6, "automatic"),
    SEMI_AUTOMATIC(7, "semi automatic");

    private final int gears;
    private final String text;

    Transmition(int gears, String text) {
        this.gears = gears;
        this.text = text;
    }

    public int getGears() {
        return gears;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        // return this.getText();
        return  name().toLowerCase();
    }

}
