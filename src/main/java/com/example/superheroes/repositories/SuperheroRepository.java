package com.example.superheroes.repositories;

import com.example.superheroes.models.Superhero;
import org.springframework.stereotype.Repository;


import com.example.superheroes.models.Superhero;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SuperheroRepository extends MongoRepository<Superhero, String> {
    // Custom query methods if needed
    Superhero findByName(String name);
}