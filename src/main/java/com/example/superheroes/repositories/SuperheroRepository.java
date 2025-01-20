package com.example.superheroes.repositories;

import com.example.superheroes.models.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SuperheroRepository {
    private final List<Superhero> superheroes = new ArrayList<>();

    public void insert(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void insertMany(List<Superhero> superheroList) {
        superheroes.addAll(superheroList);
    }

    public Superhero update(String name, Superhero updatedSuperhero) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(name)) {
                superhero.setPower(updatedSuperhero.getPower());
                superhero.setGender(updatedSuperhero.getGender());
                superhero.setAge(updatedSuperhero.getAge());
                superhero.setUniverse(updatedSuperhero.getUniverse());
                return superhero;
            }
        }
        return null; // Superhero not found
    }

    public boolean delete(String name) {
        return superheroes.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }

    public List<Superhero> getByNameOrUniverse(String name, String universe) {
        return superheroes.stream()
                .filter(s -> (name != null && s.getName().equalsIgnoreCase(name)) ||
                        (universe != null && s.getUniverse().equalsIgnoreCase(universe)))
                .collect(Collectors.toList());
    }
}
