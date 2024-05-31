/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lab_project;

import java.util.ArrayList;

/**
 *
 * @author MrTheta
 */
public final class Main_Page extends javax.swing.JFrame {

    ArrayList<Member> members;
    ArrayList<MemberGroup> member_groups;
    ArrayList<IndividualOneTime> individual_one_time;
    ArrayList<IndividualRecurrent> individual_recurrent;
    ArrayList<GroupOneTime> group_one_time;
    ArrayList<GroupRecurrent> group_recurrent;
    
    final String[] repeat_every_array = new String[]{"Week", "2Weeks", "Month", "Semi-Annual", "Annual"};
    
    Data_Manager data_manager = new Data_Manager();
            
    public Main_Page() {
        initComponents();
        
        AddUserDialoge.setSize(410,130);
        UpdateUserDialoge.setSize(415,180);
        DeleteUserDialoge.setSize(415,130);
        AddGroupDialoge.setSize(410,130);
        UpdateGroupDialoge.setSize(415,180);
        DeleteGroupDialoge.setSize(415,130);
        AddGroupMemberDialoge.setSize(415,165);
        DeleteGroupMemberDialoge.setSize(415,165);
        AddActivityDialoge.setSize(550,400);
        UpdateActivityDialoge.setSize(550,435);
        DeleteActivityDialoge.setSize(550,165);
        
        updateFields();
        updateTable();
    }
    
    public void updateFields(){
        members = data_manager.get_members();
        member_groups = data_manager.get_member_groups();
        individual_one_time = data_manager.get_individual_one_time();
        individual_recurrent = data_manager.get_individual_recurrent();
        group_one_time = data_manager.get_group_one_time();
        group_recurrent = data_manager.get_group_recurrent();
    }
    
    public void updateTable(){
        if(individualRadio.isSelected() && OneTimeRadio.isSelected()){
            String[][] individual_one_time_tasks = new String[individual_one_time.size()][7];
            String[] headers = new String[]{"ID", "Task Name", "Task Description", "Member", "StartDate", "Duration", "Completed"};
            String id, task_name, task_desc, member="", start_date, duration, completed;
            IndividualOneTime indvO;
            for(int i = 0; i < individual_one_time.size(); i++){
                indvO = individual_one_time.get(i);
                id = ""+indvO.getId();
                task_name = indvO.getName();
                task_desc = indvO.getDiscription();
                for(Member m: members){
                    if(m.getId() == indvO.getMember_id()){
                        member = m.getName();
                        break;
                    }
                }
                start_date = indvO.getStartdate().toString();
                duration = ""+indvO.getDuration();
                completed = ""+indvO.isCompleted();
                individual_one_time_tasks[i] = new String[]{id, task_name, task_desc, member, start_date, duration, completed};
                
            }
            ResultsTable.setModel(new javax.swing.table.DefaultTableModel(individual_one_time_tasks, headers));
        }else if(individualRadio.isSelected()){
            String[][] individual_recurrent_tasks = new String[individual_recurrent.size()][7];
            String[] headers = new String[]{"ID", "Task Name", "Task Description", "Member", "StartDate", "Duration","Repeat Every","End Date", "Completed"};
            String id, task_name, task_desc, member="", start_date, duration,repeat_every, end_date, completed;
            IndividualRecurrent indvR;
            for(int i = 0; i < individual_recurrent.size(); i++){
                indvR = individual_recurrent.get(i);
                id = ""+indvR.getId();
                task_name = indvR.getName();
                task_desc = indvR.getDiscription();
                for(Member m: members){
                    if(m.getId() == indvR.getMember_id()){
                        member = m.getName();
                        break;
                    }
                }
                start_date = indvR.getStartdate().toString();
                duration = ""+indvR.getDuration();
                repeat_every = indvR.getRepeat_every();
                end_date = indvR.getEnd_date().toString();
                completed = ""+indvR.isCompleted();
                individual_recurrent_tasks[i] = new String[]{id, task_name, task_desc, member, start_date, duration, repeat_every, end_date, completed};
            }
            ResultsTable.setModel(new javax.swing.table.DefaultTableModel(individual_recurrent_tasks, headers));
        }else if(OneTimeRadio.isSelected()){
            String[][] group_one_time_tasks = new String[group_one_time.size()][7];
            String[] headers = new String[]{"ID", "Task Name", "Task Description", "Group", "StartDate", "Duration", "Completed"};
            String id, task_name, task_desc, group="", start_date, duration, completed;
            GroupOneTime groupO;
            for(int i = 0; i < group_one_time.size(); i++){
                groupO = group_one_time.get(i);
                id = ""+groupO.getId();
                task_name = groupO.getName();
                task_desc = groupO.getDiscription();
                for(MemberGroup g: member_groups){
                    if(g.getId() == groupO.getGroup_id()){
                        group = g.getName();
                        break;
                    }
                }
                start_date = groupO.getStartdate().toString();
                duration = ""+groupO.getDuration();
                completed = ""+groupO.isCompleted();
                group_one_time_tasks[i] = new String[]{id, task_name, task_desc, group, start_date, duration, completed};
                
            }
            ResultsTable.setModel(new javax.swing.table.DefaultTableModel(group_one_time_tasks, headers));
        }else{
            String[][] group_recurrent_tasks = new String[group_recurrent.size()][7];
            String[] headers = new String[]{"ID", "Task Name", "Task Description", "Group", "StartDate", "Duration","Repeat Every","End Date", "Completed"};
            String id, task_name, task_desc, group="", start_date, duration,repeat_every, end_date, completed;
            GroupRecurrent groupR;
            for(int i = 0; i < group_recurrent.size(); i++){
                groupR = group_recurrent.get(i);
                id = ""+groupR.getId();
                task_name = groupR.getName();
                task_desc = groupR.getDiscription();
                for(MemberGroup g: member_groups){
                    if(g.getId() == groupR.getGroup_id()){
                        group = g.getName();
                        break;
                    }
                }
                start_date = groupR.getStartdate().toString();
                duration = ""+groupR.getDuration();
                repeat_every = groupR.getRepeat_every();
                end_date = groupR.getEnd_date().toString();
                completed = ""+groupR.isCompleted();
                group_recurrent_tasks[i] = new String[]{id, task_name, task_desc, group, start_date, duration, repeat_every, end_date, completed};
            }
            ResultsTable.setModel(new javax.swing.table.DefaultTableModel(group_recurrent_tasks, headers));
        }
    }
    
    public void setUpdateActivity(){
        UpdateActivityNameInput.setEnabled(false);
        UpdateActivityDescriptionInput.setEnabled(false);
        UpdateActivityMemberCompo.setEnabled(false);
        UpdateActivityStartDateInput.setEnabled(false);
        UpdateActivityEndDateInput.setEnabled(false);
        UpdateActivityDurationInput.setEnabled(false);
        UpdateActivityRepeatEveryCombo.setEnabled(false);
        UpdateActivityCompletedCheckBox.setEnabled(false);
        UpdateActivityAcceptButton.setEnabled(false);

        UpdateActivityNameInput.setText("");
        UpdateActivityDescriptionInput.setText("");
        UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        UpdateActivityStartDateInput.setText("2000-01-01");
        UpdateActivityEndDateInput.setText("2000-01-01");
        UpdateActivityDurationInput.setValue(1);
        UpdateActivityRepeatEveryCombo.setSelectedIndex(0);
        UpdateActivityCompletedCheckBox.setSelected(false);
        
        if(UpdateActivityindividualRadio.isSelected() && UpdateActivityOneTimeRadio.isSelected()){
            UpdateActivityMemberLabel.setText("Member:");
            String[] TaskNames = new String[individual_one_time.size()];
            for(int i = 0; i < individual_one_time.size(); i++){
                TaskNames[i] = individual_one_time.get(i).getName();
            }
            UpdateActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else if(UpdateActivityindividualRadio.isSelected()){
            UpdateActivityMemberLabel.setText("Member:");
            String[] TaskNames = new String[individual_recurrent.size()];
            for(int i = 0; i < individual_recurrent.size(); i++){
                TaskNames[i] = individual_recurrent.get(i).getName();
            }
            UpdateActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else if(UpdateActivityOneTimeRadio.isSelected()){
            UpdateActivityMemberLabel.setText("Group:");
            String[] TaskNames = new String[group_one_time.size()];
            for(int i = 0; i < group_one_time.size(); i++){
                TaskNames[i] = group_one_time.get(i).getName();
            }
            UpdateActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else{
            UpdateActivityMemberLabel.setText("Group:");
            String[] TaskNames = new String[group_recurrent.size()];
            for(int i = 0; i < group_recurrent.size(); i++){
                TaskNames[i] = group_recurrent.get(i).getName();
            }
            UpdateActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }
    }
    
    public void setAddActivity(){
        AddActivityNameInput.setText("");
        AddActivityDescriptionInput.setText("");
        AddActivityMemberInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        AddActivityStartDateInput.setText("2000-01-01");
        AddActivityEndDateInput.setText("2000-01-01");
        AddActivityDurationInput.setValue(1);
        AddActivityRepeatEveryInput.setSelectedIndex(0);
        
        if(AddActivityIndividualRadio.isSelected()){
            AddActivityMemberLabel.setText("Member:");
            String[] MemberNames = new String[members.size()];
            for(int i = 0; i < members.size(); i++){
                MemberNames[i] = members.get(i).getName();
            }
            
            AddActivityMemberInput.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
            AddActivityEndDateInput.setEnabled(false);
            AddActivityRepeatEveryInput.setEnabled(false);
        }else{
            AddActivityMemberLabel.setText("Group:");
            String[] MemberGroupNames = new String[member_groups.size()];
            for(int i = 0; i < member_groups.size(); i++){
                MemberGroupNames[i] = member_groups.get(i).getName();
            }
            
            AddActivityMemberInput.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
        }
    }
    
    public void setDeleteActivity(){
        if(DeleteActivityIndividualRadio.isSelected() && DeleteActivityOneTimeRadio.isSelected()){
            String[] TaskNames = new String[individual_one_time.size()];
            for(int i = 0; i < individual_one_time.size(); i++){
                TaskNames[i] = individual_one_time.get(i).getName();
            }
            DeleteActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else if(DeleteActivityIndividualRadio.isSelected()){
            String[] TaskNames = new String[individual_recurrent.size()];
            for(int i = 0; i < individual_recurrent.size(); i++){
                TaskNames[i] = individual_recurrent.get(i).getName();
            }
            DeleteActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else if(DeleteActivityOneTimeRadio.isSelected()){
            String[] TaskNames = new String[group_one_time.size()];
            for(int i = 0; i < group_one_time.size(); i++){
                TaskNames[i] = group_one_time.get(i).getName();
            }
            DeleteActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }else{
            String[] TaskNames = new String[group_recurrent.size()];
            for(int i = 0; i < group_recurrent.size(); i++){
                TaskNames[i] = group_recurrent.get(i).getName();
            }
            DeleteActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(TaskNames));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddUserDialoge = new javax.swing.JDialog();
        AddUserCancelButton = new javax.swing.JButton();
        AddUserNameLabel = new javax.swing.JLabel();
        AddUserNameInput = new javax.swing.JTextField();
        AddUserAcceptButton = new javax.swing.JButton();
        SubjectRadioGroup = new javax.swing.ButtonGroup();
        FrequencyRadioGroup = new javax.swing.ButtonGroup();
        UpdateUserDialoge = new javax.swing.JDialog();
        UpdateMembersNamesLabel = new javax.swing.JLabel();
        UpdateMembersNamesCombo = new javax.swing.JComboBox<>();
        UpdateMembersNameInputLabel = new javax.swing.JLabel();
        UpdateMembersNameInput = new javax.swing.JTextField();
        UpdateMembersCancelButton = new javax.swing.JButton();
        UpdateMembersAcceptButton = new javax.swing.JButton();
        DeleteUserDialoge = new javax.swing.JDialog();
        DeleteMembersNamesLabel = new javax.swing.JLabel();
        DeleteMembersNamesCombo = new javax.swing.JComboBox<>();
        DeleteMembersCancelButton = new javax.swing.JButton();
        DeleteMembersAcceptButton = new javax.swing.JButton();
        AddGroupDialoge = new javax.swing.JDialog();
        AddGroupsCancelButton = new javax.swing.JButton();
        AddGroupsNameLabel = new javax.swing.JLabel();
        AddGroupsNameInput = new javax.swing.JTextField();
        AddGroupsAcceptButton = new javax.swing.JButton();
        UpdateGroupDialoge = new javax.swing.JDialog();
        UpdateGroupsNamesLabel = new javax.swing.JLabel();
        UpdateGroupsNamesCombo = new javax.swing.JComboBox<>();
        UpdateGroupsNameInputLabel = new javax.swing.JLabel();
        UpdateGroupsNameInput = new javax.swing.JTextField();
        UpdateGroupsCancelButton = new javax.swing.JButton();
        UpdateGroupsAcceptButton = new javax.swing.JButton();
        DeleteGroupDialoge = new javax.swing.JDialog();
        DeleteGroupsNamesCombo = new javax.swing.JComboBox<>();
        DeleteGroupsCancelButton = new javax.swing.JButton();
        DeleteGroupsAcceptButton = new javax.swing.JButton();
        DeleteGroupsNamesLabel = new javax.swing.JLabel();
        AddActivityDialoge = new javax.swing.JDialog();
        AddActivitySubjectRadioLabel = new javax.swing.JLabel();
        AddActivityIndividualRadio = new javax.swing.JRadioButton();
        AddActivityGroupRadio = new javax.swing.JRadioButton();
        AddActivityOneTimeRadio = new javax.swing.JRadioButton();
        AddActivityRecurrentRadio = new javax.swing.JRadioButton();
        AddActivityFrequencyRadioLabel = new javax.swing.JLabel();
        AddActivityNameLabel = new javax.swing.JLabel();
        AddActivityNameInput = new javax.swing.JTextField();
        AddActivityDescriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddActivityDescriptionInput = new javax.swing.JTextArea();
        AddActivityMemberLabel = new javax.swing.JLabel();
        AddActivityMemberInput = new javax.swing.JComboBox<>();
        AddActivityStartDateLabel = new javax.swing.JLabel();
        AddActivityStartDateInput = new javax.swing.JFormattedTextField();
        AddActivityDurationLabel = new javax.swing.JLabel();
        AddActivityDurationInput = new javax.swing.JSpinner();
        AddActivityEndDateLabel = new javax.swing.JLabel();
        AddActivityEndDateInput = new javax.swing.JFormattedTextField();
        AddActivityRepeatEveryLabel = new javax.swing.JLabel();
        AddActivityRepeatEveryInput = new javax.swing.JComboBox<>();
        AddActivityCancelButton = new javax.swing.JButton();
        AddActivityAcceptButton = new javax.swing.JButton();
        UpdateActivityDialoge = new javax.swing.JDialog();
        UpdateActivityCancelButton = new javax.swing.JButton();
        UpdateActivityindividualRadio = new javax.swing.JRadioButton();
        UpdateActivityAcceptButton = new javax.swing.JButton();
        UpdateActivityGroupRadio = new javax.swing.JRadioButton();
        UpdateActivityOneTimeRadio = new javax.swing.JRadioButton();
        UpdateActivityRecurrentRadio = new javax.swing.JRadioButton();
        UpdateActivityFrequencyRadioLabel = new javax.swing.JLabel();
        UpdateActivitySubjectRadioLabel = new javax.swing.JLabel();
        UpdateActivityTaskLabel = new javax.swing.JLabel();
        UpdateActivityTaskCombo = new javax.swing.JComboBox<>();
        UpdateActivityCompletedCheckBox = new javax.swing.JCheckBox();
        UpdateActivityRepeatEveryCombo = new javax.swing.JComboBox<>();
        UpdateActivityMemberLabel = new javax.swing.JLabel();
        UpdateActivityMemberCompo = new javax.swing.JComboBox<>();
        UpdateActivityStartDateLabel = new javax.swing.JLabel();
        UpdateActivityStartDateInput = new javax.swing.JFormattedTextField();
        UpdateActivityDurationLabel = new javax.swing.JLabel();
        UpdateActivityNameLabel = new javax.swing.JLabel();
        UpdateActivityDurationInput = new javax.swing.JSpinner();
        UpdateActivityNameInput = new javax.swing.JTextField();
        UpdateActivityEndDateLabel = new javax.swing.JLabel();
        UpdateActivityDescriptionLabel = new javax.swing.JLabel();
        UpdateActivityEndDateInput = new javax.swing.JFormattedTextField();
        UpdateActivityRepeatEveryLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UpdateActivityDescriptionInput = new javax.swing.JTextArea();
        DeleteActivityDialoge = new javax.swing.JDialog();
        DeleteActivitySubjectRadioLabel = new javax.swing.JLabel();
        DeleteActivityTasklabel = new javax.swing.JLabel();
        DeleteActivityIndividualRadio = new javax.swing.JRadioButton();
        DeleteActivityTaskCombo = new javax.swing.JComboBox<>();
        DeleteActivityAcceptButton = new javax.swing.JButton();
        DeleteActivityGroupRadio = new javax.swing.JRadioButton();
        DeleteActivityOneTimeRadio = new javax.swing.JRadioButton();
        DeleteActivityRecurrentRadio = new javax.swing.JRadioButton();
        DeleteActivityFrequencyRadioLabel = new javax.swing.JLabel();
        DeleteActivityCancelButton = new javax.swing.JButton();
        AddGroupMemberDialoge = new javax.swing.JDialog();
        AddGroupMemberGroupNameLabel = new javax.swing.JLabel();
        AddGroupMemberMemberNameLabel = new javax.swing.JLabel();
        AddGroupMemberGroupCombo = new javax.swing.JComboBox<>();
        AddGroupMemberMemberCombo = new javax.swing.JComboBox<>();
        AddGroupMemberAcceptButton = new javax.swing.JButton();
        AddGroupMemberCancelButton = new javax.swing.JButton();
        DeleteGroupMemberDialoge = new javax.swing.JDialog();
        RemoveGroupMemberGroupNameLabel = new javax.swing.JLabel();
        RemoveGroupMemberMemberNameLabel = new javax.swing.JLabel();
        RemoveGroupMemberGroupCombo = new javax.swing.JComboBox<>();
        RemoveGroupMemberMemberCombo = new javax.swing.JComboBox<>();
        RemoveGroupMemberAcceptButton = new javax.swing.JButton();
        RemoveGroupMemberCancelButton = new javax.swing.JButton();
        AddActivitySubjectButtonGroup = new javax.swing.ButtonGroup();
        UpdateActivitySubjectButtonGroup = new javax.swing.ButtonGroup();
        DeleteActivitySubjectButtonGroup = new javax.swing.ButtonGroup();
        AddActivityFrequencyButtonGroup = new javax.swing.ButtonGroup();
        UpdateActivityFrequencyButtonGroup = new javax.swing.ButtonGroup();
        DeleteActivityFrequencyButtonGroup = new javax.swing.ButtonGroup();
        SubjectRadioLabel = new javax.swing.JLabel();
        TableScrollPanel = new javax.swing.JScrollPane();
        ResultsTable = new javax.swing.JTable();
        individualRadio = new javax.swing.JRadioButton();
        GroupRadio = new javax.swing.JRadioButton();
        OneTimeRadio = new javax.swing.JRadioButton();
        RecurrentRadio = new javax.swing.JRadioButton();
        FrequencyRadioLabel = new javax.swing.JLabel();
        SchedulerMenuBar = new javax.swing.JMenuBar();
        EditMembersMenu = new javax.swing.JMenu();
        AddMemberOption = new javax.swing.JMenuItem();
        DeleteMemberOption = new javax.swing.JMenuItem();
        UpdateMemberOption = new javax.swing.JMenuItem();
        EditGroupsMenu = new javax.swing.JMenu();
        AddGroupOption = new javax.swing.JMenuItem();
        DeleteGroupOption = new javax.swing.JMenuItem();
        UpdateGroupOption = new javax.swing.JMenuItem();
        AddGroupMemberOption = new javax.swing.JMenuItem();
        DeleteGroupMemberOption = new javax.swing.JMenuItem();
        EditActivitiesMenu = new javax.swing.JMenu();
        AddActivityOption = new javax.swing.JMenuItem();
        DeleteActivityOption = new javax.swing.JMenuItem();
        UpdateActivityOption = new javax.swing.JMenuItem();

        AddUserDialoge.setTitle("Add a member");
        AddUserDialoge.setResizable(false);

        AddUserCancelButton.setText("Cancel");
        AddUserCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserCancelButtonActionPerformed(evt);
            }
        });

        AddUserNameLabel.setText("Name: ");

        AddUserNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserNameInputActionPerformed(evt);
            }
        });
        AddUserNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AddUserNameInputChanged(evt);
            }
        });

        AddUserAcceptButton.setText("Accept");
        AddUserAcceptButton.setEnabled(false);
        AddUserAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddUserDialogeLayout = new javax.swing.GroupLayout(AddUserDialoge.getContentPane());
        AddUserDialoge.getContentPane().setLayout(AddUserDialogeLayout);
        AddUserDialogeLayout.setHorizontalGroup(
            AddUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddUserDialogeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(AddUserNameLabel)
                .addGap(31, 31, 31)
                .addComponent(AddUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(AddUserDialogeLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(AddUserCancelButton)
                .addGap(14, 14, 14)
                .addComponent(AddUserAcceptButton))
        );
        AddUserDialogeLayout.setVerticalGroup(
            AddUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddUserDialogeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(AddUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddUserDialogeLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(AddUserNameLabel))
                    .addComponent(AddUserNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(AddUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddUserCancelButton)
                    .addComponent(AddUserAcceptButton)))
        );

        UpdateUserDialoge.setTitle("Update a member");
        UpdateUserDialoge.setResizable(false);

        UpdateMembersNamesLabel.setText("Members:");

        UpdateMembersNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UpdateMembersNamesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMembersNamesComboActionPerformed(evt);
            }
        });

        UpdateMembersNameInputLabel.setText("Name:");

        UpdateMembersNameInput.setEnabled(false);
        UpdateMembersNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMembersNameInputActionPerformed(evt);
            }
        });
        UpdateMembersNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UpdateUserNameInputChanged(evt);
            }
        });

        UpdateMembersCancelButton.setText("Cancel");
        UpdateMembersCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMembersCancelButtonActionPerformed(evt);
            }
        });

        UpdateMembersAcceptButton.setText("Accept");
        UpdateMembersAcceptButton.setEnabled(false);
        UpdateMembersAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMembersAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdateUserDialogeLayout = new javax.swing.GroupLayout(UpdateUserDialoge.getContentPane());
        UpdateUserDialoge.getContentPane().setLayout(UpdateUserDialogeLayout);
        UpdateUserDialogeLayout.setHorizontalGroup(
            UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateUserDialogeLayout.createSequentialGroup()
                .addGroup(UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateUserDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(UpdateMembersNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(UpdateMembersNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateUserDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(UpdateMembersNameInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(UpdateMembersNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateUserDialogeLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(UpdateMembersCancelButton)
                        .addGap(24, 24, 24)
                        .addComponent(UpdateMembersAcceptButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        UpdateUserDialogeLayout.setVerticalGroup(
            UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateUserDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateMembersNamesLabel)
                    .addComponent(UpdateMembersNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateMembersNameInputLabel)
                    .addComponent(UpdateMembersNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(UpdateUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateMembersCancelButton)
                    .addComponent(UpdateMembersAcceptButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        DeleteUserDialoge.setTitle("Delete a member");
        DeleteUserDialoge.setResizable(false);

        DeleteMembersNamesLabel.setText("Members:");

        DeleteMembersNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeleteMembersNamesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMembersNamesComboActionPerformed(evt);
            }
        });

        DeleteMembersCancelButton.setText("Cancel");
        DeleteMembersCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMembersCancelButtonActionPerformed(evt);
            }
        });

        DeleteMembersAcceptButton.setText("Accept");
        DeleteMembersAcceptButton.setEnabled(false);
        DeleteMembersAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMembersAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteUserDialogeLayout = new javax.swing.GroupLayout(DeleteUserDialoge.getContentPane());
        DeleteUserDialoge.getContentPane().setLayout(DeleteUserDialogeLayout);
        DeleteUserDialogeLayout.setHorizontalGroup(
            DeleteUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteUserDialogeLayout.createSequentialGroup()
                .addGroup(DeleteUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteUserDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(DeleteMembersNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DeleteMembersNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteUserDialogeLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(DeleteMembersCancelButton)
                        .addGap(24, 24, 24)
                        .addComponent(DeleteMembersAcceptButton)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        DeleteUserDialogeLayout.setVerticalGroup(
            DeleteUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteUserDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DeleteUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteMembersNamesLabel)
                    .addComponent(DeleteMembersNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(DeleteUserDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteMembersCancelButton)
                    .addComponent(DeleteMembersAcceptButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        AddGroupDialoge.setTitle("Add a group");
        AddGroupDialoge.setResizable(false);

        AddGroupsCancelButton.setText("Cancel");
        AddGroupsCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupsCancelButtonActionPerformed(evt);
            }
        });

        AddGroupsNameLabel.setText("Name: ");

        AddGroupsNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupsNameInputActionPerformed(evt);
            }
        });
        AddGroupsNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AddGroupsNameInputChanged(evt);
            }
        });

        AddGroupsAcceptButton.setText("Accept");
        AddGroupsAcceptButton.setEnabled(false);
        AddGroupsAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupsAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddGroupDialogeLayout = new javax.swing.GroupLayout(AddGroupDialoge.getContentPane());
        AddGroupDialoge.getContentPane().setLayout(AddGroupDialogeLayout);
        AddGroupDialogeLayout.setHorizontalGroup(
            AddGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddGroupDialogeLayout.createSequentialGroup()
                .addGroup(AddGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddGroupDialogeLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(AddGroupsNameLabel)
                        .addGap(31, 31, 31)
                        .addComponent(AddGroupsNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddGroupDialogeLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(AddGroupsCancelButton)
                        .addGap(14, 14, 14)
                        .addComponent(AddGroupsAcceptButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        AddGroupDialogeLayout.setVerticalGroup(
            AddGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddGroupDialogeLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(AddGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddGroupDialogeLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(AddGroupsNameLabel))
                    .addComponent(AddGroupsNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(AddGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGroupsCancelButton)
                    .addComponent(AddGroupsAcceptButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        UpdateGroupDialoge.setTitle("Edit a group");
        UpdateGroupDialoge.setResizable(false);

        UpdateGroupsNamesLabel.setText("Groups:");

        UpdateGroupsNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UpdateGroupsNamesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGroupsNamesComboActionPerformed(evt);
            }
        });

        UpdateGroupsNameInputLabel.setText("Name:");

        UpdateGroupsNameInput.setEnabled(false);
        UpdateGroupsNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                UpdateGroupsNameInputUpdateUserNameInputChanged(evt);
            }
        });

        UpdateGroupsCancelButton.setText("Cancel");
        UpdateGroupsCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGroupsCancelButtonActionPerformed(evt);
            }
        });

        UpdateGroupsAcceptButton.setText("Accept");
        UpdateGroupsAcceptButton.setEnabled(false);
        UpdateGroupsAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGroupsAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdateGroupDialogeLayout = new javax.swing.GroupLayout(UpdateGroupDialoge.getContentPane());
        UpdateGroupDialoge.getContentPane().setLayout(UpdateGroupDialogeLayout);
        UpdateGroupDialogeLayout.setHorizontalGroup(
            UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateGroupDialogeLayout.createSequentialGroup()
                .addGroup(UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateGroupDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(UpdateGroupsNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(UpdateGroupsNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateGroupDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(UpdateGroupsNameInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(UpdateGroupsNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateGroupDialogeLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(UpdateGroupsCancelButton)
                        .addGap(24, 24, 24)
                        .addComponent(UpdateGroupsAcceptButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UpdateGroupDialogeLayout.setVerticalGroup(
            UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateGroupDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateGroupsNamesLabel)
                    .addComponent(UpdateGroupsNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateGroupsNameInputLabel)
                    .addComponent(UpdateGroupsNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(UpdateGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateGroupsCancelButton)
                    .addComponent(UpdateGroupsAcceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DeleteGroupDialoge.setTitle("Delete a group");
        DeleteGroupDialoge.setResizable(false);

        DeleteGroupsNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DeleteGroupsNamesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupsNamesComboActionPerformed(evt);
            }
        });

        DeleteGroupsCancelButton.setText("Cancel");
        DeleteGroupsCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupsCancelButtonActionPerformed(evt);
            }
        });

        DeleteGroupsAcceptButton.setText("Accept");
        DeleteGroupsAcceptButton.setEnabled(false);
        DeleteGroupsAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupsAcceptButtonActionPerformed(evt);
            }
        });

        DeleteGroupsNamesLabel.setText("Groups:");

        javax.swing.GroupLayout DeleteGroupDialogeLayout = new javax.swing.GroupLayout(DeleteGroupDialoge.getContentPane());
        DeleteGroupDialoge.getContentPane().setLayout(DeleteGroupDialogeLayout);
        DeleteGroupDialogeLayout.setHorizontalGroup(
            DeleteGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteGroupDialogeLayout.createSequentialGroup()
                .addGroup(DeleteGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteGroupDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(DeleteGroupsNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DeleteGroupsNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteGroupDialogeLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(DeleteGroupsCancelButton)
                        .addGap(24, 24, 24)
                        .addComponent(DeleteGroupsAcceptButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeleteGroupDialogeLayout.setVerticalGroup(
            DeleteGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteGroupDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DeleteGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteGroupsNamesLabel)
                    .addComponent(DeleteGroupsNamesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(DeleteGroupDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteGroupsCancelButton)
                    .addComponent(DeleteGroupsAcceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AddActivityDialoge.setTitle("Add an activity");
        AddActivityDialoge.setResizable(false);

        AddActivitySubjectRadioLabel.setText("Subject :");

        AddActivitySubjectButtonGroup.add(AddActivityIndividualRadio);
        AddActivityIndividualRadio.setSelected(true);
        AddActivityIndividualRadio.setText("Individul");
        AddActivityIndividualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityIndividualRadioActionPerformed(evt);
            }
        });

        AddActivitySubjectButtonGroup.add(AddActivityGroupRadio);
        AddActivityGroupRadio.setText("Group");
        AddActivityGroupRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityGroupRadioActionPerformed(evt);
            }
        });

        AddActivityFrequencyButtonGroup.add(AddActivityOneTimeRadio);
        AddActivityOneTimeRadio.setSelected(true);
        AddActivityOneTimeRadio.setText("One Time");
        AddActivityOneTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityOneTimeRadioActionPerformed(evt);
            }
        });

        AddActivityFrequencyButtonGroup.add(AddActivityRecurrentRadio);
        AddActivityRecurrentRadio.setText("Recurrent");
        AddActivityRecurrentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityRecurrentRadioActionPerformed(evt);
            }
        });

        AddActivityFrequencyRadioLabel.setText("Frequency:");

        AddActivityNameLabel.setText("Task Name: ");

        AddActivityDescriptionLabel.setText("Task Descreption: ");

        AddActivityDescriptionInput.setColumns(20);
        AddActivityDescriptionInput.setRows(5);
        jScrollPane1.setViewportView(AddActivityDescriptionInput);

        AddActivityMemberLabel.setText("Member:");

        AddActivityMemberInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AddActivityStartDateLabel.setText("Start Date:");

        AddActivityStartDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        AddActivityDurationLabel.setText("Duration:");

        AddActivityDurationInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        AddActivityEndDateLabel.setText("End Date:");

        AddActivityEndDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        AddActivityRepeatEveryLabel.setText("Repeat Every:");

        AddActivityRepeatEveryInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weak", "2 Weaks", "Month", "Semi-Annual", "Annual" }));

        AddActivityCancelButton.setText("Cancel");
        AddActivityCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityCancelButtonActionPerformed(evt);
            }
        });

        AddActivityAcceptButton.setText("Accept");
        AddActivityAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityAcceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddActivityDialogeLayout = new javax.swing.GroupLayout(AddActivityDialoge.getContentPane());
        AddActivityDialoge.getContentPane().setLayout(AddActivityDialogeLayout);
        AddActivityDialogeLayout.setHorizontalGroup(
            AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AddActivityStartDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(AddActivityStartDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(AddActivityDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(AddActivityDurationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AddActivityEndDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(AddActivityEndDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(AddActivityRepeatEveryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(AddActivityRepeatEveryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(AddActivityCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(AddActivityAcceptButton))
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addComponent(AddActivityDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addComponent(AddActivityMemberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(AddActivityMemberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addComponent(AddActivitySubjectRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(AddActivityIndividualRadio)
                        .addGap(19, 19, 19)
                        .addComponent(AddActivityGroupRadio)
                        .addGap(12, 12, 12)
                        .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(AddActivityOneTimeRadio))
                            .addComponent(AddActivityFrequencyRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(AddActivityRecurrentRadio))
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addComponent(AddActivityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddActivityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        AddActivityDialogeLayout.setVerticalGroup(
            AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddActivityIndividualRadio)
                        .addComponent(AddActivitySubjectRadioLabel))
                    .addComponent(AddActivityGroupRadio)
                    .addComponent(AddActivityOneTimeRadio)
                    .addComponent(AddActivityFrequencyRadioLabel)
                    .addComponent(AddActivityRecurrentRadio))
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(AddActivityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddActivityDialogeLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(AddActivityNameLabel)))
                .addGap(14, 14, 14)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddActivityDescriptionLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddActivityMemberLabel)
                    .addComponent(AddActivityMemberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddActivityStartDateLabel)
                    .addComponent(AddActivityStartDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddActivityDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddActivityDurationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddActivityEndDateLabel)
                    .addComponent(AddActivityEndDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddActivityRepeatEveryLabel)
                    .addComponent(AddActivityRepeatEveryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(AddActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddActivityCancelButton)
                    .addComponent(AddActivityAcceptButton)))
        );

        UpdateActivityDialoge.setTitle("Update an activity");
        UpdateActivityDialoge.setResizable(false);

        UpdateActivityCancelButton.setText("Cancel");
        UpdateActivityCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityCancelButtonActionPerformed(evt);
            }
        });

        UpdateActivitySubjectButtonGroup.add(UpdateActivityindividualRadio);
        UpdateActivityindividualRadio.setSelected(true);
        UpdateActivityindividualRadio.setText("Individul");
        UpdateActivityindividualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityindividualRadioActionPerformed(evt);
            }
        });

        UpdateActivityAcceptButton.setText("Accept");
        UpdateActivityAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityAcceptButtonActionPerformed(evt);
            }
        });

        UpdateActivitySubjectButtonGroup.add(UpdateActivityGroupRadio);
        UpdateActivityGroupRadio.setText("Group");
        UpdateActivityGroupRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityGroupRadioActionPerformed(evt);
            }
        });

        UpdateActivityFrequencyButtonGroup.add(UpdateActivityOneTimeRadio);
        UpdateActivityOneTimeRadio.setSelected(true);
        UpdateActivityOneTimeRadio.setText("One Time");
        UpdateActivityOneTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityOneTimeRadioActionPerformed(evt);
            }
        });

        UpdateActivityFrequencyButtonGroup.add(UpdateActivityRecurrentRadio);
        UpdateActivityRecurrentRadio.setText("Recurrent");
        UpdateActivityRecurrentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityRecurrentRadioActionPerformed(evt);
            }
        });

        UpdateActivityFrequencyRadioLabel.setText("Frequency:");

        UpdateActivitySubjectRadioLabel.setText("Subject :");

        UpdateActivityTaskLabel.setText("Task:");

        UpdateActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        UpdateActivityTaskCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityTaskComboActionPerformed(evt);
            }
        });

        UpdateActivityCompletedCheckBox.setText("Completed");

        UpdateActivityRepeatEveryCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weak", "2 Weaks", "Month", "Semi-Annual", "Annual" }));

        UpdateActivityMemberLabel.setText("Member:");

        UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        UpdateActivityStartDateLabel.setText("Start Date:");

        UpdateActivityStartDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        UpdateActivityDurationLabel.setText("Duration:");

        UpdateActivityNameLabel.setText("Task Name: ");

        UpdateActivityDurationInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        UpdateActivityEndDateLabel.setText("End Date:");

        UpdateActivityDescriptionLabel.setText("Task Descreption: ");

        UpdateActivityEndDateInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        UpdateActivityRepeatEveryLabel.setText("Repeat Every:");

        UpdateActivityDescriptionInput.setColumns(20);
        UpdateActivityDescriptionInput.setRows(5);
        jScrollPane3.setViewportView(UpdateActivityDescriptionInput);

        javax.swing.GroupLayout UpdateActivityDialogeLayout = new javax.swing.GroupLayout(UpdateActivityDialoge.getContentPane());
        UpdateActivityDialoge.getContentPane().setLayout(UpdateActivityDialogeLayout);
        UpdateActivityDialogeLayout.setHorizontalGroup(
            UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivitySubjectRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(UpdateActivityindividualRadio)
                .addGap(19, 19, 19)
                .addComponent(UpdateActivityGroupRadio)
                .addGap(12, 12, 12)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityFrequencyRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(UpdateActivityOneTimeRadio)))
                .addGap(14, 14, 14)
                .addComponent(UpdateActivityRecurrentRadio))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityTaskLabel)
                .addGap(74, 74, 74)
                .addComponent(UpdateActivityTaskCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityMemberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(UpdateActivityMemberCompo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityStartDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityStartDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(UpdateActivityDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(UpdateActivityDurationInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityEndDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(UpdateActivityEndDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(UpdateActivityRepeatEveryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(UpdateActivityRepeatEveryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(UpdateActivityCompletedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(UpdateActivityCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(UpdateActivityAcceptButton))
        );
        UpdateActivityDialogeLayout.setVerticalGroup(
            UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateActivityDialogeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivitySubjectRadioLabel)
                    .addComponent(UpdateActivityindividualRadio)
                    .addComponent(UpdateActivityGroupRadio)
                    .addComponent(UpdateActivityFrequencyRadioLabel)
                    .addComponent(UpdateActivityOneTimeRadio)
                    .addComponent(UpdateActivityRecurrentRadio))
                .addGap(19, 19, 19)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityTaskLabel)
                    .addComponent(UpdateActivityTaskCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityNameLabel)
                    .addComponent(UpdateActivityNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityDescriptionLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityMemberLabel)
                    .addComponent(UpdateActivityMemberCompo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityStartDateLabel)
                    .addComponent(UpdateActivityStartDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateActivityDurationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateActivityDurationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityEndDateLabel)
                    .addComponent(UpdateActivityEndDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateActivityRepeatEveryLabel)
                    .addComponent(UpdateActivityRepeatEveryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(UpdateActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateActivityCompletedCheckBox)
                    .addComponent(UpdateActivityCancelButton)
                    .addComponent(UpdateActivityAcceptButton)))
        );

        DeleteActivityDialoge.setTitle("Delete an activity");
        DeleteActivityDialoge.setResizable(false);

        DeleteActivitySubjectRadioLabel.setText("Subject :");

        DeleteActivityTasklabel.setText("Task:");

        DeleteActivitySubjectButtonGroup.add(DeleteActivityIndividualRadio);
        DeleteActivityIndividualRadio.setText("Individul");
        DeleteActivityIndividualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityIndividualRadioActionPerformed(evt);
            }
        });

        DeleteActivityTaskCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DeleteActivityAcceptButton.setText("Accept");
        DeleteActivityAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityAcceptButtonActionPerformed(evt);
            }
        });

        DeleteActivitySubjectButtonGroup.add(DeleteActivityGroupRadio);
        DeleteActivityGroupRadio.setText("Group");
        DeleteActivityGroupRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityGroupRadioActionPerformed(evt);
            }
        });

        DeleteActivityFrequencyButtonGroup.add(DeleteActivityOneTimeRadio);
        DeleteActivityOneTimeRadio.setText("One Time");
        DeleteActivityOneTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityOneTimeRadioActionPerformed(evt);
            }
        });

        DeleteActivityFrequencyButtonGroup.add(DeleteActivityRecurrentRadio);
        DeleteActivityRecurrentRadio.setText("Recurrent");
        DeleteActivityRecurrentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityRecurrentRadioActionPerformed(evt);
            }
        });

        DeleteActivityFrequencyRadioLabel.setText("Frequency:");

        DeleteActivityCancelButton.setText("Cancel");

        javax.swing.GroupLayout DeleteActivityDialogeLayout = new javax.swing.GroupLayout(DeleteActivityDialoge.getContentPane());
        DeleteActivityDialoge.getContentPane().setLayout(DeleteActivityDialogeLayout);
        DeleteActivityDialogeLayout.setHorizontalGroup(
            DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                .addGroup(DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(DeleteActivitySubjectRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(DeleteActivityIndividualRadio)
                        .addGap(19, 19, 19)
                        .addComponent(DeleteActivityGroupRadio)
                        .addGap(12, 12, 12)
                        .addGroup(DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(DeleteActivityOneTimeRadio))
                            .addComponent(DeleteActivityFrequencyRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(DeleteActivityRecurrentRadio))
                    .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(DeleteActivityTasklabel)
                        .addGap(84, 84, 84)
                        .addComponent(DeleteActivityTaskCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(DeleteActivityCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(DeleteActivityAcceptButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        DeleteActivityDialogeLayout.setVerticalGroup(
            DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteActivityDialogeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteActivitySubjectRadioLabel)
                    .addComponent(DeleteActivityIndividualRadio)
                    .addComponent(DeleteActivityGroupRadio)
                    .addComponent(DeleteActivityOneTimeRadio)
                    .addComponent(DeleteActivityFrequencyRadioLabel)
                    .addComponent(DeleteActivityRecurrentRadio))
                .addGap(19, 19, 19)
                .addGroup(DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteActivityTasklabel)
                    .addComponent(DeleteActivityTaskCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DeleteActivityDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteActivityCancelButton)
                    .addComponent(DeleteActivityAcceptButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        AddGroupMemberDialoge.setTitle("Add a group member");
        AddGroupMemberDialoge.setResizable(false);

        AddGroupMemberGroupNameLabel.setText("Group: ");

        AddGroupMemberMemberNameLabel.setText("Member:");

        AddGroupMemberGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddGroupMemberGroupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupMemberGroupComboActionPerformed(evt);
            }
        });

        AddGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AddGroupMemberMemberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupMemberMemberComboActionPerformed(evt);
            }
        });

        AddGroupMemberAcceptButton.setText("Accept");
        AddGroupMemberAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupMemberAcceptButtonActionPerformed(evt);
            }
        });

        AddGroupMemberCancelButton.setText("Cancel");
        AddGroupMemberCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupMemberCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddGroupMemberDialogeLayout = new javax.swing.GroupLayout(AddGroupMemberDialoge.getContentPane());
        AddGroupMemberDialoge.getContentPane().setLayout(AddGroupMemberDialogeLayout);
        AddGroupMemberDialogeLayout.setHorizontalGroup(
            AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddGroupMemberDialogeLayout.createSequentialGroup()
                .addGroup(AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(AddGroupMemberGroupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(AddGroupMemberGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(AddGroupMemberMemberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(AddGroupMemberMemberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(AddGroupMemberCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(AddGroupMemberAcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        AddGroupMemberDialogeLayout.setVerticalGroup(
            AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddGroupMemberDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGroupMemberGroupNameLabel)
                    .addComponent(AddGroupMemberGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGroupMemberMemberNameLabel)
                    .addComponent(AddGroupMemberMemberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(AddGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddGroupMemberCancelButton)
                    .addComponent(AddGroupMemberAcceptButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        DeleteGroupMemberDialoge.setTitle("Delete a group member");
        DeleteGroupMemberDialoge.setResizable(false);

        RemoveGroupMemberGroupNameLabel.setText("Group: ");

        RemoveGroupMemberMemberNameLabel.setText("Member:");

        RemoveGroupMemberGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        RemoveGroupMemberGroupCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGroupMemberGroupComboActionPerformed(evt);
            }
        });

        RemoveGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        RemoveGroupMemberMemberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGroupMemberMemberComboActionPerformed(evt);
            }
        });

        RemoveGroupMemberAcceptButton.setText("Accept");
        RemoveGroupMemberAcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGroupMemberAcceptButtonActionPerformed(evt);
            }
        });

        RemoveGroupMemberCancelButton.setText("Cancel");
        RemoveGroupMemberCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveGroupMemberCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteGroupMemberDialogeLayout = new javax.swing.GroupLayout(DeleteGroupMemberDialoge.getContentPane());
        DeleteGroupMemberDialoge.getContentPane().setLayout(DeleteGroupMemberDialogeLayout);
        DeleteGroupMemberDialogeLayout.setHorizontalGroup(
            DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteGroupMemberDialogeLayout.createSequentialGroup()
                .addGroup(DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(RemoveGroupMemberGroupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(RemoveGroupMemberGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(RemoveGroupMemberMemberNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(RemoveGroupMemberMemberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteGroupMemberDialogeLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(RemoveGroupMemberCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(RemoveGroupMemberAcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeleteGroupMemberDialogeLayout.setVerticalGroup(
            DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteGroupMemberDialogeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveGroupMemberGroupNameLabel)
                    .addComponent(RemoveGroupMemberGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveGroupMemberMemberNameLabel)
                    .addComponent(RemoveGroupMemberMemberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(DeleteGroupMemberDialogeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RemoveGroupMemberCancelButton)
                    .addComponent(RemoveGroupMemberAcceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Activity Scheduler");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        SubjectRadioLabel.setText("Subject :");

        ResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ResultsTable.setEnabled(false);
        TableScrollPanel.setViewportView(ResultsTable);

        SubjectRadioGroup.add(individualRadio);
        individualRadio.setSelected(true);
        individualRadio.setText("Individul");
        individualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                individualRadioActionPerformed(evt);
            }
        });

        SubjectRadioGroup.add(GroupRadio);
        GroupRadio.setText("Group");
        GroupRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupRadioActionPerformed(evt);
            }
        });

        FrequencyRadioGroup.add(OneTimeRadio);
        OneTimeRadio.setSelected(true);
        OneTimeRadio.setText("One Time");
        OneTimeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OneTimeRadioActionPerformed(evt);
            }
        });

        FrequencyRadioGroup.add(RecurrentRadio);
        RecurrentRadio.setText("Recurrent");
        RecurrentRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecurrentRadioActionPerformed(evt);
            }
        });

        FrequencyRadioLabel.setText("Frequency:");

        EditMembersMenu.setText("Edit Members");

        AddMemberOption.setText("Add a member");
        AddMemberOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberOptionActionPerformed(evt);
            }
        });
        EditMembersMenu.add(AddMemberOption);

        DeleteMemberOption.setText("Delete a member");
        DeleteMemberOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMemberOptionActionPerformed(evt);
            }
        });
        EditMembersMenu.add(DeleteMemberOption);

        UpdateMemberOption.setText("Update a member");
        UpdateMemberOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMemberOptionActionPerformed(evt);
            }
        });
        EditMembersMenu.add(UpdateMemberOption);

        SchedulerMenuBar.add(EditMembersMenu);

        EditGroupsMenu.setText("Edit Groups");

        AddGroupOption.setText("Add a group");
        AddGroupOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupOptionActionPerformed(evt);
            }
        });
        EditGroupsMenu.add(AddGroupOption);

        DeleteGroupOption.setText("Delete a group");
        DeleteGroupOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupOptionActionPerformed(evt);
            }
        });
        EditGroupsMenu.add(DeleteGroupOption);

        UpdateGroupOption.setText("Update a group");
        UpdateGroupOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGroupOptionActionPerformed(evt);
            }
        });
        EditGroupsMenu.add(UpdateGroupOption);

        AddGroupMemberOption.setText("Add a member to a group");
        AddGroupMemberOption.setToolTipText("");
        AddGroupMemberOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddGroupMemberOptionActionPerformed(evt);
            }
        });
        EditGroupsMenu.add(AddGroupMemberOption);

        DeleteGroupMemberOption.setText("Remove a menber froum a group");
        DeleteGroupMemberOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteGroupMemberOptionActionPerformed(evt);
            }
        });
        EditGroupsMenu.add(DeleteGroupMemberOption);

        SchedulerMenuBar.add(EditGroupsMenu);

        EditActivitiesMenu.setText("Edit Activities");

        AddActivityOption.setText("Add an activity");
        AddActivityOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActivityOptionActionPerformed(evt);
            }
        });
        EditActivitiesMenu.add(AddActivityOption);

        DeleteActivityOption.setText("Delete an activity");
        DeleteActivityOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActivityOptionActionPerformed(evt);
            }
        });
        EditActivitiesMenu.add(DeleteActivityOption);

        UpdateActivityOption.setText("Update an activity");
        UpdateActivityOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActivityOptionActionPerformed(evt);
            }
        });
        EditActivitiesMenu.add(UpdateActivityOption);

        SchedulerMenuBar.add(EditActivitiesMenu);

        setJMenuBar(SchedulerMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubjectRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(individualRadio)
                        .addGap(39, 39, 39)
                        .addComponent(GroupRadio)
                        .addGap(99, 99, 99)
                        .addComponent(FrequencyRadioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OneTimeRadio)
                        .addGap(39, 39, 39)
                        .addComponent(RecurrentRadio)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectRadioLabel)
                    .addComponent(individualRadio)
                    .addComponent(GroupRadio)
                    .addComponent(FrequencyRadioLabel)
                    .addComponent(OneTimeRadio)
                    .addComponent(RecurrentRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddMemberOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberOptionActionPerformed
        AddUserNameInput.setText("");
        AddUserAcceptButton.setEnabled(false);
        AddUserDialoge.setVisible(true);
    }//GEN-LAST:event_AddMemberOptionActionPerformed

    private void UpdateMemberOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMemberOptionActionPerformed
        String[] MemberNames = new String[members.size()];
        for(int i = 0; i < members.size(); i++){
            MemberNames[i] = members.get(i).getName();
        }
        UpdateMembersNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
        UpdateMembersNameInput.setText("");
        UpdateMembersNameInput.setEnabled(false);
        UpdateMembersAcceptButton.setEnabled(false);
        UpdateUserDialoge.setVisible(true);
    }//GEN-LAST:event_UpdateMemberOptionActionPerformed

    private void AddGroupOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupOptionActionPerformed
        AddGroupsNameInput.setText("");
        AddGroupsAcceptButton.setEnabled(false);
        AddGroupDialoge.setVisible(true);
    }//GEN-LAST:event_AddGroupOptionActionPerformed

    private void AddUserCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserCancelButtonActionPerformed
        AddUserDialoge.setVisible(false);
    }//GEN-LAST:event_AddUserCancelButtonActionPerformed

    private void individualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_individualRadioActionPerformed
        updateTable();
    }//GEN-LAST:event_individualRadioActionPerformed

    private void GroupRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupRadioActionPerformed
        updateTable();
    }//GEN-LAST:event_GroupRadioActionPerformed

    private void OneTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OneTimeRadioActionPerformed
        updateTable();
    }//GEN-LAST:event_OneTimeRadioActionPerformed

    private void RecurrentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecurrentRadioActionPerformed
        updateTable();
    }//GEN-LAST:event_RecurrentRadioActionPerformed

    private void AddUserNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserNameInputActionPerformed
        
    }//GEN-LAST:event_AddUserNameInputActionPerformed

    private void AddUserAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserAcceptButtonActionPerformed
        data_manager.add_member(AddUserNameInput.getText());
        AddUserDialoge.setVisible(false);
        members = data_manager.get_members();
    }//GEN-LAST:event_AddUserAcceptButtonActionPerformed

    private void AddUserNameInputChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddUserNameInputChanged
        if(AddUserNameInput.getText().isBlank()){
            AddUserAcceptButton.setEnabled(false);
        }else{
            AddUserAcceptButton.setEnabled(true);
        }
    }//GEN-LAST:event_AddUserNameInputChanged

    private void DeleteMemberOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMemberOptionActionPerformed
        String[] MemberNames = new String[members.size()];
        for(int i = 0; i < members.size(); i++){
            MemberNames[i] = members.get(i).getName();
        }
        DeleteMembersNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
        DeleteMembersAcceptButton.setEnabled(false);
        DeleteUserDialoge.setVisible(true);
    }//GEN-LAST:event_DeleteMemberOptionActionPerformed

    private void UpdateMembersNamesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMembersNamesComboActionPerformed
        Member selected_member = members.get(UpdateMembersNamesCombo.getSelectedIndex());
        UpdateMembersNameInput.setText(selected_member.getName());
        UpdateMembersNameInput.setEnabled(true);
        UpdateMembersAcceptButton.setEnabled(true);
    }//GEN-LAST:event_UpdateMembersNamesComboActionPerformed

    private void UpdateUserNameInputChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateUserNameInputChanged
        if(UpdateMembersNameInput.getText().isBlank()){
            UpdateMembersAcceptButton.setEnabled(false);
        }else{
            UpdateMembersAcceptButton.setEnabled(true);
        }
    }//GEN-LAST:event_UpdateUserNameInputChanged

    private void UpdateMembersAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMembersAcceptButtonActionPerformed
        Member selected_member = members.get(UpdateMembersNamesCombo.getSelectedIndex());
        data_manager.edit_member(selected_member.getId(), UpdateMembersNameInput.getText());
        updateFields();
        updateTable();
        UpdateUserDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateMembersAcceptButtonActionPerformed

    private void DeleteMembersNamesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMembersNamesComboActionPerformed
        DeleteMembersAcceptButton.setEnabled(true);
    }//GEN-LAST:event_DeleteMembersNamesComboActionPerformed

    private void DeleteMembersAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMembersAcceptButtonActionPerformed
        Member selected_member = members.get(DeleteMembersNamesCombo.getSelectedIndex());
        data_manager.delete_member(selected_member.getId());
        updateFields();
        updateTable();
        DeleteUserDialoge.setVisible(false);
    }//GEN-LAST:event_DeleteMembersAcceptButtonActionPerformed

    private void UpdateMembersCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMembersCancelButtonActionPerformed
        UpdateUserDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateMembersCancelButtonActionPerformed

    private void DeleteMembersCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMembersCancelButtonActionPerformed
        DeleteUserDialoge.setVisible(false);
    }//GEN-LAST:event_DeleteMembersCancelButtonActionPerformed

    private void AddGroupsCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupsCancelButtonActionPerformed
        AddGroupDialoge.setVisible(false);
    }//GEN-LAST:event_AddGroupsCancelButtonActionPerformed

    private void AddGroupsNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupsNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddGroupsNameInputActionPerformed

    private void AddGroupsNameInputChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddGroupsNameInputChanged
        if(AddGroupsNameInput.getText().isBlank()){
            AddGroupsAcceptButton.setEnabled(false);
        }else{
            AddGroupsAcceptButton.setEnabled(true);
        }
    }//GEN-LAST:event_AddGroupsNameInputChanged

    private void AddGroupsAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupsAcceptButtonActionPerformed
        data_manager.add_group(AddGroupsNameInput.getText());
        AddGroupDialoge.setVisible(false);
        member_groups = data_manager.get_member_groups();
    }//GEN-LAST:event_AddGroupsAcceptButtonActionPerformed

    private void UpdateGroupsNamesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGroupsNamesComboActionPerformed
        MemberGroup selected_member_group = member_groups.get(UpdateGroupsNamesCombo.getSelectedIndex());
        UpdateGroupsNameInput.setText(selected_member_group.getName());
        UpdateGroupsNameInput.setEnabled(true);
        UpdateGroupsAcceptButton.setEnabled(true);
    }//GEN-LAST:event_UpdateGroupsNamesComboActionPerformed

    private void UpdateGroupsNameInputUpdateUserNameInputChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateGroupsNameInputUpdateUserNameInputChanged
        if(UpdateGroupsNameInput.getText().isBlank()){
            UpdateGroupsAcceptButton.setEnabled(false);
        }else{
            UpdateGroupsAcceptButton.setEnabled(true);
        }
    }//GEN-LAST:event_UpdateGroupsNameInputUpdateUserNameInputChanged

    private void UpdateGroupsCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGroupsCancelButtonActionPerformed
        UpdateGroupDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateGroupsCancelButtonActionPerformed

    private void UpdateGroupsAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGroupsAcceptButtonActionPerformed
        MemberGroup selected_group = member_groups.get(UpdateGroupsNamesCombo.getSelectedIndex());
        data_manager.edit_group(selected_group.getId(), UpdateGroupsNameInput.getText());
        updateFields();
        updateTable();
        UpdateGroupDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateGroupsAcceptButtonActionPerformed

    private void DeleteGroupsNamesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupsNamesComboActionPerformed
        DeleteGroupsAcceptButton.setEnabled(true);
    }//GEN-LAST:event_DeleteGroupsNamesComboActionPerformed

    private void DeleteGroupsCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupsCancelButtonActionPerformed
        DeleteGroupDialoge.setVisible(false);
    }//GEN-LAST:event_DeleteGroupsCancelButtonActionPerformed

    private void DeleteGroupsAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupsAcceptButtonActionPerformed
        MemberGroup selected_group = member_groups.get(DeleteGroupsNamesCombo.getSelectedIndex());
        data_manager.delete_group(selected_group.getId());
        updateFields();
        updateTable();
        DeleteGroupDialoge.setVisible(false);
    }//GEN-LAST:event_DeleteGroupsAcceptButtonActionPerformed

    private void DeleteGroupOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupOptionActionPerformed
        String[] MemberFroupNames = new String[member_groups.size()];
        for(int i = 0; i < member_groups.size(); i++){
            MemberFroupNames[i] = member_groups.get(i).getName();
        }
        DeleteGroupsNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberFroupNames));
        DeleteGroupsAcceptButton.setEnabled(false);
        DeleteGroupDialoge.setVisible(true);
    }//GEN-LAST:event_DeleteGroupOptionActionPerformed

    private void UpdateGroupOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGroupOptionActionPerformed
        String[] MemberGroupNames = new String[member_groups.size()];
        for(int i = 0; i < member_groups.size(); i++){
            MemberGroupNames[i] = member_groups.get(i).getName();
        }
        UpdateGroupsNamesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
        UpdateGroupsNameInput.setText("");
        UpdateGroupsNameInput.setEnabled(false);
        UpdateGroupsAcceptButton.setEnabled(false);
        UpdateGroupDialoge.setVisible(true);
    }//GEN-LAST:event_UpdateGroupOptionActionPerformed

    private void UpdateMembersNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMembersNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateMembersNameInputActionPerformed

    private void AddGroupMemberOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupMemberOptionActionPerformed
        AddGroupMemberAcceptButton.setEnabled(false);
        AddGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        AddGroupMemberMemberCombo.setEnabled(false);
        String[] MemberGroupNames = new String[member_groups.size()];
        for(int i = 0; i < member_groups.size(); i++){
            MemberGroupNames[i] = member_groups.get(i).getName();
        }
        AddGroupMemberGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
        AddGroupMemberDialoge.setVisible(true);
    }//GEN-LAST:event_AddGroupMemberOptionActionPerformed

    private void AddGroupMemberGroupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupMemberGroupComboActionPerformed
        MemberGroup selected_group = member_groups.get(AddGroupMemberGroupCombo.getSelectedIndex());
        ArrayList<Member> not_added = new ArrayList();
        for(Member member: members){
            boolean in = false;
            for(Member member_in: selected_group.getMembers()){
                if (member_in.getId()==member.getId()){
                    in = true;
                    break;
                }
            }
            if (!in) not_added.add(member);
        }
        String[] MemberNames = new String[not_added.size()];
        for(int i = 0; i < not_added.size(); i++){
            MemberNames[i] = not_added.get(i).getName();
        }
        AddGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
        AddGroupMemberMemberCombo.setEnabled(true);
    }//GEN-LAST:event_AddGroupMemberGroupComboActionPerformed

    private void AddGroupMemberMemberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupMemberMemberComboActionPerformed
        AddGroupMemberAcceptButton.setEnabled(true);
    }//GEN-LAST:event_AddGroupMemberMemberComboActionPerformed

    private void AddGroupMemberAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupMemberAcceptButtonActionPerformed
        MemberGroup selected_group = member_groups.get(AddGroupMemberGroupCombo.getSelectedIndex());
        ArrayList<Member> not_added = new ArrayList();
        for(Member member: members){
            boolean in = false;
            for(Member member_in: selected_group.getMembers()){
                if (member_in.getId()==member.getId()){
                    in = true;
                    break;
                }
            }
            if (!in) not_added.add(member);
        }
        Member selected_member = not_added.get(AddGroupMemberMemberCombo.getSelectedIndex());
        data_manager.add_group_member(selected_member.getId(), selected_group.getId());
        updateFields();
        AddGroupMemberDialoge.setVisible(false);
    }//GEN-LAST:event_AddGroupMemberAcceptButtonActionPerformed

    private void AddGroupMemberCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddGroupMemberCancelButtonActionPerformed
        AddGroupMemberDialoge.setVisible(false);
    }//GEN-LAST:event_AddGroupMemberCancelButtonActionPerformed

    private void RemoveGroupMemberGroupComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGroupMemberGroupComboActionPerformed
        MemberGroup selected_group = member_groups.get(RemoveGroupMemberGroupCombo.getSelectedIndex());
        String[] MemberNames = new String[selected_group.getMembers().size()];
        for(int i = 0; i < selected_group.getMembers().size(); i++){
            MemberNames[i] = selected_group.getMembers().get(i).getName();
        }
        RemoveGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
        RemoveGroupMemberMemberCombo.setEnabled(true);
    }//GEN-LAST:event_RemoveGroupMemberGroupComboActionPerformed

    private void RemoveGroupMemberMemberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGroupMemberMemberComboActionPerformed
        RemoveGroupMemberAcceptButton.setEnabled(true);
    }//GEN-LAST:event_RemoveGroupMemberMemberComboActionPerformed

    private void RemoveGroupMemberAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGroupMemberAcceptButtonActionPerformed
        MemberGroup selected_group = member_groups.get(RemoveGroupMemberGroupCombo.getSelectedIndex());
        Member selected_member = selected_group.getMembers().get(RemoveGroupMemberMemberCombo.getSelectedIndex());
        data_manager.remove_group_member(selected_member.getId(), selected_group.getId());
        updateFields();
        DeleteGroupMemberDialoge.setVisible(false);
    }//GEN-LAST:event_RemoveGroupMemberAcceptButtonActionPerformed

    private void RemoveGroupMemberCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveGroupMemberCancelButtonActionPerformed
        DeleteGroupMemberDialoge.setVisible(false);
    }//GEN-LAST:event_RemoveGroupMemberCancelButtonActionPerformed

    private void DeleteGroupMemberOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteGroupMemberOptionActionPerformed
        RemoveGroupMemberAcceptButton.setEnabled(false);
        RemoveGroupMemberMemberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        RemoveGroupMemberMemberCombo.setEnabled(false);
        String[] MemberGroupNames = new String[member_groups.size()];
        for(int i = 0; i < member_groups.size(); i++){
            MemberGroupNames[i] = member_groups.get(i).getName();
        }
        RemoveGroupMemberGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
        DeleteGroupMemberDialoge.setVisible(true);
    }//GEN-LAST:event_DeleteGroupMemberOptionActionPerformed

    private void AddActivityIndividualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityIndividualRadioActionPerformed
        setAddActivity();
    }//GEN-LAST:event_AddActivityIndividualRadioActionPerformed

    private void AddActivityGroupRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityGroupRadioActionPerformed
        setAddActivity();
    }//GEN-LAST:event_AddActivityGroupRadioActionPerformed

    private void AddActivityOneTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityOneTimeRadioActionPerformed
        setAddActivity();
    }//GEN-LAST:event_AddActivityOneTimeRadioActionPerformed

    private void AddActivityRecurrentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityRecurrentRadioActionPerformed
        setAddActivity();
    }//GEN-LAST:event_AddActivityRecurrentRadioActionPerformed

    private void AddActivityOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityOptionActionPerformed
        AddActivityIndividualRadio.setSelected(true);
        AddActivityOneTimeRadio.setSelected(true);
        setAddActivity();
        AddActivityDialoge.setVisible(true);
    }//GEN-LAST:event_AddActivityOptionActionPerformed

    private void UpdateActivityindividualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityindividualRadioActionPerformed
        setUpdateActivity();
    }//GEN-LAST:event_UpdateActivityindividualRadioActionPerformed

    private void UpdateActivityGroupRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityGroupRadioActionPerformed
        setUpdateActivity();
    }//GEN-LAST:event_UpdateActivityGroupRadioActionPerformed

    private void UpdateActivityOneTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityOneTimeRadioActionPerformed
        setUpdateActivity();
    }//GEN-LAST:event_UpdateActivityOneTimeRadioActionPerformed

    private void UpdateActivityRecurrentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityRecurrentRadioActionPerformed
        setUpdateActivity();
    }//GEN-LAST:event_UpdateActivityRecurrentRadioActionPerformed

    private void DeleteActivityIndividualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityIndividualRadioActionPerformed
        setDeleteActivity();
    }//GEN-LAST:event_DeleteActivityIndividualRadioActionPerformed

    private void DeleteActivityGroupRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityGroupRadioActionPerformed
        setDeleteActivity();
    }//GEN-LAST:event_DeleteActivityGroupRadioActionPerformed

    private void DeleteActivityOneTimeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityOneTimeRadioActionPerformed
        setDeleteActivity();
    }//GEN-LAST:event_DeleteActivityOneTimeRadioActionPerformed

    private void DeleteActivityRecurrentRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityRecurrentRadioActionPerformed
        setDeleteActivity();
    }//GEN-LAST:event_DeleteActivityRecurrentRadioActionPerformed

    private void UpdateActivityOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityOptionActionPerformed
        UpdateActivityindividualRadio.setSelected(true);
        UpdateActivityOneTimeRadio.setSelected(true);
        setUpdateActivity();
        UpdateActivityDialoge.setVisible(true);
    }//GEN-LAST:event_UpdateActivityOptionActionPerformed

    private void DeleteActivityOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityOptionActionPerformed
        DeleteActivityIndividualRadio.setSelected(true);
        DeleteActivityOneTimeRadio.setSelected(true);
        setDeleteActivity();
        DeleteActivityDialoge.setVisible(true);
    }//GEN-LAST:event_DeleteActivityOptionActionPerformed

    private void UpdateActivityTaskComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityTaskComboActionPerformed
        UpdateActivityNameInput.setEnabled(true);
        UpdateActivityDescriptionInput.setEnabled(true);
        UpdateActivityMemberCompo.setEnabled(true);
        UpdateActivityStartDateInput.setEnabled(true);
        UpdateActivityDurationInput.setEnabled(true);
        UpdateActivityCompletedCheckBox.setEnabled(true);
        UpdateActivityAcceptButton.setEnabled(true);
        
        if(UpdateActivityindividualRadio.isSelected() && UpdateActivityOneTimeRadio.isSelected()){
            IndividualOneTime selectedTask = individual_one_time.get(UpdateActivityTaskCombo.getSelectedIndex());
            int member_index = 0;
            
            String[] MemberNames = new String[members.size()];
            for(int i = 0; i < members.size(); i++){
                MemberNames[i] = members.get(i).getName();
                if(members.get(i).getId()==selectedTask.getId()){
                    member_index = i;
                    System.out.println(i+" "+members.get(i).getId()+" "+selectedTask.getId());
                }
            }
            
            UpdateActivityNameInput.setText(selectedTask.getName());
            UpdateActivityDescriptionInput.setText(selectedTask.getDiscription());
            UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
            UpdateActivityMemberCompo.setSelectedIndex(member_index);
            UpdateActivityStartDateInput.setText(selectedTask.getStartdate().toString());
            UpdateActivityDurationInput.setValue(selectedTask.getDuration());
            UpdateActivityCompletedCheckBox.setSelected(selectedTask.isCompleted());
        }else if(UpdateActivityindividualRadio.isSelected()){
            UpdateActivityEndDateInput.setEnabled(true);
            UpdateActivityRepeatEveryCombo.setEnabled(true);
            IndividualRecurrent selectedTask = individual_recurrent.get(UpdateActivityTaskCombo.getSelectedIndex());
            int member_index = 0;
            
            String[] MemberNames = new String[members.size()];
            for(int i = 0; i < members.size(); i++){
                MemberNames[i] = members.get(i).getName();
                if(members.get(i).getId()==selectedTask.getId()){
                    member_index = i;
                }
            }
            
            UpdateActivityNameInput.setText(selectedTask.getName());
            UpdateActivityDescriptionInput.setText(selectedTask.getDiscription());
            UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberNames));
            UpdateActivityMemberCompo.setSelectedIndex(member_index);
            UpdateActivityStartDateInput.setText(selectedTask.getStartdate().toString());
            UpdateActivityEndDateInput.setText(selectedTask.getEnd_date().toString());
            UpdateActivityDurationInput.setValue(selectedTask.getDuration());
            UpdateActivityRepeatEveryCombo.setSelectedItem(selectedTask.getRepeat_every());
            UpdateActivityCompletedCheckBox.setSelected(selectedTask.isCompleted());
        }else if(UpdateActivityOneTimeRadio.isSelected()){
            GroupOneTime selectedTask = group_one_time.get(UpdateActivityTaskCombo.getSelectedIndex());
            int group_index = 0;
            
            String[] MemberGroupNames = new String[member_groups.size()];
            for(int i = 0; i < member_groups.size(); i++){
                MemberGroupNames[i] = member_groups.get(i).getName();
                if(member_groups.get(i).getId()==selectedTask.getId()){
                    group_index = i;
                }
            }
            
            UpdateActivityNameInput.setText(selectedTask.getName());
            UpdateActivityDescriptionInput.setText(selectedTask.getDiscription());
            UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
            UpdateActivityMemberCompo.setSelectedIndex(group_index);
            UpdateActivityStartDateInput.setText(selectedTask.getStartdate().toString());
            UpdateActivityDurationInput.setValue(selectedTask.getDuration());
            UpdateActivityCompletedCheckBox.setSelected(selectedTask.isCompleted());
        }else{
            UpdateActivityEndDateInput.setEnabled(true);
            UpdateActivityRepeatEveryCombo.setEnabled(true);
            GroupRecurrent selectedTask = group_recurrent.get(UpdateActivityTaskCombo.getSelectedIndex());
            int group_index = 0;
            
            String[] MemberGroupNames = new String[member_groups.size()];
            for(int i = 0; i < member_groups.size(); i++){
                MemberGroupNames[i] = member_groups.get(i).getName();
                if(member_groups.get(i).getId()==selectedTask.getId()){
                    group_index = i;
                }
            }
            
            UpdateActivityNameInput.setText(selectedTask.getName());
            UpdateActivityDescriptionInput.setText(selectedTask.getDiscription());
            UpdateActivityMemberCompo.setModel(new javax.swing.DefaultComboBoxModel<>(MemberGroupNames));
            UpdateActivityMemberCompo.setSelectedIndex(group_index);
            UpdateActivityStartDateInput.setText(selectedTask.getStartdate().toString());
            UpdateActivityEndDateInput.setText(selectedTask.getEnd_date().toString());
            UpdateActivityDurationInput.setValue(selectedTask.getDuration());
            UpdateActivityRepeatEveryCombo.setSelectedItem(selectedTask.getRepeat_every());
            UpdateActivityCompletedCheckBox.setSelected(selectedTask.isCompleted());
        }
    }//GEN-LAST:event_UpdateActivityTaskComboActionPerformed

    private void UpdateActivityAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityAcceptButtonActionPerformed
        if(UpdateActivityindividualRadio.isSelected() && UpdateActivityOneTimeRadio.isSelected()){
            IndividualOneTime selectedTask = individual_one_time.get(UpdateActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            String name = UpdateActivityNameInput.getText();
            String desc = UpdateActivityDescriptionInput.getText();;
            String member_id = members.get(UpdateActivityMemberCompo.getSelectedIndex()).getId() + "";
            String start_date = UpdateActivityStartDateInput.getText();
            String duration = UpdateActivityDurationInput.getValue()+"";
            String completed = UpdateActivityCompletedCheckBox.isSelected()+"";
            data_manager.edit_individual_one_time(id, name, desc, member_id, start_date, duration, completed);
        }else if(UpdateActivityindividualRadio.isSelected()){
            IndividualRecurrent selectedTask = individual_recurrent.get(UpdateActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            String name = UpdateActivityNameInput.getText();
            String desc = UpdateActivityDescriptionInput.getText();;
            String member_id = members.get(UpdateActivityMemberCompo.getSelectedIndex()).getId() + "";
            String start_date = UpdateActivityStartDateInput.getText();
            String duration = UpdateActivityDurationInput.getValue()+"";
            String end_date = UpdateActivityEndDateInput.getText();
            String repeat_every = repeat_every_array[UpdateActivityRepeatEveryCombo.getSelectedIndex()];
            String completed = UpdateActivityCompletedCheckBox.isSelected()+"";
            data_manager.edit_individual_recurrent(id, name, desc, member_id, start_date, duration, end_date, repeat_every, completed);
        }else if(UpdateActivityOneTimeRadio.isSelected()){
            GroupOneTime selectedTask = group_one_time.get(UpdateActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            String name = UpdateActivityNameInput.getText();
            String desc = UpdateActivityDescriptionInput.getText();
            String group_id = member_groups.get(UpdateActivityMemberCompo.getSelectedIndex()).getId() + "";
            String start_date = UpdateActivityStartDateInput.getText();
            String duration = UpdateActivityDurationInput.getValue()+"";
            String completed = UpdateActivityCompletedCheckBox.isSelected()+"";
            data_manager.edit_group_one_time(id, name, desc, group_id, start_date, duration, completed);
        }else{
            GroupRecurrent selectedTask = group_recurrent.get(UpdateActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            String name = UpdateActivityNameInput.getText();
            String desc = UpdateActivityDescriptionInput.getText();;
            String group_id = member_groups.get(UpdateActivityMemberCompo.getSelectedIndex()).getId() + "";
            String start_date = UpdateActivityStartDateInput.getText();
            String duration = UpdateActivityDurationInput.getValue()+"";
            String end_date = UpdateActivityEndDateInput.getText();
            String repeat_every = repeat_every_array[UpdateActivityRepeatEveryCombo.getSelectedIndex()];
            String completed = UpdateActivityCompletedCheckBox.isSelected()+"";
            data_manager.edit_group_recurrent(id, name, desc, group_id, start_date, duration, end_date, repeat_every, completed);
        }
        updateFields();
        updateTable();
        UpdateActivityDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateActivityAcceptButtonActionPerformed

    private void AddActivityAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityAcceptButtonActionPerformed
        if(AddActivityIndividualRadio.isSelected() && AddActivityOneTimeRadio.isSelected()){
            String name = AddActivityNameInput.getText();
            String desc = AddActivityDescriptionInput.getText();;
            String member_id = members.get(AddActivityMemberInput.getSelectedIndex()).getId() + "";
            String start_date = AddActivityStartDateInput.getText();
            String duration = AddActivityDurationInput.getValue()+"";
            data_manager.add_individual_one_time(name, desc, member_id, start_date, duration);
        }else if(AddActivityIndividualRadio.isSelected()){
            String name = AddActivityNameInput.getText();
            String desc = AddActivityDescriptionInput.getText();;
            String member_id = members.get(AddActivityMemberInput.getSelectedIndex()).getId() + "";
            String start_date = AddActivityStartDateInput.getText();
            String duration = AddActivityDurationInput.getValue()+"";
            String end_date = AddActivityEndDateInput.getText();
            String repeat_every = repeat_every_array[AddActivityRepeatEveryInput.getSelectedIndex()];
            data_manager.add_individual_recurrent(name, desc, member_id, start_date, duration, end_date, repeat_every);
        }else if(AddActivityOneTimeRadio.isSelected()){
            String name = AddActivityNameInput.getText();
            String desc = AddActivityDescriptionInput.getText();;
            String group_id = member_groups.get(AddActivityMemberInput.getSelectedIndex()).getId() + "";
            String start_date = AddActivityStartDateInput.getText();
            String duration = AddActivityDurationInput.getValue()+"";
            data_manager.add_group_one_time(name, desc, group_id, start_date, duration);
        }else{
            String name = AddActivityNameInput.getText();
            String desc = AddActivityDescriptionInput.getText();;
            String group_id = member_groups.get(AddActivityMemberInput.getSelectedIndex()).getId() + "";
            String start_date = AddActivityStartDateInput.getText();
            String duration = AddActivityDurationInput.getValue()+"";
            String end_date = AddActivityEndDateInput.getText();
            String repeat_every = repeat_every_array[AddActivityRepeatEveryInput.getSelectedIndex()];
            data_manager.add_group_recurrent(name, desc, group_id, start_date, duration, end_date, repeat_every);
        }
        
        updateFields();
        updateTable();
        AddActivityDialoge.setVisible(false);
    }//GEN-LAST:event_AddActivityAcceptButtonActionPerformed

    private void AddActivityCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActivityCancelButtonActionPerformed
        AddActivityDialoge.setVisible(false);
    }//GEN-LAST:event_AddActivityCancelButtonActionPerformed

    private void UpdateActivityCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActivityCancelButtonActionPerformed
        UpdateActivityDialoge.setVisible(false);
    }//GEN-LAST:event_UpdateActivityCancelButtonActionPerformed

    private void DeleteActivityAcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActivityAcceptButtonActionPerformed
        if(DeleteActivityIndividualRadio.isSelected() && DeleteActivityOneTimeRadio.isSelected()){
            IndividualOneTime selectedTask = individual_one_time.get(DeleteActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            data_manager.delete_individual_one_time(id);
        }else if(DeleteActivityIndividualRadio.isSelected()){
            IndividualRecurrent selectedTask = individual_recurrent.get(DeleteActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            data_manager.delete_individual_recurrent(id);
        }else if(DeleteActivityOneTimeRadio.isSelected()){
            GroupOneTime selectedTask = group_one_time.get(DeleteActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            data_manager.delete_group_one_time(id);
        }else{
            GroupRecurrent selectedTask = group_recurrent.get(DeleteActivityTaskCombo.getSelectedIndex());
            int id = selectedTask.getId();
            data_manager.delete_group_recurrent(id);
        }
        updateFields();
        updateTable();
        DeleteActivityDialoge.setVisible(false);
    }//GEN-LAST:event_DeleteActivityAcceptButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddActivityAcceptButton;
    private javax.swing.JButton AddActivityCancelButton;
    private javax.swing.JTextArea AddActivityDescriptionInput;
    private javax.swing.JLabel AddActivityDescriptionLabel;
    private javax.swing.JDialog AddActivityDialoge;
    private javax.swing.JSpinner AddActivityDurationInput;
    private javax.swing.JLabel AddActivityDurationLabel;
    private javax.swing.JFormattedTextField AddActivityEndDateInput;
    private javax.swing.JLabel AddActivityEndDateLabel;
    private javax.swing.ButtonGroup AddActivityFrequencyButtonGroup;
    private javax.swing.JLabel AddActivityFrequencyRadioLabel;
    private javax.swing.JRadioButton AddActivityGroupRadio;
    private javax.swing.JRadioButton AddActivityIndividualRadio;
    private javax.swing.JComboBox<String> AddActivityMemberInput;
    private javax.swing.JLabel AddActivityMemberLabel;
    private javax.swing.JTextField AddActivityNameInput;
    private javax.swing.JLabel AddActivityNameLabel;
    private javax.swing.JRadioButton AddActivityOneTimeRadio;
    private javax.swing.JMenuItem AddActivityOption;
    private javax.swing.JRadioButton AddActivityRecurrentRadio;
    private javax.swing.JComboBox<String> AddActivityRepeatEveryInput;
    private javax.swing.JLabel AddActivityRepeatEveryLabel;
    private javax.swing.JFormattedTextField AddActivityStartDateInput;
    private javax.swing.JLabel AddActivityStartDateLabel;
    private javax.swing.ButtonGroup AddActivitySubjectButtonGroup;
    private javax.swing.JLabel AddActivitySubjectRadioLabel;
    private javax.swing.JDialog AddGroupDialoge;
    private javax.swing.JButton AddGroupMemberAcceptButton;
    private javax.swing.JButton AddGroupMemberCancelButton;
    private javax.swing.JDialog AddGroupMemberDialoge;
    private javax.swing.JComboBox<String> AddGroupMemberGroupCombo;
    private javax.swing.JLabel AddGroupMemberGroupNameLabel;
    private javax.swing.JComboBox<String> AddGroupMemberMemberCombo;
    private javax.swing.JLabel AddGroupMemberMemberNameLabel;
    private javax.swing.JMenuItem AddGroupMemberOption;
    private javax.swing.JMenuItem AddGroupOption;
    private javax.swing.JButton AddGroupsAcceptButton;
    private javax.swing.JButton AddGroupsCancelButton;
    private javax.swing.JTextField AddGroupsNameInput;
    private javax.swing.JLabel AddGroupsNameLabel;
    private javax.swing.JMenuItem AddMemberOption;
    private javax.swing.JButton AddUserAcceptButton;
    private javax.swing.JButton AddUserCancelButton;
    private javax.swing.JDialog AddUserDialoge;
    private javax.swing.JTextField AddUserNameInput;
    private javax.swing.JLabel AddUserNameLabel;
    private javax.swing.JButton DeleteActivityAcceptButton;
    private javax.swing.JButton DeleteActivityCancelButton;
    private javax.swing.JDialog DeleteActivityDialoge;
    private javax.swing.ButtonGroup DeleteActivityFrequencyButtonGroup;
    private javax.swing.JLabel DeleteActivityFrequencyRadioLabel;
    private javax.swing.JRadioButton DeleteActivityGroupRadio;
    private javax.swing.JRadioButton DeleteActivityIndividualRadio;
    private javax.swing.JRadioButton DeleteActivityOneTimeRadio;
    private javax.swing.JMenuItem DeleteActivityOption;
    private javax.swing.JRadioButton DeleteActivityRecurrentRadio;
    private javax.swing.ButtonGroup DeleteActivitySubjectButtonGroup;
    private javax.swing.JLabel DeleteActivitySubjectRadioLabel;
    private javax.swing.JComboBox<String> DeleteActivityTaskCombo;
    private javax.swing.JLabel DeleteActivityTasklabel;
    private javax.swing.JDialog DeleteGroupDialoge;
    private javax.swing.JDialog DeleteGroupMemberDialoge;
    private javax.swing.JMenuItem DeleteGroupMemberOption;
    private javax.swing.JMenuItem DeleteGroupOption;
    private javax.swing.JButton DeleteGroupsAcceptButton;
    private javax.swing.JButton DeleteGroupsCancelButton;
    private javax.swing.JComboBox<String> DeleteGroupsNamesCombo;
    private javax.swing.JLabel DeleteGroupsNamesLabel;
    private javax.swing.JMenuItem DeleteMemberOption;
    private javax.swing.JButton DeleteMembersAcceptButton;
    private javax.swing.JButton DeleteMembersCancelButton;
    private javax.swing.JComboBox<String> DeleteMembersNamesCombo;
    private javax.swing.JLabel DeleteMembersNamesLabel;
    private javax.swing.JDialog DeleteUserDialoge;
    private javax.swing.JMenu EditActivitiesMenu;
    private javax.swing.JMenu EditGroupsMenu;
    private javax.swing.JMenu EditMembersMenu;
    private javax.swing.ButtonGroup FrequencyRadioGroup;
    private javax.swing.JLabel FrequencyRadioLabel;
    private javax.swing.JRadioButton GroupRadio;
    private javax.swing.JRadioButton OneTimeRadio;
    private javax.swing.JRadioButton RecurrentRadio;
    private javax.swing.JButton RemoveGroupMemberAcceptButton;
    private javax.swing.JButton RemoveGroupMemberCancelButton;
    private javax.swing.JComboBox<String> RemoveGroupMemberGroupCombo;
    private javax.swing.JLabel RemoveGroupMemberGroupNameLabel;
    private javax.swing.JComboBox<String> RemoveGroupMemberMemberCombo;
    private javax.swing.JLabel RemoveGroupMemberMemberNameLabel;
    private javax.swing.JTable ResultsTable;
    private javax.swing.JMenuBar SchedulerMenuBar;
    private javax.swing.ButtonGroup SubjectRadioGroup;
    private javax.swing.JLabel SubjectRadioLabel;
    private javax.swing.JScrollPane TableScrollPanel;
    private javax.swing.JButton UpdateActivityAcceptButton;
    private javax.swing.JButton UpdateActivityCancelButton;
    private javax.swing.JCheckBox UpdateActivityCompletedCheckBox;
    private javax.swing.JTextArea UpdateActivityDescriptionInput;
    private javax.swing.JLabel UpdateActivityDescriptionLabel;
    private javax.swing.JDialog UpdateActivityDialoge;
    private javax.swing.JSpinner UpdateActivityDurationInput;
    private javax.swing.JLabel UpdateActivityDurationLabel;
    private javax.swing.JFormattedTextField UpdateActivityEndDateInput;
    private javax.swing.JLabel UpdateActivityEndDateLabel;
    private javax.swing.ButtonGroup UpdateActivityFrequencyButtonGroup;
    private javax.swing.JLabel UpdateActivityFrequencyRadioLabel;
    private javax.swing.JRadioButton UpdateActivityGroupRadio;
    private javax.swing.JComboBox<String> UpdateActivityMemberCompo;
    private javax.swing.JLabel UpdateActivityMemberLabel;
    private javax.swing.JTextField UpdateActivityNameInput;
    private javax.swing.JLabel UpdateActivityNameLabel;
    private javax.swing.JRadioButton UpdateActivityOneTimeRadio;
    private javax.swing.JMenuItem UpdateActivityOption;
    private javax.swing.JRadioButton UpdateActivityRecurrentRadio;
    private javax.swing.JComboBox<String> UpdateActivityRepeatEveryCombo;
    private javax.swing.JLabel UpdateActivityRepeatEveryLabel;
    private javax.swing.JFormattedTextField UpdateActivityStartDateInput;
    private javax.swing.JLabel UpdateActivityStartDateLabel;
    private javax.swing.ButtonGroup UpdateActivitySubjectButtonGroup;
    private javax.swing.JLabel UpdateActivitySubjectRadioLabel;
    private javax.swing.JComboBox<String> UpdateActivityTaskCombo;
    private javax.swing.JLabel UpdateActivityTaskLabel;
    private javax.swing.JRadioButton UpdateActivityindividualRadio;
    private javax.swing.JDialog UpdateGroupDialoge;
    private javax.swing.JMenuItem UpdateGroupOption;
    private javax.swing.JButton UpdateGroupsAcceptButton;
    private javax.swing.JButton UpdateGroupsCancelButton;
    private javax.swing.JTextField UpdateGroupsNameInput;
    private javax.swing.JLabel UpdateGroupsNameInputLabel;
    private javax.swing.JComboBox<String> UpdateGroupsNamesCombo;
    private javax.swing.JLabel UpdateGroupsNamesLabel;
    private javax.swing.JMenuItem UpdateMemberOption;
    private javax.swing.JButton UpdateMembersAcceptButton;
    private javax.swing.JButton UpdateMembersCancelButton;
    private javax.swing.JTextField UpdateMembersNameInput;
    private javax.swing.JLabel UpdateMembersNameInputLabel;
    private javax.swing.JComboBox<String> UpdateMembersNamesCombo;
    private javax.swing.JLabel UpdateMembersNamesLabel;
    private javax.swing.JDialog UpdateUserDialoge;
    private javax.swing.JRadioButton individualRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
