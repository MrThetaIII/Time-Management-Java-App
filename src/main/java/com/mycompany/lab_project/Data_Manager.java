/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project;

import java.sql.*;
import java.util.ArrayList;

public class Data_Manager {
    Connection connection;
    public Data_Manager(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
    public void openConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_scheduler","root","MR0:360AcuteTheta!!Regular<>Axes");
        }catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public ArrayList<Member> get_members(){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM members");
            Member member;
            ArrayList<Member> members = new ArrayList();
            while (res.next()) {
                member = new Member(res.getInt("id"), res.getString("member_name"));
                members.add(member);
            }
            closeConnection();
            return members;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public ArrayList<MemberGroup> get_member_groups(){
        try {
            openConnection();
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            ResultSet res_groups = statement1.executeQuery("SELECT * FROM memberGroups");
            int groupID;
            ResultSet res_members;
            MemberGroup group;
            ArrayList<MemberGroup> groups = new ArrayList();
            Member member;
            ArrayList<Member> group_members;
            while (res_groups.next()) {
                groupID = res_groups.getInt("id");
                res_members = statement2.executeQuery("SELECT Members.id AS id, Members.member_name AS member_name FROM GroupAssignments JOIN Members ON GroupAssignments.member_id=Members.id WHERE GroupAssignments.group_id="+groupID);
                group_members = new ArrayList();
                while (res_members.next()) {
                    member = new Member(res_members.getInt("id"), res_members.getString("member_name"));
                    group_members.add(member);
                }
                group = new MemberGroup(res_groups.getInt("id"), res_groups.getString("group_name"), group_members);
                groups.add(group);
            }
            closeConnection();
            return groups;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public ArrayList<IndividualOneTime> get_individual_one_time(){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM individualOneTime");
            IndividualOneTime task;
            ArrayList<IndividualOneTime> tasks = new ArrayList();
            while (res.next()) {
                task = new IndividualOneTime(res.getInt("member_id"), res.getInt("id"), res.getString("task_name"), res.getString("task_description"), res.getDate("start_date"), res.getInt("duration"), res.getBoolean("completed"));
                tasks.add(task);
            }
            closeConnection();
            return tasks;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public ArrayList<IndividualRecurrent> get_individual_recurrent(){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM IndividualRecurrent");
            IndividualRecurrent task;
            ArrayList<IndividualRecurrent> tasks = new ArrayList();
            while (res.next()) {
                task = new IndividualRecurrent(res.getInt("member_id"),res.getString("repeat_every"),res.getDate("end_date"), res.getInt("id"), res.getString("task_name"), res.getString("task_description"), res.getDate("start_date"), res.getInt("duration"), res.getBoolean("completed"));
                tasks.add(task);
            }
            closeConnection();
            return tasks;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public ArrayList<GroupOneTime> get_group_one_time(){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM groupOneTime");
            GroupOneTime task;
            ArrayList<GroupOneTime> tasks = new ArrayList();
            while (res.next()) {
                task = new GroupOneTime(res.getInt("group_id"), res.getInt("id"), res.getString("task_name"), res.getString("task_description"), res.getDate("start_date"), res.getInt("duration"), res.getBoolean("completed"));
                tasks.add(task);
            }
            closeConnection();
            return tasks;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public ArrayList<GroupRecurrent> get_group_recurrent(){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM GroupRecurrent");
            GroupRecurrent task;
            ArrayList<GroupRecurrent> tasks = new ArrayList();
            while (res.next()) {
                task = new GroupRecurrent(res.getInt("group_id"),res.getString("repeat_every"),res.getDate("end_date"), res.getInt("id"), res.getString("task_name"), res.getString("task_description"), res.getDate("start_date"), res.getInt("duration"), res.getBoolean("completed"));
                tasks.add(task);
            }
            closeConnection();
            return tasks;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
    
    public void add_member(String name){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Members (member_name) VALUES ('" + name + "')");
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_member(int id, String name){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Members SET member_name='" + name + "' WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_member(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Members WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_group(String name){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO MemberGroups (group_name) VALUES ('" + name + "')");
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_group(int id, String name){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE MemberGroups SET group_name='" + name + "' WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_group(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM MemberGroups WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_group_member(int member_id, int group_id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO GroupAssignments (member_id, group_id) VALUES ("+member_id+", "+group_id+")");
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void remove_group_member(int member_id, int group_id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM GroupAssignments WHERE member_id="+member_id+" AND group_id="+group_id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_individual_one_time(String name, String description, String memberID, String startDate, String duration){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO individualOneTime (task_name, task_description, member_id, start_date, duration) VALUES ('" + name + "', '"+ description +"', "+ memberID + ", '" + startDate + "', " + duration + ")" );
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_individual_one_time(int id, String name, String description, String memberID, String startDate, String duration, String completed){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE individualOneTime SET task_name='" + name + "', task_description='" + description +"', member_id=" + memberID + ", start_date='" + startDate + "', duration=" + duration + ", completed=" + completed + " WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_individual_one_time(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM individualOneTime WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_individual_recurrent(String name, String description, String memberID, String startDate, String duration, String endDate, String repeatEvery){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO individualRecurrent (task_name, task_description, member_id, start_date, duration, end_date, repeat_every) VALUES ('" + name + "', '"+ description +"', "+ memberID + ", '" + startDate + "', " + duration + ", '" + endDate + "', '" + repeatEvery + "')" );
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_individual_recurrent(int id, String name, String description, String memberID, String startDate, String duration, String endDate, String repeatEvery, String completed){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE individualRecurrent SET task_name='" + name + "', task_description='" + description +"', member_id=" + memberID + ", start_date='" + startDate + "', duration=" + duration + ", end_date='" + endDate + "', repeat_every='" + repeatEvery + "', completed=" + completed + " WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_individual_recurrent(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM individualRecurrent WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_group_one_time(String name, String description, String groupID, String startDate, String duration){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO GroupOneTime (task_name, task_description, group_id, start_date, duration) VALUES ('" + name + "', '"+ description +"', "+ groupID + ", '" + startDate + "', " + duration + ")" );
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_group_one_time(int id, String name, String description, String groupID, String startDate, String duration, String completed){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE GroupOneTime SET task_name='" + name + "', task_description='" + description +"', group_id=" + groupID + ", start_date='" + startDate + "', duration=" + duration + ", completed=" + completed + " WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_group_one_time(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM GroupOneTime WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void add_group_recurrent(String name, String description, String groupID, String startDate, String duration, String endDate, String repeatEvery){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO GroupRecurrent (task_name, task_description, group_id, start_date, duration, end_date, repeat_every) VALUES ('" + name + "', '"+ description +"', "+ groupID + ", '" + startDate + "', " + duration + ", '" + endDate + "', '" + repeatEvery + "')" );
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void edit_group_recurrent(int id, String name, String description, String groupID, String startDate, String duration, String endDate, String repeatEvery, String completed){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE GroupRecurrent SET task_name='" + name + "', task_description='" + description +"', group_id=" + groupID + ", start_date='" + startDate + "', duration=" + duration + ", end_date='" + endDate + "', repeat_every='" + repeatEvery + "', completed=" + completed + " WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void delete_group_recurrent(int id){
        try {
            openConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM GroupRecurrent WHERE id=" + id);
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
