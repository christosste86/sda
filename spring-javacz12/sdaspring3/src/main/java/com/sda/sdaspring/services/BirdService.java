package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;

import java.util.List;


public interface BirdService {


    List<Bird> getBirds(int page, int size);

    Bird getBirdById(Long id);

    List<Bird> getBirdsByName(String search, int page, int size);

    void createBird(Bird bird);

    void deleteBird(Long id);

    void updateBird(Long id);

    List<Bird> findFlyingJPQL(int page, int size);

    List<Bird> findFlyingNative(int page, int size);

    List<Bird> findAllSorted(String parameter, int page, int size);
}
