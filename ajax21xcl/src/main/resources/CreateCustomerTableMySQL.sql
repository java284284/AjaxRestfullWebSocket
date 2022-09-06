DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (    
    id    int  auto_increment  primary  key, 
    custId    VARCHAR(30),   
    password  VARCHAR(50), 
	eMail     VARCHAR(200)   
);

INSERT INTO ProductOrders VALUES (null, 'A1001', 258.8);
INSERT INTO ProductOrders VALUES (null, 'A1057', 580.0);
INSERT INTO ProductOrders VALUES (null, 'A1066',  79.3);

DROP TABLE IF EXISTS Security;
CREATE TABLE Security (    
    id         int auto_increment primary key, 
    orderId    VARCHAR(30),
    total      NUMERIC(12,2)
);

DROP TABLE IF EXISTS Message;
CREATE TABLE Message (    
    id        int auto_increment primary key,
    fromid    VARCHAR(30),
    toid      VARCHAR(30),
    title     VARCHAR(100),
    postTime  datetime,
    message   text
    
);

DROP TABLE IF EXISTS Cookies;
CREATE TABLE Cookies (    
    id         int auto_increment primary key, 
    name       VARCHAR(30),
    value      VARCHAR(30)
);
