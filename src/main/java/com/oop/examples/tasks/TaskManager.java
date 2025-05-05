package com.oop.examples.tasks;

import java.util.ArrayList;
import java.util.List;

import com.oop.examples.tasks.repositories.TaskRepository;

// To-Do list
// [] ir al super
// [x] bañar al perro

class TaskManager {

  private List<Task> tasks;
  private TaskRepository taskRepository;

  public TaskManager(TaskRepository taskRepository) {
    this.tasks = new ArrayList<>();
    this.taskRepository = taskRepository;
  }

  public void addTask(boolean isComplete, String description) {
    Task task = new Task(isComplete, description);
    this.tasks.add(task);
  }

  public List<Task> getAllTasks() {
    List<Task> tasks = this.taskRepository.getAll();
    tasks.removeIf(Task::isTooOld);
    return tasks;
  }

  public List<Task> getAllTasks2() {
    // List<Task> tasks = TaskWithORM.findAll();
    // tasks.removeIf(Task::isTooOld);
    // return tasks;
    return this.getAllTasks();
  }

  public void changeDescription(Task task, String description) {
    task.setDescription(description);
  }
}
