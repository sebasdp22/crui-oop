package com.oop.examples.tasks.repositories;

import java.util.List;
import com.oop.examples.tasks.Task;

class TaskRepositoryMongo implements TaskRepository {
  Database db;

  public List<Task> getAll() {
    String sql = "SELECT * FROM tasks_in_mongo";
    List<Task> tasks = this.db.<Task>call(sql);
    return tasks;
  }
}
