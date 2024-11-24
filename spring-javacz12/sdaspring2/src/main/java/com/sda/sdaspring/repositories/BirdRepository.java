package com.sda.sdaspring.repositories;

import com.sda.sdaspring.models.Bird;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BirdRepository {
    private List<Bird> birds = new ArrayList<>(List.of(
            new Bird(0l, "Eagle", true, 5000),
            new Bird(1l, "Penguin", false, 3000),
            new Bird(2l, "Sparrow", true, 30),
            new Bird(3l, "Ostrich", false, 12000)
    ));

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }
}
