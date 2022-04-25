package com.woofWalkers.services;

import com.woofWalkers.models.Dog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DogServiceImplTest {

    @Autowired
    private DogService dogService;

    @BeforeEach
    void setUp() {
        List<Dog> allDogs = dogService.getAllDogs();
        for (Dog dog : allDogs) {
            dogService.deleteDogById(dog.getId());
        }
    }
    @Test
    void getAllDogs() {

        List<Dog> allDogs = dogService.getAllDogs();
        int beforeAddingMoreDogs = allDogs.size();

        Dog dog1 = new Dog();
        dog1.setDogName("Fido");
        dog1.setDogBreed("Golden Retriever");
        dog1.setDogSex("Male");
        dogService.saveDog(dog1);
        int afterAddingMoreDogs = dogService.getAllDogs().size();

        Assertions.assertThat(afterAddingMoreDogs).isEqualTo(beforeAddingMoreDogs + 1);
        Assertions.assertThat(allDogs.contains(dog1));
    }
}
