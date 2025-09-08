package com.oop.examples.patterns.gdocs;

import java.util.ArrayList;
import java.util.List;

public class Document {
  private String title;
  private String content;
  private User user;
  private List<Change> changeHistory;
  private List<Listener> listeners;

  public Document(User user, String title, String content, List<Listener> listeners) {
    this.user = user;
    this.title = title;
    this.content = content;
    this.changeHistory = new ArrayList<>();
    this.listeners = listeners;
  }

  public void setContent(String content) {
    this.content = content;
    Change change = new Change(user, content);
    this.notify(change);
  }

  public void notify(Change change) {
    this.user.notify(change, "owner");
    this.changeHistory.add(change);

    this.listeners.forEach(listener -> listener.notificar(change));
  }

  public void addListener(Listener listener) {
    this.listeners.add(listener);
  }

  public void setTitle(String title) {
    this.title = title;
    this.notify(new Change(user, title));
  }

  public void save() {
    System.out.println("Saving document...");
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public void print() {
    System.out.println("Printing document...");
    System.out.println(title);
    System.out.println(content);
  }
}
