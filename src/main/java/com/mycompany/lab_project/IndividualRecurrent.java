/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project;

import java.sql.Date;

public class IndividualRecurrent extends Task {
    int member_id;
    String repeat_every;
    Date end_date;

    public IndividualRecurrent(int member_id, String repeat_every, Date end_date, int id, String name, String discription, Date startdate, int duration, boolean completed) {
        super(id, name, discription, startdate, duration, completed);
        this.member_id = member_id;
        this.repeat_every = repeat_every;
        this.end_date = end_date;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getRepeat_every() {
        return repeat_every;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public void setRepeat_every(String repeat_every) {
        this.repeat_every = repeat_every;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    
    
}
