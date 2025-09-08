package com.oop.examples.patterns.middleware;

public class LoggingMiddleware extends Middleware {
  static LoggingMiddleware instance = null;

  private LoggingMiddleware(Handler next) {
    super(next);
  }

  public static LoggingMiddleware getInstance(Handler next) {
    if (instance == null) {
      instance = new LoggingMiddleware(next);
    }
    return instance;
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
