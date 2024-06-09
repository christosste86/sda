package com.sda.inheritence;

public class Car extends Vehicle{ // class / object

    public Car() {
    }

    public Car(String color, String transmition, String brand, int wheelCount, String fuel) {
        super(color, transmition, brand, wheelCount, fuel);
    }

}
