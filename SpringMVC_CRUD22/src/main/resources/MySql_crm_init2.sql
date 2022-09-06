DROP TABLE IF EXISTS Category;

CREATE TABLE IF NOT EXISTS Category (
    id INTEGER NOT NULL,
    NAME VARCHAR(255),
    shortName VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=INNODB;

DROP TABLE IF EXISTS Hobby;
    
CREATE TABLE IF NOT EXISTS  Hobby (
    id INTEGER NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=INNODB;

INSERT INTO Category VALUES 
	(101, '有學籍學生', "學"), 
	(111, '公務人員', "公"),	
	(121, '軍職人員', "軍"),
	(131, '自由業', "自"),	
	(141, '家庭主婦', "家");
	
INSERT INTO Hobby VALUES 
	( NULL, '電腦/手機遊戲'), 
	( NULL, '游泳'),	
	( NULL, '登山'),
	( NULL, '寫程式'),	
	( NULL, '健行'),	
	( NULL, '逛街');	