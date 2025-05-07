package com.oop.examples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oop.examples.composition.Familiy;
import com.oop.examples.encapsulation.Person;
import com.oop.examples.inheritance.Dog;
import com.oop.examples.shared.Fotografiable;
import com.oop.examples.inheritance.Animal;
import com.oop.examples.inheritance.Cat;

public class Main {
  public static void main(String[] args) {
    // Hay cuatro conceptos principales en POO:
    // 1. Composition
    // 2. Encapsulation
    // 3. Inheritance
    // 4. Polymorphism

    Main.runCompositionExample();
    Main.runEncapsulationExample();
    Main.runInheritanceExample();
    Main.runPolymorphismExample();

    Main.takePictures();
  }

  private static void runCompositionExample() {
    // Composition example
    System.out.println("\n=== Composition Example ===");
    Person person1 = new Person("Jorge Gomez", 30, "jorge@example.com");
    Person person2 = new Person("Ana Garcia", 25, "ana@example.com");
    Person person3 = new Person("Raul Garcia", 0, "raul@example.com");
    Person person4 = new Person("Jorge Marinoni", 43, "jorge@sharktech.com.ar");
    Person person5 = new Person("Otro Garcia", 0, "otro@example.com");
    Person person6 = new Person("Otro Garci 22", 0, "otro22@example.com");
    List<Person> originalMembers =
        new ArrayList<>(Arrays.asList(person1, person2, person3, person4, person5, person6));

    Familiy family = new Familiy(originalMembers);
    System.out.println(family.getMembers());
  }

  private static void runEncapsulationExample() {
    System.out.println("=== Encapsulation Example ===");
  }

  private static void runInheritanceExample() {
    System.out.println("\n=== Inheritance Example ===");
    Dog dog = new Dog("Buddy", 3, "Golden Retriever");
    dog.makeSound();
    dog.sleep();
    dog.fetch();
    dog.eat();
  }

  private static void runPolymorphismExample() {
    System.out.println("\n=== Polymorphism through Inheritance ===");
    Animal animal = new Dog("Max", 2, "Labrador");
    animal.makeSound();
    animal.sleep();
    animal = new Cat("Filomena", 2, "Black");
    animal.makeSound();
    animal.sleep();
    animal.makeSound();
    animal.sleep();
    animal.eat();
  }

  private static void takePictures() {
    List<Fotografiable> fotografiables = new ArrayList<>();
    fotografiables.add(new Dog("Buddy", 3, "Golden Retriever"));
    fotografiables.add(new Cat("Filomena", 2, "Black"));
    for (Fotografiable fotografiable : fotografiables) {
      fotografiable.takePicture();
    }
  }
} 