package com.sda.sdaspring.repositories;

import com.sda.sdaspring.models.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> findBirdsByNameContainsIgnoreCase(String s);

    @Query("SELECT b from Bird b WHERE b.canFly = true")
    List<Bird> findAllFlyingBirds();

    @Query(value = "SELECT * from birds WHERE can_fly = true", nativeQuery = true)
    List<Bird> findAllFlyingBirdsNative();
}
