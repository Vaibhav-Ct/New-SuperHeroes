package com.example.superheroes.controllers;

import com.example.superheroes.models.Superhero;
import com.example.superheroes.services.SuperheroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuperheroController {
    private final SuperheroService service;

    public SuperheroController(SuperheroService service) {
        this.service = service;
    }

    @PostMapping("/superhero")
    public void insertSuperhero(@RequestBody Superhero superhero) {
        service.insertSuperhero(superhero);
    }

    @PostMapping("/superheroes")
    public void insertManySuperheroes(@RequestBody List<Superhero> superheroList) {
        service.insertManySuperheroes(superheroList);
    }

    @PutMapping("/superheroes/{name}")
    public Superhero updateSuperhero(@PathVariable String name, @RequestBody Superhero updatedSuperhero) {
        return service.updateSuperhero(name, updatedSuperhero);
    }

    @DeleteMapping("/superheroes/{name}")
    public boolean deleteSuperhero(@PathVariable String name) {
        return service.deleteSuperhero(name);
    }

    @GetMapping("/superhero")
    public List<Superhero> getSuperheroes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String universe) {
        return service.getSuperheroes(name, universe);
    }
}
