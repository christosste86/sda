package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;

import java.util.List;


public interface BirdService {


    List<Bird> getBirds();
    Bird getBirdById(Long id);

    List<Bird> getBirdsbyName(String search);

    void createBird(Bird bird);

    void deleteBird(Long id);

    void updateBird(Long id);

    List<Bird> findFlyingJPQL();

    List<Bird> findFlyingNative();




}
