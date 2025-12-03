CREATE DATABASE IF NOT EXISTS `practical_test`;

USE `practical_test`;

CREATE TABLE IF NOT EXISTS `user` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(100) ,
    lastname VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(255)
    );

CREATE INDEX idx_email ON `user`(email);

DESCRIBE `user`;