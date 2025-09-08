package com.oop.examples.patterns.middleware;

public interface Handler {
  void process(Request request, Response response);
}
