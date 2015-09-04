package com.tecsol.taskmanager.repository;

import com.tecsol.taskmanager.model.Task;

import java.util.List;

/**
 * Created by Aaditya on 9/1/2015.
 */
public interface TaskRepositoryInterface {

    void insert(Task task);

    void delete(Task task);

    void delete(int id);

    Task find(int id);

    List<Task> readAll();

}
