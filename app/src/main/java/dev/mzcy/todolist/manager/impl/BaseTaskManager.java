package dev.mzcy.todolist.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.mzcy.todolist.manager.TaskManager;
import dev.mzcy.todolist.manager.search.TaskSearchType;
import dev.mzcy.todolist.model.Task;
import dev.mzcy.todolist.model.builder.TaskBuilder;

public class BaseTaskManager implements TaskManager {
    protected List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(TaskBuilder taskBuilder) {
        tasks.add(taskBuilder.build());
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public boolean isExpired(Task task) {
        return task.getDueTo() != null && task.getDueTo().before(new java.util.Date());
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public List<Task> getTasksBySearch(TaskSearchType taskSearchType) {
        return tasks.stream().filter(task ->
                switch (taskSearchType) {
                    case DONE -> task.isCompleted();
                    case NOT_DONE -> !task.isCompleted();
                    case EXPIRED -> isExpired(task);
                }
        ).toList();
    }
}
