package fr.openclassrooms.projet_6.model.utilisateur;

import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.topo.Topo;

/**
 * <p>Représente un utilisateur<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idUtilisateur</li>
 * 		<li>d'une adresse mail => mail</li>
 * 		<li>d'un pseudo => pseudo</li>
 * 		<li>d'un nom => nom</li>
 * 		<li>d'un prenom => prenom</li>
 * 		<li>d'une civilite => civilite</li>
 * 		<li>d'une localisation => localisation</li>
 * 		<li>d'un mot de passe => pass</li>
 * </ul>
 * 
 * @see Utilisateur#idUtilisateur 
 * @see Utilisateur#getIdUtilisateur()
 * @see Utilisateur#setIdUtilisateur(int)
 * @see Utilisateur#mail
 * @see Utilisateur#getMail()
 * @see Utilisateur#setMail(String)
 * @see Utilisateur#pseudo
 * @see Utilisateur#getPseudo()
 * @see Utilisateur#setPseudo(String)
 * @see Utilisateur#nom
 * @see Utilisateur#getNom()
 * @see Utilisateur#setNom(String)
 * @see Utilisateur#prenom
 * @see Utilisateur#getPrenom()
 * @see Utilisateur#setPrenom(String)
 * @see Utilisateur#civilite
 * @see Utilisateur#getCivilite()
 * @see Utilisateur#setCivilite(String)
 * @see Utilisateur#localisation
 * @see Utilisateur#getLocalisation()
 * @see Utilisateur#setLocalisation(String)
 * @see Utilisateur#pass
 * @see Utilisateur#getPass()
 * @see Utilisateur#setPass(String)
 * @see Utilisateur#Utilisateur()
 * @see Utilisateur#Utilisateur(int)
 * @see Utilisateur#Utilisateur(String, String, String, String, String, String, String)
 * @see Utilisateur#Utilisateur(Integer, String)
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
 * @see Pret
 * @see TamponProprietaireTopo
 * @see TamponSiteTopo
 * @see Message
 * @see MessagePret
 * @see CommentaireTopo
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class Utilisateur {
	
	
	
	/**
	 * <p>Représente l'identifiant de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getIdUtilisateur()
	 * @see Utilisateur#setIdUtilisateur(int)
	 */
	private int idUtilisateur;
	
	
	
	/**
	 * <p>Représente l'adresse mail de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getMail()
	 * @see Utilisateur#setMail(String)
	 */
	private String mail;
	
	
	
	/**
	 * <p>Représente le pseudo de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getPseudo()
	 * @see Utilisateur#setPseudo(String)
	 */
	private String pseudo;
	
	
	
	/**
	 * <p>Représente le nom de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getNom()
	 * @see Utilisateur#setNom(String)
	 */
	private String nom;
	
	
	
	/**
	 * <p>Représente le prenom de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getPrenom()
	 * @see Utilisateur#setPrenom(String)
	 */
	private String prenom;
	
	
	
	/**
	 * <p>Représente la civilite de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getCivilite()
	 * @see Utilisateur#setCivilite(String)
	 */
	private String civilite;
	
	
	
	/**
	 * <p>Représente la localisation de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getLocalisation()
	 * @see Utilisateur#setLocalisation(String)
	 */
	private String localisation;
	
	
	
	/**
	 * <p>Représente le mot de passe de l'utilisateur</p>
	 * 
	 * @see Utilisateur#getPass()
	 * @see Utilisateur#setPass(String)
	 */
	private String pass;
	
	
	
	/**
	 * <p>Constructeur par défaut</p>
	 * 
	 * @see Utilisateur#Utilisateur(int)
	 * @see Utilisateur#Utilisateur(String, String, String, String, String, String, String)
	 * @see Utilisateur#Utilisateur(Integer, String)
	 */
	public Utilisateur() {}

	
	/**
	 * <p>Construteur avec identifiant</p>
	 * 
	 * @param idUtilisateur Identifiant d'un utilisateur
	 * 
	 * @see Utilisateur#Utilisateur()
	 * @see Utilisateur#idUtilisateur
	 * @see Utilisateur#Utilisateur(String, String, String, String, String, String, String)
	 * @see Utilisateur#Utilisateur(Integer, String)
	 */
	public Utilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	
	
	/**
	 * <p>Constructeur avec paramètres</p>
	 * 
	 * @param mail Le mail de l'utilisateur
	 * @param civilite La civilite de l'utilisateur
	 * @param nom Le nom de l'utilisateur
	 * @param prenom Le prenom de l'utilisateur
	 * @param pseudo Le pseudo de l'utilisateur
	 * @param localisation La localisation de l'utilisateur
	 * @param pass Le mot de passe de l'utilisateur
	 * 
	 * @see Utilisateur#Utilisateur()
	 * @see Utilisateur#Utilisateur(int)
	 * @see Utilisateur#Utilisateur(Integer, String)
	 * @see Utilisateur#mail
	 * @see Utilisateur#civilite
	 * @see Utilisateur#nom
	 * @see Utilisateur#prenom
	 * @see Utilisateur#pseudo
	 * @see Utilisateur#localisation
	 * @see Utilisateur#pass
	 */
	public Utilisateur(String mail, String civilite, String nom, String prenom, String pseudo, String localisation, String pass) {
		this.mail = mail;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.localisation = localisation;
		this.pass = pass;
	}


	
	/**
	 * <p>Constructeur avec paramètres</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur	
	 * @param pass Le mot de passe correspondant à l'identifiant
	 * 
	 * @see Utilisateur#Utilisateur()
	 * @see Utilisateur#Utilisateur(int)
	 * @see Utilisateur#Utilisateur(String, String, String, String, String, String, String)
	 * @see Utilisateur#idUtilisateur
	 * @see Utilisateur#pass
	 */
	public Utilisateur(Integer idUtilisateur, String pass) {
		this.idUtilisateur = idUtilisateur;
		this.pass = pass;
	}

	

	/**
	 * <p>Getter du parametre 'idUtilisateur'</p>
	 * 
	 * @return L'identifiant d'un utilisateur
	 * 
	 * @see Utilisateur#idUtilisateur
	 * @see Utilisateur#setIdUtilisateur(int)
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	
	
	/**
	 * <p>Setter du parametre'idUtilisateur'</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * 
	 * @see Utilisateur#idUtilisateur
	 * @see Utilisateur#getIdUtilisateur()
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'mail'</p>
	 * 
	 * @return Le mail d'un utilisateur
	 * 
	 * @see Utilisateur#mail
	 * @see Utilisateur#setMail(String)
	 */
	public String getMail() {
		return mail;
	}
	
	
	
	/**
	 * <p>Setter du parametre'mail'</p>
	 * 
	 * @param mail Le mail d'un utilisateur
	 * 
	 * @see Utilisateur#mail
	 * @see Utilisateur#getMail()
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'pseudo'</p>
	 * 
	 * @return Le pseudo d'un utilisateur
	 * 
	 * @see Utilisateur#pseudo
	 * @see Utilisateur#setPseudo(String)
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	
	
	/**
	 * <p>Setter du parametre'pseudo'</p>
	 * 
	 * @param pseudo Le pseudo d'un utilisateur
	 * 
	 * @see Utilisateur#pseudo
	 * @see Utilisateur#getPseudo()
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'nom'</p>
	 * 
	 * @return Le nom d'un utilisateur
	 * 
	 * @see Utilisateur#nom
	 * @see Utilisateur#setNom(String)
	 */
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * <p>Setter du parametre'nom'</p>
	 * 
	 * @param nom Le nom d'un utilisateur
	 * 
	 * @see Utilisateur#nom
	 * @see Utilisateur#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'prenom'</p>
	 * 
	 * @return Le prenom d'un utilisateur
	 * 
	 * @see Utilisateur#prenom
	 * @see Utilisateur#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}
	
	
	
	/**
	 * <p>Setter du parametre'prenom'</p>
	 * 
	 * @param prenom Le prenom d'un utilisateur
	 * 
	 * @see Utilisateur#prenom
	 * @see Utilisateur#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'civilite'</p>
	 * 
	 * @return La civilite d'un utilisateur
	 * 
	 * @see Utilisateur#civilite
	 * @see Utilisateur#setCivilite(String)
	 */
	public String getCivilite() {
		return civilite;
	}
	
	
	
	/**
	 * <p>Setter du parametre'civilite'</p>
	 * 
	 * @param civilite La civilite d'un utilisateur
	 * 
	 * @see Utilisateur#civilite
	 * @see Utilisateur#getCivilite()
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'localisation'</p>
	 * 
	 * @return La localisation d'un utilisateur
	 * 
	 * @see Utilisateur#localisation
	 * @see Utilisateur#setLocalisation(String)
	 */
	public String getLocalisation() {
		return localisation;
	}
	
	
	
	/**
	 * <p>Setter du parametre'localisation'</p>
	 * 
	 * @param localisation La localisation d'un utilisateur
	 * 
	 * @see Utilisateur#localisation
	 * @see Utilisateur#getLocalisation()
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'pass'</p>
	 * 
	 * @return Le mot de passe d'un utilisateur
	 * 
	 * @see Utilisateur#pass
	 * @see Utilisateur#setPass(String)
	 */
	public String getPass() {
		return pass;
	}
	
	
	
	/**
	 * <p>Setter du parametre'pass'</p>
	 * 
	 * @param pass Le mot de passe d'un utilisateur
	 * 
	 * @see Utilisateur#pass
	 * @see Utilisateur#getPass()
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
}
