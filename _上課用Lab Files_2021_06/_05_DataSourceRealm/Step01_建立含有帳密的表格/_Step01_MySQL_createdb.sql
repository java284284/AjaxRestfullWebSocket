-- 在MySQL視窗，執行本程式 _Step01_MySQL_createdb.sql

use jspdb;

drop table if exists users ; 
drop table if exists user_roles ;
create table users (
   username varchar(50) not null primary key,
   password varchar(32) not null 
);

create table user_roles (
   username varchar(50) not null ,
   role_name  varchar(20) not null ,
   primary key (username, role_name)
);

insert into users values('tomcat', 'dr123');
insert into users values('john', 'dr123');
insert into users values('mary', 'dr123');
--   密碼為 dr456   ----
insert into users values('tomcat2', 'b9460aa31350e2c050b013a9a5f1a19d');
insert into users values('john2', 'b9460aa31350e2c050b013a9a5f1a19d');
insert into users values('mary2', 'b9460aa31350e2c050b013a9a5f1a19d');

insert into user_roles values('tomcat', 'employee');
insert into user_roles values('john', 'employee');
insert into user_roles values('john', 'admin');
insert into user_roles values('mary', 'admin');
insert into user_roles values('tomcat2', 'employee');
insert into user_roles values('john2', 'employee');
insert into user_roles values('john2', 'admin');
insert into user_roles values('mary2', 'admin');
