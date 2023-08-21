
-- Supprime les tables si elles existent
DROP TABLE IF EXISTS `cours_formateur`;
DROP TABLE IF EXISTS `formateur`;
DROP TABLE IF EXISTS `cours_eni`;

-- Crée la table `cours_eni`
CREATE TABLE `cours_eni` (
	id int NOT NULL PRIMARY KEY ,
	titre VARCHAR(250) NOT NULL,
	duree int NOT NULL) ;

-- Crée la table FORMATEURS
CREATE TABLE `formateur` (
	`email` VARCHAR(200) NOT NULL COLLATE 'utf8mb3_general_ci',
	`nom` VARCHAR(250) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`prenom` VARCHAR(250) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`id_cours_principal` INT NULL,
	PRIMARY KEY (`email`) USING BTREE,
	CONSTRAINT `FK_FOR_COURS` FOREIGN KEY (`id_cours_principal`) REFERENCES `cours_eni` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Création de la table de liaison
CREATE TABLE `cours_formateur` (
	`email_formateur` VARCHAR(200) NOT NULL COLLATE 'utf8mb3_general_ci',
	`id_cours` INT(11) NOT NULL,
	PRIMARY KEY (`email_formateur`, `id_cours`) USING BTREE,
	INDEX `fk_COURS_ENI_cours_formateur` (`id_cours`) USING BTREE,
	CONSTRAINT `fk_COURS_ENI_cours_formateur` FOREIGN KEY (`id_cours`) REFERENCES `cours_eni` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fk_FORMATEURS_cours_formateur` FOREIGN KEY (`email_formateur`) REFERENCES `formateur` (`email`) ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- ENREGISTREMENTS :
                          
-- Insère des enregistrements dans la table `cours_eni`
INSERT INTO `cours_eni` (id,titre,duree) VALUES (10,'Algorithmique',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (20,'Initiation Programmation avec Java',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (30,'POO avec Java',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (50,'SQL Server',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (100,'Projet Web Client',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (105,'Projet Web avec Java',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (106,'Projet Web avec Symfony',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (110,'Analyse et Conception',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (130,'Développement Web Côté client',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (140,'PHP',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (141,'Symfony',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (145,'CMS',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (146,'CMS avancé + projet',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (150,'Java SE notions complémentaires',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (160,'Développement Web côté serveur avec Java',15);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (190,'Conduite et Gestion de projet',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (231,'Déploiement sécurisé sous Linux',5);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (280,'Développement d''application mobile avec Android',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (302,'Développement Cross Platform',10);
INSERT INTO `cours_eni` (id,titre,duree) VALUES (321,'JavaScript',5); 
INSERT INTO `cours_eni` (id,titre,duree) VALUES (322,'JavaScript avancé',5);   
INSERT INTO `cours_eni` (id,titre,duree) VALUES (330,'Sécurité sur projet',5);

	
-- Insère des enregistrements dans la table FORMATEURS
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('abaille@campus-eni.fr','BAILLE','Anne-Lise',160);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('jtrillard@campus-eni.fr','TRILLARD','Julien',321);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('fdelaschesnais@campus-eni.fr','DELACHESNAIS','Frédéric',50);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('pmontembault@campus-eni.fr','MONTEMBAULT','Philippe',141);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('hbernard@campus-eni.fr','BERNARD','Hervé',145);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('tgroussard@campus-eni.fr','GROUSSARD','Thierry',30);
INSERT INTO `formateur` (email,nom,prenom,id_cours_principal) VALUES ('sgobin@campus-eni.fr','GOBIN','Stéphane',110);


INSERT INTO `cours_formateur` (email_formateur,id_cours) VALUES ('abaille@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',50);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',105);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',110);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',150);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',160);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',280);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',302);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',321);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('abaille@campus-eni.fr',322);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',105);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',110);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',190);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',231);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',302);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',321);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',322);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('jtrillard@campus-eni.fr',330);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',50);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',105);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',110);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',150);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',160);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('fdelaschesnais@campus-eni.fr',280);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',106);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',140);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',141);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('pmontembault@campus-eni.fr',321);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',50);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',106);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',140);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',141);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',145);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('hbernard@campus-eni.fr',146);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',105);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',150);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',160);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('tgroussard@campus-eni.fr',280);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',10);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',20);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',30);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',50);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',100);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',105);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',110);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',130);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',150);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',160);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',190);
INSERT INTO `cours_formateur` (email_formateur,id_cours)  VALUES ('sgobin@campus-eni.fr',321);