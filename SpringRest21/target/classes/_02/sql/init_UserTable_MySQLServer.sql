DROP TABLE IF EXISTS User_Table; 
CREATE TABLE User_Table (
   id BIGINT AUTO_INCREMENT NOT NULL,
    age INT,
    NAME VARCHAR(255),
    salary DECIMAL,
    PRIMARY KEY (id)
);

INSERT INTO USER_TABLE (age, NAME, salary) VALUES 
   (25, '王德林', 45000), 
   (35, '林春芳', 57000), 
   (50, '張勤',  43000),
   (24, '劉玲玲', 43000),
   (32, '梁美珍', 43000)
