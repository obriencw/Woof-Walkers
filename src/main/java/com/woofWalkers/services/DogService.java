package com.woofWalkers.services;

import com.woofWalkers.models.Dog;

import java.util.List;

public interface DogService {
    List<Dog> getAllDogs();

    void saveDog(Dog dog);

    Dog getDogById(long id);

    void deleteDogById(long id);

}
