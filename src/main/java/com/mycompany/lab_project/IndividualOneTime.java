/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project;

import java.sql.Date;


public class IndividualOneTime extends Task {
    int member_id;

    public IndividualOneTime(int member_id, int id, String name, String discription, Date startdate, int duration, boolean completed) {
        super(id, name, discription, startdate, duration, completed);
        this.member_id = member_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }
    
    
}
