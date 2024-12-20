package org.sda;

import org.sda.daos.GenericDao;
import org.sda.models.Bird;
import org.sda.models.Nest;
import org.sda.models.User;
import org.sda.services.ApiService;
import org.sda.services.GenericService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericDao<Bird, Long> birdDao = new GenericDao<>(Bird.class);
        GenericService<Bird, Long> birdService = new GenericService<>(birdDao);

        GenericDao<Nest, Long> nestDao = new GenericDao<>(Nest.class);
        GenericService<Nest, Long> nestService = new GenericService<>(nestDao);

        GenericDao<User, Long> userDao = new GenericDao<>(User.class);
        GenericService<User, Long> userService = new GenericService<>(userDao);

        Nest nest = new Nest("Tree Nest", 8, "Twigs");

        nestService.save(nest);

        Bird bird1 = new Bird("Eagle", true, 3000);
        Bird bird2 = new Bird("Eagle2", true, 66000);

        birdService.save(bird1);
        birdService.save(bird2);
        System.out.println(birdService.getById(1L));

        bird1.setWeight(5000);

        birdService.update(bird1);
        System.out.println(birdService.getById(1L));

        nest.setBird(bird1);
        nest.setBird(bird2);

        birdService.update(bird1);
        birdService.update(bird2);

        System.out.println(nest);
        for (Bird bird : nest.getBirds()){
            System.out.println(bird);
        }

        //birdService.delete(bird);

        ApiService apiService = new ApiService();

        try {
            List<User> users = apiService.fetchUsers();
            for (User user : users) {
                userService.save(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}