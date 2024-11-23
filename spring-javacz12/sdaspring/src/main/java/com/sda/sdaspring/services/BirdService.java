package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;

import java.util.ArrayList;
import java.util.List;

public class BirdService {
    private static List<Bird> birds = new ArrayList<>(List.of(
            new Bird(0l, "Eagle", true, 5000),
            new Bird(1l, "Penguin", false, 3000),
            new Bird(2l, "Sparrow", true, 30),
            new Bird(3l, "Ostrich", false, 12000)
    ));

    public static  List<Bird> getBirds(){
        // birds.clear();
        return birds;
    }

    public static List<Bird> getBirdsbyName(String search) {
        List<Bird> birds = new ArrayList<>();
        for (Bird bird : getBirds()){
            if (bird.getName().toLowerCase().contains(search.toLowerCase())){
                birds.add(bird);
            }
        }
        return birds;
    }
}
