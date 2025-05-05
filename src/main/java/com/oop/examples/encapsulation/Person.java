package com.oop.examples.encapsulation;

import com.oop.examples.shared.Fotografiable;
import com.oop.examples.shared.Picture;

public class Person implements Fotografiable {
    private int age;
    private String email;
    private String name;

    // Constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public Picture takePicture() {
        return new Picture(200, 100, "jpg");
    }

    // Public getters and setters - controlled access to private fields
    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    // Public method to display person information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", email=" + email + "]\n";
    }
} 