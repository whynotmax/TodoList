package dev.mzcy.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import dev.mzcy.todolist.manager.impl.BaseTaskManager;
import dev.mzcy.todolist.model.Task;
import dev.mzcy.todolist.model.builder.TaskBuilder;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class MainActivity extends AppCompatActivity {

    EditText editTextTask;
    Button buttonAdd;
    ListView listViewTasks;
    ArrayAdapter<String> adapter;
    BaseTaskManager taskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewTasks = findViewById(R.id.listViewTasks);

        taskManager = new BaseTaskManager();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getTaskDescriptions());
        listViewTasks.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String taskDescription = editTextTask.getText().toString();
            if (!taskDescription.isEmpty()) {
                taskManager.addTask(new TaskBuilder().description(taskDescription).dueTo(null).isCompleted(false));
                updateTaskList();
                editTextTask.setText("");
            }
        });
    }

    private List<String> getTaskDescriptions() {
        return taskManager.getAllTasks().stream()
                .map(Task::getDescription)
                .collect(Collectors.toList());
    }

    private void updateTaskList() {
        adapter.clear();
        adapter.addAll(getTaskDescriptions());
        adapter.notifyDataSetChanged();
    }
}