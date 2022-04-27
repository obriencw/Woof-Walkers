package com.woofWalkers.services;

import com.woofWalkers.models.Dog;
import com.woofWalkers.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{

    private DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {this.dogRepository = dogRepository; }

    @Override
    public List<Dog> getAllDogs() { return dogRepository.findAll();}

    @Override
    public Dog saveDog(Dog dog)
    { return dogRepository.save(dog);}

    /**
     * Returns a Dog object based on id argument
     *
     * If no dog found for given id, print message
     *
     * @param id id of a dog
     * @return Dog object
     * */
    @Override
    public Dog getDogById(long id) {
        Optional<Dog> optional = dogRepository.findById(id);
        Dog dog = null;
        if (optional.isPresent()) {
            dog = optional.get();
        } else {
            throw new RuntimeException("Dog not found for id :: " + id);
        }
        return dog;
    }

    @Override
    public void deleteDogById(long id) {
        this.dogRepository.deleteById(id);
    }
}
