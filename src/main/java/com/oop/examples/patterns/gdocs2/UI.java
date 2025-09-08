package com.oop.examples.patterns.gdocs2;

public class UI implements Listener {
  public void refreshPage() {
    System.out.println("Refreshing page...");
  }

  @Override
  public void onDocumentChanged(Document document, Change change) {
    this.refreshPage();
  }
}
