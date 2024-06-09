package com.sda.inheritence;

public class Vehicle { // class / object
    private String color;
    private String transmition;
    private String brand;
    private int wheelCount;
    private String fuel;

    public Vehicle() {
        this("red", "manual", "opel", 4, "diesel");
    }

    public Vehicle(String color, String transmition, String brand, int wheelCount, String fuel) {
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

    public String getTransmition() {
        return transmition;
    }

    public void setTransmition(String transmition) {
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

    public void lightOn(){

    }

    public void move(){

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
