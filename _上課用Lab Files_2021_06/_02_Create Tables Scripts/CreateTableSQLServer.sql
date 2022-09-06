use JSPDB;

IF OBJECT_ID('jspdb..Customer') IS NOT NULL DROP TABLE Customer;
CREATE TABLE Customer (    
    id        int IDENTITY primary key, 
    custId    VARCHAR(30),   
    password  VARCHAR(50), 
	eMail     VARCHAR(200)   
);
INSERT INTO Customer VALUES ('kitty',  '123s', 'kitty@gmail.com');
INSERT INTO Customer VALUES ('micky',  '456s', 'micky@gmail.com');
INSERT INTO Customer VALUES ('snoopy', '789s', 'snoopy@gmail.com');


IF OBJECT_ID('jspdb..ProductOrders') IS NOT NULL DROP TABLE ProductOrders
CREATE TABLE ProductOrders (    
    id         int IDENTITY primary key, 
    orderId    VARCHAR(30),
    total      NUMERIC(12,2)
);
INSERT INTO ProductOrders VALUES ('A1001', 258.8);
INSERT INTO ProductOrders VALUES ('A1057', 580.0);
INSERT INTO ProductOrders VALUES ('A1066',  79.3);


IF OBJECT_ID('jspdb..Security') IS NOT NULL DROP TABLE Security
CREATE TABLE Security (    
    id         int IDENTITY primary key, 
    orderId    VARCHAR(30),
    total      NUMERIC(12,2)
);
INSERT INTO Security VALUES ('A110123', 258.8);
INSERT INTO Security VALUES ('A110125', 580.0);
INSERT INTO Security VALUES ('A110147',   79.3);


IF OBJECT_ID('jspdb..Message') IS NOT NULL DROP TABLE Message
CREATE TABLE Message (    
    id        int IDENTITY primary key,
    fromid    VARCHAR(30),
    toid      VARCHAR(30),
    title     VARCHAR(100),
    postTime  datetime,
    message   text
);


IF OBJECT_ID('jspdb..Cookies') IS NOT NULL DROP TABLE Cookies
CREATE TABLE Cookies (    
    id         int IDENTITY primary key, 
    name       VARCHAR(30),
    value      VARCHAR(30)
);
