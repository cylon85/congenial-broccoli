create table user
(
   user_id INTEGER PRIMARY KEY DEFAULT not null,
   user_name varchar(255) not null,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   task_id UNIQUEIDENTIFIER FOREIGN KEY REFERENCES task(task_id) not null
);

create table task
(
   task_id INTEGER PRIMARY KEY DEFAULT not null,
   name varchar(255) not null,
   description varchar(255) not null,
   date_time DATETIME DEFAULT (GETDATE()) NOTNULL

);