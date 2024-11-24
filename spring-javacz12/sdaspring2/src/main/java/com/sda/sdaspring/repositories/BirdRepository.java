package com.sda.sdaspring.repositories;

import com.sda.sdaspring.models.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

}
