INSERT INTO public.site
	(id_site, nom, description, localisation, info_acces, info_proximite, url_image_acces, url_image_site)
VALUES
	(1, 'Esplanada', 'Dans un cadre paradisiaque, se dresse une falaise prête à être monter...', 
	'64 - Pyrénées-atlantiques','Prenez la A75 en direction de Saint-Pierre puis prenez la sortie 23A direction Oria pendant environ 5 min.', 'Plusieurs restaurants et auberges pour vous restaurer et vous reposer aux alentours.', 
	'/sites/esplanada/acces_esplanada.jpg', '/sites/esplanada/site_esplanada.jpg'),
	(2, 'Toscada', 'Dans un cadre artificiel mais paradisiaque, se dresse une serie de bloc pret à être gravis par tous grimpeur, débutant comme expérimenté !', 
	'66 - Pyrénées-orientales','Prenez la A12 en direction de Brieux puis prenez la sortie 06 direction Saint-Maxime pendant environ 15 min.', 'Plusieurs restaurants et auberges pour vous restaurer et vous reposer aux alentours.', 
	'/sites/toscada/acces_toscada.jpg', '/sites/toscada/site_toscada.jpg'),
	(3, 'Queyras', 'Dans un cadre paradisiaque, se dresse une falaise prête à être monter...', 
	'05 - Hautes-alpes','Prenez la A24 en direction de Clamon puis prenez la sortie 19 direction Ores pendant environ 30 min.', 'Quelques auberges pour vous restaurer et vous reposer aux alentours.', 
	'/sites/queyras/acces_queyras.jpg', '/sites/queyras/site_queyras.jpg');
	
	
		
INSERT INTO public.secteur
	(id_secteur, numero, nom, type, orientation, info, url_image, id_site)
VALUES
	(1, 1, 'Secteur Est', 'Falaise', 'Est', 'Secteur pour débutant et intermédiaire','/sites/esplanada/secteur_est/secteur_est.jpg', 1),
	(2, 2, 'Secteur Nord', 'Falaise', 'Nord', 'Secteur réservé au expert', '/sites/esplanada/secteur_nord/secteur_nord.jpg', 1),	
	(3, 1, 'Bloc A', 'Bloc', 'Ouest', 'Secteur pour débutant', '/sites/toscada/bloc_a/bloc_a.jpg', 2),
	(4, 2, 'Bloc B', 'Bloc', 'Est', 'Secteur pour intermédiaire', '/sites/toscada/bloc_b/bloc_b.jpg', 2),
	(5, 3, 'Bloc C', 'Bloc', 'Sud', 'Secteur réservé au expert', '/sites/toscada/bloc_c/bloc_c.jpg', 2),
	(6, 1, 'Secteur Alpha', 'Falaise', 'Nord', 'Secteur réservé au expert', '/sites/queyras/secteur_alpha/secteur_alpha.jpg', 3);	
		
				
		
INSERT INTO public.voie
	(id_voie, numero, nom, cotation, longueur, hauteur, nbr_point, type_point, remarque, id_secteur)
VALUES
	(1, 1, 'La voie du néophyte', '4.a', '4', '3', '4', 'piton', 'Parfait comme voie pour ce mettre dans le bain.', 1),
	(2, 2, 'Regarde pas en bas !', '6.a', '6', '5', '6', 'piton', 'Plus difficle que la précédente mais abordable avec un peu d''entrainement !', 1),
	(3, 1, 'La mort vous guette', '8.a', '12', '10', '10', 'piton', 'Seul au monde sur cette voie !', 2),
	(4, 1, 'Le premier défis', '3.a', '2', '2', '2', 'piquet en métal', 'Parfait comme voie pour débuter lorsqu''on a peur de se lancer', 3),
	(5, 2, 'Les ennuis commencent...', '3.c', '3', '2', '3', 'piquet en métal', 'Voie pour se détendre et réviser sa technique', 3),
	(6, 3, 'La voie des audacieux', '4.b', '4', '3', '3', 'piquet en métal', 'Dernière ligne droite..', 3),
	(7, 1, 'Le chemin du guerrier', '5.a', '5', '5', '4', 'piquet en métal', 'Plus difficile qu'' n''y parait, faîtes attention...', 4),
	(8, 2, 'Le calme avant la tempête', '5.c', '7', '5', '6', 'piquet en métal', 'Apprenez à garder le contrôle sur cette voie', 4),
	(9, 1, 'La tempête', '7.a', '7', '6', '6', 'piquet en métal', 'Prenez garde au vent sur cette voie.', 5),
	(10, 2, 'Le dernier défis', '7.c', '8', '8', '6', 'piquet en métal', 'Un bonne dose d''adrénaline à coup sur !', 5),
	(11, 1, 'L''entrainement d''Hercule', '8.a', '8', '7', '6', 'broche scellée', 'Bonne voie pour vous mettre en condition pour la suite...', 6),
	(12, 2, 'L''épreuve des Dieux', '8.b', '10', '8', '6', 'broche scellée', 'Demande beaucoup d''expérience et une grande préparation physique.', 6),
	(13, 3, 'Les portes de l''enfer', '9.b', '12', '10', '7', 'broche scellée', 'Fuyez pauvre fou..!', 6);
	


INSERT INTO public.topo
	(id_topo, titre, auteur, annee, description, url_image)
VALUES
	(1, 'La Esplanada, un site riche en suprise...', 'Didier Rochon', 
	'2014', 'Didier Rochon vous présente en détail le site Esplanada ainsi que ses abords.', '/topos/didier_rochon/topo_esplanada.jpg'),
	(2, 'La Toscada, le coin des grimpeurs', 'Jacqueline Duchemin', 
	'2015', 'Jacqueline Duchemin vous offre une présentation du site Toscada dans ses moindres détails.', '/topos/jacqueline_duchemin/topo_toscada.jpg'),
	(3, 'Les plus beaux sites des Pyrénées', 'Jacquie Dupont', 
	'2017', 'Jacquie Dupont vous fais voyager au coeur des Pyrénées en vous livrant énormement d''astuces pour vos prochaines grimpes !', '/topos/jacquie_dupont/topo_beaux_sites_pyrenees.jpg'),
	(4, 'Queyras, un périple à ne pas manquer', 'Marie Boncoeur', 
	'2018', 'Marie Boncoeur vous propose de découvrir un des plus grand défis dans le domaine de l''escalade, accrochez vous bien et bonne lecture !', '/topos/marie_boncoeur/topo_queyras.jpg');

	
	
	
INSERT INTO public.tampon_site_topo
	(id_site, id_topo)
VALUES
	(1, 1),
	(2, 2),
	(1, 3),
	(2, 3),
	(3, 4);
	
	
	
INSERT INTO public.utilisateur
	(id_utilisateur, mail, pseudo, nom, prenom, civilite, localisation, pass)
VALUES
	(1, 'jean.duboucher@mail.fr', 'Jeannot', 'Duboucher','Jean','M', '65 - Hautes-Pyrénées', 'jean1234'),
	(2, 'alexandra.deschamps@mail.fr', 'Alex', 'Deschamps','Alexandra','Mme', '65 - Hautes-Pyrénées', 'alex1234');
	


INSERT INTO public.tampon_proprietaire_topo
	(id_proprietaire, id_topo, quantite)
VALUES
	(2, 1, 1),
	(2, 2, 1),
	(1, 3, 1);
	
	
	
INSERT INTO public.message
	(id_message, date, contenu, id_auteur)
VALUES
	(1, '01/01/2019 12:18:52', 'Très bon topo, remplis de diverses informations concernant le site et ses alentours.', 1),
	(2, '03/01/2019 15:36:12', 'Ce topo est une merveille pour débutant comme confirmé !', 2),
	(3, '05/01/2019 21:56:10', 'Site merveilleux avec un coucher de soleil à ne pas louper !!!', 2),
	(4, '07/01/2019 04:12:41', 'Un beau site, malheureusement je n''ai pas eu la chance de voir le coucher de soleil à cause du mauvais temps...', 1);
	
	
	
INSERT INTO public.commentaire_topo
	(id_message, id_topo)
VALUES
	(1, 3),
	(2, 2);
	
	
	
INSERT INTO public.commentaire_site
	(id_message, id_site)
VALUES
	(3, 1),
	(4, 1);
	
	
	
ALTER SEQUENCE public.utilisateur_id_utilisateur_seq RESTART WITH 3;
ALTER SEQUENCE public.message_id_message_seq RESTART WITH 5	;