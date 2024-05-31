insert into Members (member_name) values
('Ahmed'),
('Mohammed'),
('Ali');

insert into MemberGroups (group_name) values
('Managment'),
('Sales');

insert into GroupAssignments (member_id, group_id) values
(1, 1),
(2, 1),
(2, 2),
(3, 2);

insert into IndividualOneTime (task_name, task_description, member_id, start_date, duration) values
('Plan Presentation', 'presenting the initial plan to Mr. Ahmed', 2, '2024-01-08', 1),
('Materials Gathering', 'Acuire the needed meterials', 3, '2024-01-04', 11);

insert into IndividualRecurrent (task_name, task_description, member_id, start_date, duration, end_date, repeat_every) values
('Finalizing Spendature', 'Running the final checks', 1, '2024-01-01', 2, '2024-09-01', 'Month');

insert into GroupOneTime (task_name, task_description, group_id, start_date, duration) values
('Initial meeting', 'Discuss mission', 1, '2024-01-06', 1),
('Sales meeting', 'The sales initial gathering', 2, '2024-01-06', 1);

insert into GroupRecurrent (task_name, task_description, group_id, start_date, duration, end_date, repeat_every) values
('Weekly meeting', 'Weekly reporting meeting', 1, '2024-01-03', 1, '2024-09-01', 'Week');