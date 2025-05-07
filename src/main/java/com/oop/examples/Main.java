package com.oop.examples;

import com.oop.examples.inheritance.Dog;
import com.oop.examples.inheritance.Animal;
import com.oop.examples.inheritance.Cat;
import com.oop.examples.shared.Fotografiable;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Main.runCompositionExample();
    Main.runEncapsulationExample();
    Main.runInheritanceExample();
    Main.runPolymorphismExample();
    Main.takePictures();
  }

  private static void runCompositionExample() {
    System.out.println("\n=== Composition Example ===");
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
    List<Fotografiable> fotografiables = new ArrayList<Fotografiable>();
    fotografiables.add(new Dog("Buddy", 3, "Golden Retriever"));
    fotografiables.add(new Cat("Filomena", 2, "Black"));
    for (Fotografiable fotografiable : fotografiables) {
      fotografiable.takePicture();
    }
  }
}
  