package com.sda.reflection;

public class R2D2 {

    private final String model;
    private String color;

    public R2D2(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void beep(){
        System.out.println("beep");
    }

    private void privateBeep(){
        System.out.println("private beep");
    }

    public static void staticBeep(){
        System.out.println("static beep");
    }

    private static void privateStaticBeep(){
        System.out.println("private static beep");
    }

    @Override
    public String toString() {
        return "R2D2{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
