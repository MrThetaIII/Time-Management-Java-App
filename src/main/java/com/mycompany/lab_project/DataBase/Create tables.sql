drop database if exists task_scheduler;
create database task_scheduler;
use task_scheduler;

create table Members
(
	id int not null unique auto_increment,
    primary key (id),
	member_name varchar(255) not null
);

create table MemberGroups
(
	id int not null unique auto_increment,
    primary key (id),
	group_name varchar(255) not null
);

create table GroupAssignments
(
	id int not null unique auto_increment,
    primary key (id),
	member_id int not null,
    foreign key (member_id) references Members(id),
    group_id int not null,
    foreign key (group_id) references MemberGroups(id)
);

create table IndividualOneTime
(
	id int not null unique auto_increment,
	primary key (id),
    task_name varchar(255) not null,
    task_description text,
    member_id int not null,
    foreign key (member_id) references Members(id),
    start_date date not null,
    duration int not null default 1
);

create table IndividualRecurrent
(
	id int not null unique auto_increment,
	primary key (id),
    task_name varchar(255) not null,
    task_description text,
    member_id int not null,
    foreign key (member_id) references Members(id),
    start_date date not null,
    duration int not null default 1,
    end_date date not null,
    repeat_every varchar(30)
);

create table GroupOneTime
(
	id int not null unique auto_increment,
	primary key (id),
    task_name varchar(255) not null,
    task_description text,
    group_id int not null,
    foreign key (group_id) references MemberGroups(id),
    start_date date not null,
    duration int not null default 1
);

create table GroupRecurrent
(
	id int not null unique auto_increment,
	primary key (id),
    task_name varchar(255) not null,
    task_description text,
    group_id int not null,
    foreign key (group_id) references MemberGroups(id),
    start_date date not null,
    duration int not null default 1,
    end_date date not null,
    repeat_every varchar(30)
);

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
(3, 2);+--

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