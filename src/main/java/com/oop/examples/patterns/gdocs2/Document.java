package com.oop.examples.patterns.gdocs2;

import java.util.ArrayList;
import java.util.List;

public class Document {
  private String title;
  private String content;
  private User user;
  private List<Listener> listeners;

  public Document(User user, String title, String content) {
    this.user = user;
    this.title = title;
    this.content = content;
    this.listeners = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
    this.listeners.forEach(listener -> listener.onDocumentChanged(this, new Change(user, content)));
  }

  public void addListener(Listener listener) {
    this.listeners.add(listener);
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void save() {
    System.out.println("Saving document...");
  }

  public void print() {
    System.out.println("Printing document...");
    System.out.println(title);
    System.out.println(content);
  }
}
