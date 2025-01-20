package com.example.superheroes.models;

public class Superhero {
    private String name;
    private String power;
    private String gender;
    private int age;
    private String universe;

    // Constructors
    public Superhero() {}

    public Superhero(String name, String power, String gender, int age, String universe) {
        this.name = name;
        this.power = power;
        this.gender = gender;
        this.age = age;
        this.universe = universe;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }
}
