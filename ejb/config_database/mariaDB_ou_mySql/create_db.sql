
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;

DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;

CREATE TABLE User(
    id integer auto_increment,
	nom VARCHAR(64),
	password VARCHAR(64),
	PRIMARY KEY(id));


CREATE TABLE Client(
    numClient integer auto_increment,
	prenom VARCHAR(64),
	nom VARCHAR(64),
	PRIMARY KEY(numClient));

CREATE TABLE Compte(
    numero integer auto_increment,
	label VARCHAR(64),
	solde double,
	refClient integer,
	PRIMARY KEY(numero));

ALTER TABLE Compte ADD CONSTRAINT CompteRefClientvalide 
FOREIGN KEY (refClient) REFERENCES Client(numClient);	