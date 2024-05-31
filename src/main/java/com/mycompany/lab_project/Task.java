/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project;

import java.sql.Date;

public abstract class Task {
    int id;
    String name;
    String discription;
    Date startdate;
    int duration;
    boolean completed;

    public Task(int id, String name, String discription, Date startdate, int duration, boolean completed) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.startdate = startdate;
        this.duration = duration;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public Date getStartdate() {
        return startdate;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}
