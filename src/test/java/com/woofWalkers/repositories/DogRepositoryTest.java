package com.woofWalkers.repositories;

import com.woofWalkers.models.Dog;
import com.woofWalkers.repository.DogRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DogRepositoryTest {

    @Autowired
    private DogRepository dogRepository;

    @Test
    void findBreedByDogName_should_return_Breed_given_valid_dogName() {

        Dog fido = dogRepository.findBreedByDogName("Fido");
        Assertions.assertThat(fido.getDogBreed()).isEqualTo("Golden Retriever");
    }
}
