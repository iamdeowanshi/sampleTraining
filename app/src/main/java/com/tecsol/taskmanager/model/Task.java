package com.tecsol.taskmanager.model;

/**
 * Created by Aaditya on 9/1/2015.
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private String location;
    private String Date;
    private String Time;

    @Override
    public String toString() {
        return id + "-" + title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
