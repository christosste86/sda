package com.sda.inheritence;

import com.sda.inheritence.enums.Transmition;

public abstract class Vehicle { // class / object , Vehicle can be also abstract class
    private String color;
    private Transmition transmition;
    private String brand;
    private int wheelCount;
    private String fuel;

    public Vehicle() {
        this("red", Transmition.MANUAL, "opel", 4, "diesel");
    }

    public Vehicle(String color, Transmition transmition, String brand, int wheelCount, String fuel) {
        this.color = color;
        this.transmition = transmition;
        this.brand = brand;
        this.wheelCount = wheelCount;
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Transmition getTransmition() {
        return transmition;
    }

    public void setTransmition(Transmition transmition) {
        this.transmition = transmition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    abstract public void lightOn();

    public void move(){
        System.out.println(this.getClass().getSimpleName() + ": I am moving");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "color='" + color + '\'' +
                ", transmition='" + transmition + '\'' +
                ", brand='" + brand + '\'' +
                ", wheelCount=" + wheelCount +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
