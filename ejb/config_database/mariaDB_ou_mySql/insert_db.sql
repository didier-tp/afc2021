

USE myDB;

#########################  INSERT INTO   #####################################

DELETE FROM compte;

INSERT INTO compte(numero,label,solde) 
    VALUES (1,'compte 1',60);
INSERT INTO compte(numero,label,solde)
     VALUES (2,'compte 2',50);
INSERT INTO compte(numero,label,solde) 
     VALUES (3,'compte 3',20);

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM compte;




