package com.mycompany.lab_project;

import java.util.ArrayList;

public class MemberGroup {
    private int id;
    private String name;
    private ArrayList<Member> members;
    
    public MemberGroup(int id, String name, ArrayList<Member> members){
        this.id = id;
        this.name = name;
        this.members  = members;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
    
    
}
