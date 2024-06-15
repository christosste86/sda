package com.sda.inheritence;

import com.sda.inheritence.enums.Transmition;

public class Car extends Vehicle{ // class / object

    public Car() {
    }

    public Car(String color, Transmition transmition, String brand, int wheelCount, String fuel) {
        super(color, transmition, brand, wheelCount, fuel);
    }

    @Override
    public void lightOn() {

    }

}
