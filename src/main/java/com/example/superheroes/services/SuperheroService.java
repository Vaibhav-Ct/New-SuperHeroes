package com.example.superheroes.services;

import com.example.superheroes.models.Superhero;
import com.example.superheroes.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository repository;

    public SuperheroService(SuperheroRepository repository) {
        this.repository = repository;
    }

    public void insertSuperhero(Superhero superhero) {
        repository.insert(superhero);
    }

    public void insertManySuperheroes(List<Superhero> superheroList) {
        repository.insertMany(superheroList);
    }

    public Superhero updateSuperhero(String name, Superhero updatedSuperhero) {
        return repository.update(name, updatedSuperhero);
    }

    public boolean deleteSuperhero(String name) {
        return repository.delete(name);
    }

    public List<Superhero> getSuperheroes(String name, String universe) {
        return repository.getByNameOrUniverse(name, universe);
    }
}
