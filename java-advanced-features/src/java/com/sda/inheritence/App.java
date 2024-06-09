package com.sda.inheritence;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Car car = new Car(); // instancia objektu
        Moto moto = new Moto(); // instancia objektu

        System.out.println(car);
        System.out.println(moto);

        Car car1 = new Car("purple", "manual", "opel", 4, "diesel"); // instancia objektu
        System.out.println(car1);

        // Polymorfizmus
        Garage garage = new Garage(); // instancia objektu

        garage.addVehicle(car);
        garage.addVehicle(moto);

        System.out.println(garage);

        Vehicle vehicle = new Car();
        Vehicle moto2 = new Moto();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(moto);
    }
}
