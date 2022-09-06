-- hbm2dll.auto為update，而Hibernate卻嘗試create Table，請用
-- Hibernate自動產生的create Table敘述來自建表格。
DROP TABLE IF EXISTS Member_For_REST; 

CREATE TABLE Member_For_REST (
    pk 			int AUTO_INCREMENT not null,
    id 			varchar(30),
    name 		varchar(64),
    balance 	decimal(10,2),
	birthday 	datetime,
    primary key (pk)
 );

INSERT INTO Member_For_REST (id, name, balance, birthday) VALUES 
('kitty',  '凱蒂貓', 2500.20, '1970-5-2'), 
('mickey', '米小薯',17500.00, '1980-11-1'), 
('snoopy', '史努比', 1258.60, '1985-12-6')
