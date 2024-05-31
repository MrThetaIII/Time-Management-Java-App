/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project;

import java.sql.Date;

public class GroupOneTime extends Task {
    int group_id;

    public GroupOneTime(int group_id, int id, String name, String discription, Date startdate, int duration, boolean completed) {
        super(id, name, discription, startdate, duration, completed);
        this.group_id = group_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

}
