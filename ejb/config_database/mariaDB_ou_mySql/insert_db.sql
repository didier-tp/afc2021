

USE myDB;

#########################  INSERT INTO   #####################################

DELETE FROM operation;
DELETE FROM compte;

INSERT INTO compte(numero,label,solde) 
    VALUES (1,'compte 1',60);
INSERT INTO compte(numero,label,solde)
     VALUES (2,'compte 2',50);
INSERT INTO compte(numero,label,solde) 
     VALUES (3,'compte 3',20);
	 
INSERT INTO operation (dateOp,label,montant,numOp,numCompte)  VALUES ('2011-01-20','achat yy',-50.0,1,1);
INSERT INTO operation (dateOp,label,montant,numOp,numCompte)  VALUES ('2011-01-21','achat zz',-30.0,2,1);	 

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM compte;
SELECT * FROM operation;



