package com.sda.inheritence;

import java.util.ArrayList;
import java.util.List;

public class Garage { // class / object
    private List<Vehicle> vehicles = new ArrayList<>();

//    public Garage() {
//        this.vehicles = new ArrayList<>();
//    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "vehicles=" + vehicles +
                '}';
    }
}
