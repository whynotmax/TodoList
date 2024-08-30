package dev.mzcy.todolist.model;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Task {

    String description;
    boolean isCompleted;
    Date dueTo; //if null, due to: never

}
