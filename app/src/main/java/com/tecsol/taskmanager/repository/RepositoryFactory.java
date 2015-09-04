package com.tecsol.taskmanager.repository;

/**
 * Created by Aaditya on 9/1/2015.
 */
public class RepositoryFactory {

    private static TaskRepositoryInterface repo;

    public static TaskRepositoryInterface getTaskRepo() {
        if (repo == null) {
            repo = new TaskRepositoryCollection();
        }

        return repo;
    }

}
