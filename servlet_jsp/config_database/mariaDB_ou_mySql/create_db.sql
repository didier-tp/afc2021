
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;

DROP TABLE IF EXISTS User;


CREATE TABLE User(
    id integer auto_increment,
	username VARCHAR(64),
	password VARCHAR(64),
	email VARCHAR(64),
	PRIMARY KEY(id));

	