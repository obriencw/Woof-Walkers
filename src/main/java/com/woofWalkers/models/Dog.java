package com.woofWalkers.models;

import javax.persistence.*;
import java.util.Objects;

// Dog model for creating table columns in database
@Entity
@Table
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;

    @Column(name = "dog_name")
    private String dogName;

    @Column(name = "dog_breed")
    private String dogBreed;

    @Column(name = "dog_sex")
    private String dogSex;

    public Dog() {
    }

    // constructor for Dog model
    public Dog(Long id, String dogName, String dogBreed, String dogSex) {
        this.id = id;
        this.dogName = dogName;
        this.dogBreed = dogBreed;
        this.dogSex = dogSex;
    }

    // getters and setters for Dog model
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogSex() {
        return dogSex;
    }

    public void setDogSex(String dogSex) {
        this.dogSex = dogSex;
    }

    // method used for testing whether a dog is added to the table in database
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && Objects.equals(dogName, dog.dogName) && Objects.equals(dogBreed, dog.dogBreed);
    }

    // method used for testing whether a do is in the table
    @Override
    public int hashCode() {return Objects.hash(id, dogName, dogBreed, dogSex); }
}
