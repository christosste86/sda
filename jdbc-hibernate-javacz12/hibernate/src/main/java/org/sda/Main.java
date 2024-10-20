package org.sda;

import org.sda.daos.GenericDao;
import org.sda.models.Bird;
import org.sda.services.GenericService;

public class Main {
    public static void main(String[] args) {
        GenericDao<Bird, Long> birdDao = new GenericDao<>(Bird.class);
        GenericService<Bird, Long> birdService = new GenericService<>(birdDao);

        Bird bird = new Bird("Eagle", true, 3000);
        Bird bird2 = new Bird("Eagle2", true, 66000);

        birdService.save(bird);
        birdService.save(bird2);
        System.out.println(birdService.getById(1L));

        bird.setWeight(5000);

        birdService.update(bird);
        System.out.println(birdService.getById(1L));

        //birdService.delete(bird);
    }
}