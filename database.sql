CREATE DATABASE dawa;
CREATE USER 'dawa'@'%' IDENTIFIED BY 'dawa';
GRANT ALL PRIVILEGES ON dawa.* TO 'dawa'@'localhost' identified by 'dawa';
USE dawa;

-- CREATE TABLE `order` (
-- 	id INTEGER PRIMARY KEY AUTO_INCREMENT,
-- 	customerName VARCHAR(200) NOT NULL,
-- 	customerEmail VARCHAR(500) NOT NULL,
-- 	totalPrice FLOAT NOT NULL
-- );

-- CREATE table `order_line` (
-- 	orderId INTEGER NOT NULL,
-- 	lineNumber INTEGER NOT NULL,
-- 	title VARCHAR(200) NOT NULL,
-- 	artist VARCHAR(200) NOT NULL,
-- 	country VARCHAR(200) NOT NULL,
-- 	unitPrice FLOAT NOT NULL,
-- 	quantity INTEGER NOT NULL,
-- 	totalPrice INTEGER NOT NULL,

-- 	FOREIGN KEY (orderId) REFERENCES `order`(id)
-- 		ON DELETE CASCADE ON UPDATE CASCADE,

-- 	PRIMARY KEY (orderId, lineNumber)
-- );