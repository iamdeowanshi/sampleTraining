package com.tecsol.taskmanager.repository;

import android.util.Log;
import android.widget.EditText;

import com.tecsol.taskmanager.R;
import com.tecsol.taskmanager.model.Task;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.tecsol.taskmanager.AddTaskActivity;

/**
 * Created by Aaditya on 9/1/2015.
 */
public class TaskRepositoryCollection implements TaskRepositoryInterface {

    private List<Task> tasks = new ArrayList<Task>();

    @Override
    public void insert(Task task) {
        tasks.add(task);
    }

    @Override
    public void delete(Task task) {
        delete(task.getId());
    }

    @Override
    public void delete(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return;
            }
        }
    }

    @Override
    public Task find(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) return task;
        }

        return null;
    }

    @Override
    public List<Task> readAll() {
        return tasks;
    }

}
