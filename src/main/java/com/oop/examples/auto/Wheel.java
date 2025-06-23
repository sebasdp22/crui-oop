package com.oop.examples.auto;

public class Wheel {
  private String brand;
  private int pressure;

  public Wheel(String brand, int pressure) {
    this.brand = brand;
    this.pressure = pressure;
  }

  public void inflate(int amount) {
    pressure += amount;
  }
}
