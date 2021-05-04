
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;


DROP TABLE IF EXISTS compte;



CREATE TABLE compte(
    numero integer auto_increment,
	label VARCHAR(64),
	solde double,
	PRIMARY KEY(numero));

	