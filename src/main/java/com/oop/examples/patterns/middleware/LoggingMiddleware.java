package com.oop.examples.patterns.middleware;

public class LoggingMiddleware extends Middleware {

  public LoggingMiddleware(Handler next) {
    super(next);
  }

  @Override
  public void process(Request request, Response response) {
    System.out.println("--------------------------------");
    System.out.println("Request: " + request.toString());
    handleNext(request, response);
    System.out.println("Response: " + response.toString());
    System.out.println("--------------------------------");
  }
}
