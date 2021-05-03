

USE myDB;

#########################  INSERT INTO   #####################################

INSERT INTO User(id,nom,password) VALUES (1,'titi','pwd');
INSERT INTO User(id,nom,password) VALUES (2,'toto','pwd');
    
INSERT INTO Client(numClient,prenom,nom) VALUES (1,'Alain','Therieur');	
INSERT INTO Client(numClient,prenom,nom) VALUES (2,'Jean','Bon');	
	
INSERT INTO Compte(numero,label,solde,refClient) 
    VALUES (1,'compte 1',600,1);
INSERT INTO Compte(numero,label,solde,refClient)
     VALUES (2,'compte 2',500,1);
INSERT INTO Compte(numero,label,solde,refClient) 
     VALUES (3,'compte 3',200,2);

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM User;
SELECT * FROM Compte;
SELECT * FROM Client;



