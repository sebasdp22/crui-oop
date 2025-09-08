package com.oop.examples.patterns.gdocs2;

public class Change {
  private User user;
  private String content;

  public Change(User user, String content) {
    this.user = user;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Change [user=" + user.getName() + ", content=" + content + "]";
  }
}
