package com.oop.examples.patterns.gdocs;

public class User {
  private String name;
  private String email;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void notify(Change change, String role) {
    System.out.println(
        "User " + name + " notified as " + role + " about change: " + change.toString());
  }
}
