CREATE DATABASE dawa;
CREATE USER 'dawa'@'%' IDENTIFIED BY 'dawa';
GRANT ALL PRIVILEGES ON dawa.* TO 'dawa'@'localhost' identified by 'dawa';
USE dawa;