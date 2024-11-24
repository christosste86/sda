package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;
import com.sda.sdaspring.repositories.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Qualifier("birdServiceList")
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    @Autowired
    public BirdServiceImpl(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }


    @Override
    public List<Bird> getBirds() {
        return birdRepository.getBirds();
    }

    @Override
    public List<Bird> getBirdsbyName(String search) {
        List<Bird> birds = new ArrayList<>();
        for (Bird bird : this.getBirds()){
            if (bird.getName().toLowerCase().contains(search.toLowerCase())){
                birds.add(bird);
            }
        }
        return birds;
    }
}
