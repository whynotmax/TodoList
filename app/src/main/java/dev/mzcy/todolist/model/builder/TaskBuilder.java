package dev.mzcy.todolist.model.builder;

import java.util.Date;

import dev.mzcy.todolist.model.Task;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TaskBuilder {

    String description;
    boolean isCompleted;
    Date dueTo;

    public TaskBuilder description(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder isCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public TaskBuilder dueTo(java.util.Date dueTo) {
        this.dueTo = dueTo;
        return this;
    }

    public dev.mzcy.todolist.model.Task build() {
        return new Task(description, isCompleted, dueTo);
    }

}
