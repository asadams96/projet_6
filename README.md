#Descriptif
Depot contenant le Projet 6 : Créer un site communautaire autour de l'escalade



#Informations
Ce projet packagé par maven contient 1 module parent et 5 modules enfants.
Base de donnée : PostgreSql.
Conteneur web : Tomcat 9 (conseillé)
Jre : Java 1.8 (conseillé)



#Mise en place de la base de donnée: 
Depuis votre outil de gestion de base de donnée postgresql, executé dans l'ordre les fichiers : (annexe/bdd/...)
		- create_user.sql (Créer l'utilisateur responsable de la base de donnée => lui affecté le mot de passe : ?ü£C2%µ=$.^) /!\IMPORTANT/!\
		- create_db.sql	(Créer la base de donnée)
		- create_tables.sql (Créer les tables, séquences, indexs de la base de donnée)
		- create_demo.sql (Créer le jeu de donnée de démonstration de la base de donnée)

=> La base de donnée est maintenant prête à l'emploi.



#Mise en place de l'application web:
- Importer le projet maven multi-module dans votre IDE.
- Vérifier que les configurations de déploiement de votre IDE correspondentent à celle présentes dans le dossier "annexe/module/deploiement".
- Ajouter au répertoire "lib", présent à la racine de l'installation de votre conteneur web Tomcat, la librarie "postgresql-42.2.5.jar" présente dans le dossier "annexe/tomcat/lib".
- Configurer votre serveur Tomcat et ajouté y le module "projet_6-webapp" au déploiement (cf-rouge: annexe/tomcat/deploiement/seeMe.png)
- Remplacer le fichier "context.xml" présent dans le dossier de configuration du serveur local utilisé pour déployer l'application par le fichier du même nom présent dans le dossier "annexe/tomcat/server".

=> Démarrer le serveur Tomcat, ouvrez votre navigateur web et tapper : http://localhost:8080/projet_6-webapp/ (Remplacer 8080 par le port par défaut de votre conteneur web, s'il est différent)