
CREATE DATABASE IF NOT EXISTS myDB;
USE myDB;

DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS compte;


CREATE TABLE compte(
    numero integer auto_increment,
	label VARCHAR(64),
	solde double,
	PRIMARY KEY(numero));
	
CREATE TABLE operation(
	label VARCHAR(64),
	montant double,
	numOp integer auto_increment,
	dateOp DATE,
	numCompte integer,
	PRIMARY KEY(numOp));		

ALTER TABLE operation ADD CONSTRAINT Operation_avec_compte_valide 
FOREIGN KEY (numCompte) REFERENCES compte(numero);
	