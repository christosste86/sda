package com.sda.sdaspring.services;

import com.sda.sdaspring.models.Bird;

import java.util.List;


public interface BirdService {


    List<Bird> getBirds();

    List<Bird> getBirdsbyName(String search);
}
