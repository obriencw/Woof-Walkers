package com.woofWalkers.services;

import com.woofWalkers.models.Dog;
import com.woofWalkers.models.User;

import java.util.List;

public interface DogService {
    List<Dog> getAllDogs();

    void saveDog(Dog dog);

    User getDogById(long id);

    void deleteDogById(long id);

}
