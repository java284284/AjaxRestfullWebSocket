IF OBJECT_ID('dbo.User_Table', 'U') IS NOT NULL 
  DROP TABLE dbo.User_Table; 

create table User_Table (
   id bigint identity not null,
    age int,
    name varchar(255),
    salary double precision,
    primary key (id)
)

INSERT INTO USER_TABLE (age, name, salary) VALUES 
   (25, '王德林', 45000), 
   (35, '林春芳', 57000), 
   (50, '張勤',  43000),
   (24, '劉玲玲', 43000),
   (32, '梁美珍', 43000)
