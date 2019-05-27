
CREATE SEQUENCE public.site_id_site_seq;

CREATE TABLE public.site (
                id_site INTEGER NOT NULL DEFAULT nextval('public.site_id_site_seq'),
                nom VARCHAR(50) NOT NULL,
                description VARCHAR(350) NOT NULL,
                localisation VARCHAR(75) NOT NULL,
                info_acces VARCHAR(250),
                info_proximite VARCHAR(250),
                url_image_acces VARCHAR(100),
                url_image_site VARCHAR(100) NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id_site)
);


ALTER SEQUENCE public.site_id_site_seq OWNED BY public.site.id_site;

CREATE INDEX localisation_site_idx
 ON public.site
 ( localisation );

CREATE SEQUENCE public.secteur_id_secteur_seq;

CREATE TABLE public.secteur (
                id_secteur INTEGER NOT NULL DEFAULT nextval('public.secteur_id_secteur_seq'),
                numero INTEGER NOT NULL,
                nom VARCHAR(50) NOT NULL,
                type VARCHAR(25) NOT NULL,
                orientation VARCHAR(25) NOT NULL,
                info VARCHAR(250),
                url_image VARCHAR(100),
                id_site INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id_secteur)
);


ALTER SEQUENCE public.secteur_id_secteur_seq OWNED BY public.secteur.id_secteur;

CREATE INDEX orientation_idx
 ON public.secteur
 ( orientation );

CREATE INDEX type_idx
 ON public.secteur
 ( type );

CREATE INDEX id_site_idx
 ON public.secteur
 ( id_site );

CREATE SEQUENCE public.voie_id_voie_seq;

CREATE TABLE public.voie (
                id_voie INTEGER NOT NULL DEFAULT nextval('public.voie_id_voie_seq'),
                numero INTEGER NOT NULL,
                nom VARCHAR(50) NOT NULL,
                cotation VARCHAR(15) NOT NULL,
                longueur VARCHAR(15),
                hauteur VARCHAR(15),
                nbr_point VARCHAR(5),
                type_point VARCHAR(30),
                remarque VARCHAR(100),
                id_secteur INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id_voie)
);


ALTER SEQUENCE public.voie_id_voie_seq OWNED BY public.voie.id_voie;

CREATE INDEX id_secteur_idx
 ON public.voie
 ( id_secteur );

CREATE SEQUENCE public.topo_id_topo_seq;

CREATE TABLE public.topo (
                id_topo INTEGER NOT NULL DEFAULT nextval('public.topo_id_topo_seq'),
                titre VARCHAR(100) NOT NULL,
                auteur VARCHAR(60) NOT NULL,
                annee VARCHAR(4) NOT NULL,
                description VARCHAR(500) NOT NULL,
                url_image VARCHAR(100) NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id_topo)
);


ALTER SEQUENCE public.topo_id_topo_seq OWNED BY public.topo.id_topo;

CREATE TABLE public.tampon_site_topo (
                id_site INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                CONSTRAINT tampon_site_topo_pk PRIMARY KEY (id_site, id_topo)
);


CREATE SEQUENCE public.utilisateur_id_utilisateur_seq;

CREATE TABLE public.utilisateur (
                id_utilisateur INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_utilisateur_seq'),
                mail VARCHAR(50) NOT NULL,
                pseudo VARCHAR(20) NOT NULL,
                nom VARCHAR(30) NOT NULL,
                prenom VARCHAR(30) NOT NULL,
                civilite VARCHAR(10) NOT NULL,
                localisation VARCHAR(75) NOT NULL,
                pass VARCHAR(30) NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE public.utilisateur_id_utilisateur_seq OWNED BY public.utilisateur.id_utilisateur;

CREATE INDEX id_uti_pass_idx
 ON public.utilisateur
 ( id_utilisateur, pass );

CREATE INDEX mail_pass_idx
 ON public.utilisateur
 ( mail, pass );

CREATE INDEX localisation_utilisateur_idx
 ON public.utilisateur
 ( localisation );

CREATE SEQUENCE public.message_id_message_seq;

CREATE TABLE public.message (
                id_message INTEGER NOT NULL DEFAULT nextval('public.message_id_message_seq'),
                date TIMESTAMP NOT NULL,
                contenu VARCHAR(500) NOT NULL,
                id_auteur INTEGER NOT NULL,
                CONSTRAINT message_pk PRIMARY KEY (id_message)
);


ALTER SEQUENCE public.message_id_message_seq OWNED BY public.message.id_message;

CREATE INDEX date_id_auteur_idx
 ON public.message
 ( date, id_auteur );

CREATE TABLE public.commentaire_site (
                id_message INTEGER NOT NULL,
                id_site INTEGER NOT NULL,
                CONSTRAINT commentaire_site_pk PRIMARY KEY (id_message)
);


CREATE TABLE public.commentaire_topo (
                id_message INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                CONSTRAINT commentaire_topo_pk PRIMARY KEY (id_message)
);


CREATE TABLE public.tampon_proprietaire_topo (
                id_proprietaire INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                quantite INTEGER NOT NULL,
                CONSTRAINT tampon_proprietaire_topo_pk PRIMARY KEY (id_proprietaire, id_topo)
);


CREATE SEQUENCE public.pret_id_pret_seq;

CREATE TABLE public.pret (
                id_pret INTEGER NOT NULL DEFAULT nextval('public.pret_id_pret_seq'),
                date TIMESTAMP NOT NULL,
                etat VARCHAR(25) NOT NULL,
                id_utilisateur INTEGER NOT NULL,
                id_topo INTEGER NOT NULL,
                id_proprietaire INTEGER NOT NULL,
                CONSTRAINT pret_pk PRIMARY KEY (id_pret)
);


ALTER SEQUENCE public.pret_id_pret_seq OWNED BY public.pret.id_pret;

CREATE INDEX etat_id_uti_idx
 ON public.pret
 ( id_utilisateur, etat );

CREATE INDEX etat_id_proprio_idx
 ON public.pret
 ( id_proprietaire, etat );

CREATE TABLE public.message_pret (
                id_message INTEGER NOT NULL,
                id_pret INTEGER NOT NULL,
                CONSTRAINT message_pret_pk PRIMARY KEY (id_message)
);


ALTER TABLE public.commentaire_site ADD CONSTRAINT site_commentaire_site_fk
FOREIGN KEY (id_site)
REFERENCES public.site (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tampon_site_topo ADD CONSTRAINT site_tampon_site_tpo_fk
FOREIGN KEY (id_site)
REFERENCES public.site (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (id_site)
REFERENCES public.site (id_site)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur)
REFERENCES public.secteur (id_secteur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tampon_proprietaire_topo ADD CONSTRAINT topo_liaison_utilisateur_topo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT topo_commentaire_topo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tampon_site_topo ADD CONSTRAINT topo_tampon_site_tpo_fk
FOREIGN KEY (id_topo)
REFERENCES public.topo (id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.tampon_proprietaire_topo ADD CONSTRAINT utilisateur_liaison_utilisateur_topo_fk
FOREIGN KEY (id_proprietaire)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.message ADD CONSTRAINT utilisateur_message_fk
FOREIGN KEY (id_auteur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pret ADD CONSTRAINT utilisateur_pret_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.message_pret ADD CONSTRAINT message_message_echange_fk
FOREIGN KEY (id_message)
REFERENCES public.message (id_message)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT message_commentaire_topo_fk
FOREIGN KEY (id_message)
REFERENCES public.message (id_message)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_site ADD CONSTRAINT message_commentaire_site_fk
FOREIGN KEY (id_message)
REFERENCES public.message (id_message)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.pret ADD CONSTRAINT liaison_utilisateur_topo_echange_fk
FOREIGN KEY (id_proprietaire, id_topo)
REFERENCES public.tampon_proprietaire_topo (id_proprietaire, id_topo)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.message_pret ADD CONSTRAINT echange_message_echange_fk
FOREIGN KEY (id_pret)
REFERENCES public.pret (id_pret)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
