package com.oop.examples.patterns.gdocs;

import java.util.ArrayList;
import java.util.List;

public class GoogleDocsExample {

  public static void main(String[] args) {

    UI ui = new UI();
    Trello trello = new Trello();
    User user = new User("John Doe", "john.doe@example.com");

    List<Listener> notificables = new ArrayList<>();
    notificables.add(ui);
    notificables.add(trello);

    Document document = new Document(user, "Test", "This is a test document", notificables);

    User otherUser = new User("Jane Doe", "jane.doe@example.com");

    document.setContent("This is a test document updated 1");
    document.setContent("This is a test document updated 2");
  }

  public void createDocument() {
    System.out.println("Creating a document...");
  }
}
