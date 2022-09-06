-- 在MySQL視窗，執行本程式 createdb_MySQL.sql

use jspdb;

drop table if exists users ; 
drop table if exists user_roles ;
create table users (
   username varchar(50) not null primary key,
   password varchar(96) not null 
);

create table user_roles (
   username varchar(50) not null ,
   role_name  varchar(20) not null ,
   primary key (username, role_name)
);

insert into users values('tomcat', 'jr123');
insert into users values('john', 'jr123');
insert into users values('mary', 'jr123');
--   密碼為 jr456 / MD5  ----
insert into users values('tomcat2', '92fc4f78c3d06081a55d9a24e9c1adbb');
insert into users values('john2', '92fc4f78c3d06081a55d9a24e9c1adbb');
insert into users values('mary2', '92fc4f78c3d06081a55d9a24e9c1adbb');

--   密碼為 jr789 / SHA-256   ----
insert into users values('tomcat3', 'aa05d388abf0d04a7f97f445fa0e9181fc1885002387fc638e6273bf88d7564e');
insert into users values('john3', 'aa05d388abf0d04a7f97f445fa0e9181fc1885002387fc638e6273bf88d7564e');
insert into users values('mary3', 'aa05d388abf0d04a7f97f445fa0e9181fc1885002387fc638e6273bf88d7564e');

--   密碼為 jr012 / SHA-384   ----
insert into users values('tomcat4', '12d128a68550f5fd54b2497f7ab5716743be5bb02208b40f4b3c04d46118391e901beeb3b7fa4044a9fe8857d939afda');
insert into users values('john4', '12d128a68550f5fd54b2497f7ab5716743be5bb02208b40f4b3c04d46118391e901beeb3b7fa4044a9fe8857d939afda');
insert into users values('mary4', '12d128a68550f5fd54b2497f7ab5716743be5bb02208b40f4b3c04d46118391e901beeb3b7fa4044a9fe8857d939afda');


insert into user_roles values('tomcat', 'employee');
insert into user_roles values('john', 'employee');
insert into user_roles values('john', 'admin');
insert into user_roles values('mary', 'admin');
insert into user_roles values('tomcat2', 'employee');
insert into user_roles values('john2', 'employee');
insert into user_roles values('john2', 'admin');
insert into user_roles values('mary2', 'admin');

insert into user_roles values('tomcat3', 'employee');
insert into user_roles values('john3', 'employee');
insert into user_roles values('john3', 'admin');
insert into user_roles values('mary3', 'admin');

insert into user_roles values('tomcat4', 'employee');
insert into user_roles values('john4', 'employee');
insert into user_roles values('john4', 'admin');
insert into user_roles values('mary4', 'admin');

