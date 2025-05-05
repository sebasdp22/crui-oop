package com.oop.examples.tasks.repositories;

import java.util.List;
import com.oop.examples.tasks.Task;

public interface TaskRepository {
    public List<Task> getAll();
}
