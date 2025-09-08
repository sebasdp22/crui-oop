package com.oop.examples.patterns.gdocs2;

public class User implements Listener {
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

  public void notify(Change change) {
    System.out.println("User " + name + " notified as " + "about change: " + change.toString());
  }

  @Override
  public void onDocumentChanged(Document document, Change change) {
    this.notify(change);
  }
}
