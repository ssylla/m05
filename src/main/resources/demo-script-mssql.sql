--DROP DATABASE [Demo_ENI];--Supprime la base si elle existe

--CREATE DATABASE [Demo_ENI];--Crée la base si elle existe

--Supprime les tables si elles existent
DROP TABLE [COURS_FORMATEUR];
DROP TABLE [FORMATEURS];
DROP TABLE [COURS_ENI];

--Crée la table FORMATEURS
CREATE TABLE [FORMATEURS](
	[email] [NVARCHAR](200) PRIMARY KEY,
	[nom] [NVARCHAR](250) NOT NULL,
	[prenom] [NVARCHAR](250) NOT NULL,
	[nbCoursDispenses] int DEFAULT 0) ;
	
--Crée la table COURS_ENI
CREATE TABLE [COURS_ENI](
	[id] int NOT NULL PRIMARY KEY ,
	[titre] [NVARCHAR](250) NOT NULL,
	[duree] int NOT NULL) ;
	

--Crée la table COURS_FORMATEUR
CREATE TABLE [](
	[email_formateur] [NVARCHAR](200) NOT NULL,
	[id_cours] int NOT NULL,
	PRIMARY KEY ([email_formateur],[id_cours])) ;
	
ALTER TABLE COURS_FORMATEUR add
constraint fk_FORMATEURS_COURS_FORMATEUR foreign key (email_formateur)
references FORMATEURS(email),
constraint fk_COURS_ENI_COURS_FORMATEUR foreign key (id_cours)
references COURS_ENI(id);

-- ENREGISTREMENTS :
	
--Insère des enregistrements dans la table FORMATEURS
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('abaille@campus-eni.fr','BAILLE','Anne-Lise');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('jtrillard@campus-eni.fr','TRILLARD','Julien');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('fdelaschesnais@campus-eni.fr','DELACHESNAIS','Frédéric');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('pmontembault@campus-eni.fr','MONTEMBAULT','Philippe');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('hbernard@campus-eni.fr','BERNARD','Hervé');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('tgroussard@campus-eni.fr','GROUSSARD','Thierry');
INSERT INTO [FORMATEURS] ([email],[nom],[prenom]) VALUES ('sgobin@campus-eni.fr','GOBIN','Stéphane');
                          
	
--Insère des enregistrements dans la table COURS_ENI
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (10,'Algorithmique',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (20,'Initiation Programmation avec Java',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (30,'POO avec Java',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (50,'SQL Server',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (100,'Projet Web Client',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (105,'Projet Web avec Java',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (106,'Projet Web avec Symfony',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (110,'Analyse et Conception',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (130,'Développement Web Côté client',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (140,'PHP',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (141,'Symfony',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (145,'CMS',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (146,'CMS avancé + projet',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (150,'Java SE notions complémentaires',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (160,'Développement Web côté serveur avec Java',15);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (190,'Conduite et Gestion de projet',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (231,'Déploiement sécurisé sous Linux',5);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (280,'Développement d''application mobile avec Android',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (302,'Développement Cross Platform',10);
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (321,'JavaScript',5); 
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (322,'JavaScript avancé',5);   
INSERT INTO [COURS_ENI] ([id],[titre],[duree]) VALUES (330,'Sécurité sur projet',5);

	
--Insère des enregistrements dans la table FORMATEURS
INSERT INTO [ ([email_format]eur],[id_cours]) VALUES ('abaille@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',50);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',105);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',110);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',150);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',160);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',280);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',302);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',321);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('abaille@campus-eni.fr',322);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',105);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',110);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',190);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',231);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',302);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',321);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',322);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('jtrillard@campus-eni.fr',330);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',50);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',105);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',110);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',150);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',160);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('fdelaschesnais@campus-eni.fr',280);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',106);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',140);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',141);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('pmontembault@campus-eni.fr',321);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',50);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',106);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',140);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',141);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',145);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('hbernard@campus-eni.fr',146);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',105);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',150);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',160);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('tgroussard@campus-eni.fr',280);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',10);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',20);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',30);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',50);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',100);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',105);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',110);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',130);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',150);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',160);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',190);
INSERT INTO [COURS_FORMATEUR] ([email_formateur],[id_cours]) VALUES ('sgobin@campus-eni.fr',321);
                    