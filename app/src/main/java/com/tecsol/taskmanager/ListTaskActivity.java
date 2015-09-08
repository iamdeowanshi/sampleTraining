package com.tecsol.taskmanager;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tecsol.taskmanager.model.Task;
import com.tecsol.taskmanager.repository.CustomTaskAdapter;
import com.tecsol.taskmanager.repository.RepositoryFactory;
import com.tecsol.taskmanager.repository.TaskRepositoryInterface;

import java.util.Iterator;

public class ListTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_task);

        TaskRepositoryInterface taskRepo = RepositoryFactory.getTaskRepo();

        ListView taskList = (ListView) findViewById(R.id.task_list_view);

        CustomTaskAdapter taskListAdapter = new CustomTaskAdapter(this, R.id.custom, taskRepo.readAll());
        //ArrayAdapter<Task> taskListAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, taskRepo.readAll());
        taskList.setAdapter(taskListAdapter);


    }
}
