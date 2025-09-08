package com.oop.examples.patterns.gdocs;

public class Trello implements Listener {
  public void notify(Change change) {
    System.out.println("Trello notified about change: " + change.toString());
  }

  @Override
  public void notificar(Change change) {
    this.notify(change);
  }
}
