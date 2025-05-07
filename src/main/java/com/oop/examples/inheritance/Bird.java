
// src/com/oop/examples/inheritance/Bird.java
package com.oop.examples.inheritance;

public class Bird {
    private String name;
    private String species;

    public Bird(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void fly() {
        System.out.println(name + " is flying!");
    }

    public void sing() {
        System.out.println(name + " is singing!");
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
