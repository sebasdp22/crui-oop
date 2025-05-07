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
import com.oop.examples.inheritance.Topo;

public class TestsToStringMethods {
    public static void main(String[] args) {

        TestsToStringMethods.testFamiliyToString();
        TestsToStringMethods.testCatToString();
        TestsToStringMethods.testAnimalToString();
        TestsToStringMethods.testPersonToString();
        TestsToStringMethods.testDogToString();
        TestsToStringMethods.testTopoToString();
    }

    private static void testFamiliyToString() {
        System.out.println("\n=== Test Familiy toString() ===");
        Person person1 = new Person("John Doe", 30, "john@example.com");
        Person person2 = new Person("Ana Garcia", 25, "ana@example.com");
        List<Person> members = Arrays.asList(person1, person2);
    
        Familiy family = new Familiy(members);
        System.out.println(family.toString());
      }

    private static void testPersonToString() {
        System.out.println("\n=== Test Person toString() ===");
        Person person = new Person("Pepe Argento", 43, "pepe@mail.com");
        System.out.println(person.toString());
    }

    private static void testAnimalToString() {
        System.out.println("\n=== Test Animal toString() ===");
        Animal Animal = new Dog("Animalito", 1, "Golden Retriever");
        System.out.println(Animal.toString());
    }

    private static void testCatToString() {
        System.out.println("\n=== Test Cat toString() ===");
        Cat cat = new Cat("Michi", 3, "Siamese");
        System.out.println(cat.toString());
    }

    private static void testDogToString() {
        System.out.println("\n=== Test Dog toString() ===");
        Dog dog = new Dog("Fido", 5, "Golden Retriever");
        System.out.println(dog.toString());
    }

    private static void testTopoToString() {
        System.out.println("\n=== Test Topo toString() ===");
        Topo topo = new Topo("Topo", 10);
        System.out.println(topo.toString());
    }
}
