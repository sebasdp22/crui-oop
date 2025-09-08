package com.oop.examples.patterns.gdocs;

public class UI implements Listener {
  public void refreshPage() {
    System.out.println("Refreshing page...");
  }

  @Override
  public void notificar(Change change) {
    this.refreshPage();
  }
}
