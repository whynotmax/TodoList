package dev.mzcy.todolist.manager;

import java.util.List;

import dev.mzcy.todolist.manager.search.TaskSearchType;
import dev.mzcy.todolist.model.Task;
import dev.mzcy.todolist.model.builder.TaskBuilder;

public interface TaskManager {

    void addTask(TaskBuilder taskBuilder);

    void removeTask(Task task);

    boolean isExpired(Task task);

    List<Task> getAllTasks();

    List<Task> getTasksBySearch(TaskSearchType taskSearchType);

}
