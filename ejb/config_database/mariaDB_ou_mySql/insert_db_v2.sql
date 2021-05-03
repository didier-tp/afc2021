

USE myDB;

#########################  INSERT INTO   #####################################

INSERT INTO Adresse (codePostal,idAdr,rue,ville)  VALUES ('75000',1,'2 rue elle','Paris');
INSERT INTO Client (numClient,nom,prenom,dateNaissance,ref_adressePrincipale,password,telephone,email)
              VALUES (1,'Defrance','Didier','1969-07-11',1,'mypwd','0102030405','didier@ici_ou_la');
INSERT INTO Client (numClient,nom,prenom,dateNaissance,ref_adressePrincipale,password,telephone,email)
              VALUES (2,'Therieur','Alex','1969-07-12',1,'mypwd','010900909','alex@ici_ou_la');              
INSERT INTO Compte (label,numCpt,solde) VALUES ('compte courant',1,1200.0);
INSERT INTO Compte (label,numCpt,solde) VALUES ('compte codevi',2,50.0);   
INSERT INTO Compte (label,numCpt,solde) VALUES ('compte 3',3,52.0);  
INSERT INTO Operation (dateOp,label,montant,numOp,ref_compte)  VALUES ('2011-01-20','achat yy',-50.0,1,1);
INSERT INTO Operation (dateOp,label,montant,numOp,ref_compte)  VALUES ('2011-01-21','achat zz',-30.0,2,1);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (1,1);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (1,2);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (2,3);

INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('E',1.2,'euro');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('Y',0.2,'yen');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('D',1.0,'dollar');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('L',1.1,'livre');

# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Paris','fr','France','E');
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Berlin','de','Allemagne','E');
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Rome','it','Italie','E');
               
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Londres','uk','Royaumes unis','L'); 
               
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Washingtown','us','USA','D');     
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Pekin','china','Chine','D');  
               
# INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
#               VALUES ('Tokyo','JP','Japon','Y');     

###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM Client;
SELECT * FROM Adresse;
SELECT * FROM Compte;
SELECT * FROM Operation;
SELECT * FROM ClientCompte;

SELECT * FROM Devise;
# SELECT * FROM Pays;


