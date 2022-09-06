IF OBJECT_ID('dbo.Category', 'U') IS NOT NULL 
  DROP TABLE dbo.Category;

CREATE TABLE  Category (
    id INTEGER NOT NULL,
    NAME VARCHAR(255),
    shortName VARCHAR(255),
    catid INTEGER,
    PRIMARY KEY (id)
) ;

IF OBJECT_ID('dbo.Hobby', 'U') IS NOT NULL 
  DROP TABLE dbo.Hobby;
    
CREATE TABLE   Hobby (
    id INTEGER NOT NULL IDENTITY,
    NAME VARCHAR(255),
    PRIMARY KEY (id)
) ;

INSERT INTO Category VALUES 
	( 101, '有學籍學生', '學', 101), 
	( 111, '公務人員', '公', 111),	
	( 121, '軍職人員', '軍', 121),
	( 131, '自由業', '自', 131),	
	( 141, '家庭主婦', '家', 141);
	
INSERT INTO Hobby (Name) VALUES 
	(  '電腦/手機遊戲'), 
	(  '游泳'),	
	(  '登山'),
	(  '寫程式'),	
	(  '健行'),	
	(  '逛街');	