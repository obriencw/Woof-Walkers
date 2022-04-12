package com.woofWalkers.repository;

import com.woofWalkers.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
    Dog findDogById(Long id);
}
