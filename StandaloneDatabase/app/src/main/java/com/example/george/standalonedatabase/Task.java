package com.example.george.standalonedatabase;

import java.sql.Blob;
import java.util.Arrays;

/**
 * Created by George on 9/25/2017.
 */

public class Task {
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String priority;
    private Blob[] photo;
    private String done;

    public Task()
    {

    }

    public Task(int id, String title, String description, String date, String time, String priority, Blob[] photo, String done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.photo = photo;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Blob[] getPhoto() {
        return photo;
    }

    public void setPhoto(Blob[] photo) {
        this.photo = photo;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", priority='" + priority + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", done='" + done + '\'' +
                '}';
    }
}
