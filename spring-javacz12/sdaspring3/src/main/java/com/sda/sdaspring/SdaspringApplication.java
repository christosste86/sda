package com.sda.sdaspring;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.repositories.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SdaspringApplication implements CommandLineRunner {

    private final BirdRepository birdRepository;

    @Autowired
    public SdaspringApplication(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(SdaspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		List<Bird> birds = new ArrayList<>(List.of(
				new Bird("Eagle", true, 5500),
				new Bird("Penguin", false, 4000),
				new Bird("Sparrow", true, 25),
				new Bird("Ostrich", false, 14000),
				new Bird("Hawk", true, 1300),
				new Bird("Flamingo", true, 3000),
				new Bird("Parrot", true, 500),
				new Bird("Albatross", true, 8000),
				new Bird("Peacock", true, 5000),
				new Bird("Crow", true, 400),
				new Bird("Dove", true, 300),
				new Bird("Pigeon", true, 500),
				new Bird("Woodpecker", true, 200),
				new Bird("Rooster", false, 2500),
				new Bird("Turkey", false, 10000),
				new Bird("Kiwi", false, 1200)
		));

        for (Bird bird : birds) {
            birdRepository.save(bird);
        }

    }
}
