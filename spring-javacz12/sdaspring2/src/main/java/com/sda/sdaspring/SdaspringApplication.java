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

	private  final BirdRepository birdRepository;

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
				new Bird( "Eagle", true, 5000),
				new Bird("Penguin", false, 3000),
				new Bird("Sparrow", true, 30),
				new Bird("Ostrich", false, 12000)
		));

		for (Bird bird : birds){
			birdRepository.save(bird);
		}

	}
}
