package fr.openclassrooms.projet_6.model.site;

import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Représente un site<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idSite</li>
 * 		<li>d'un nom => nom</li>
 * 		<li>d'une description => description</li>
 * 		<li>d'une localisation => localisation</li>
 * 		<li>d'informations sur les accès au site => infoAcces</li>
 * 		<li>d'informations sur les alentours du site => infoProximite</li>
 * 		<li>d'un chemin vers une image du site => urlImageSite</li>
 * 		<li>d'un chemin vers une image des accès => urlImageAcces</li>
 * </ul>
 * 
 * @see Site#idSite
 * @see Site#getIdSite()
 * @see Site#setIdSite(int)
 * @see Site#nom
 * @see Site#getNom()
 * @see Site#setNom(String)
 * @see Site#description
 * @see Site#getDescription()
 * @see Site#setDescription(String)
 * @see Site#localisation
 * @see Site#getLocalisation()
 * @see Site#setLocalisation(String)
 * @see Site#infoAcces
 * @see Site#getInfoAcces()
 * @see Site#setInfoAcces(String)
 * @see Site#infoProximite
 * @see Site#getInfoProximite()
 * @see Site#setInfoProximite(String)
 * @see Site#urlImageSite
 * @see Site#getUrlImageSite()
 * @see Site#setUrlImageSite(String)
 * @see Site#urlImageAcces
 * @see Site#getUrlImageAcces()
 * @see Site#setUrlImageAcces(String)
 * @see Utilisateur
 * @see Topo
 * @see Voie
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
public class Site {
	
	
	
	/**
	 * <p>Représente l'identifiant d'un site</p>
	 * 
	 * @see Site#getIdSite()
	 * @see Site#setIdSite(int)
	 */
	private int idSite;
	
	
	
	/**
	 * <p>Représente le nom d'un site</p>
	 * 
	 * @see Site#getNom()
	 * @see Site#setNom(String)
	 */
	private String nom;
	
	
	
	/**
	 * <p>Représente la description d'un site</p>
	 * 
	 * @see Site#getDescription()
	 * @see Site#setDescription(String)
	 */
	private String description;
	
	
	
	/**
	 * <p>Représente la localisation d'un site</p>
	 * 
	 * @see Site#getLocalisation()
	 * @see Site#setLocalisation(String)
	 */
	private String localisation;
	
	
	
	/**
	 * <p>Représente les informations sur l'accès à un site</p>
	 * 
	 * @see Site#getInfoAcces()
	 * @see Site#setInfoAcces(String)
	 */
	private String infoAcces;
	
	
	
	/**
	 * <p>Représente les informations sur les alentours d'un site</p>
	 * 
	 * @see Site#getInfoProximite()
	 * @see Site#setInfoProximite(String)
	 */
	private String infoProximite;
	
	
	
	/**
	 * <p>Représente le chemin vers l'image d'un site</p>
	 * 
	 * @see Site#getUrlImageSite()
	 * @see Site#setUrlImageSite(String)
	 */
	private String urlImageSite;
	
	
	
	/**
	 * <p>Représente le chemin vers l'image d'accès d'un site</p>
	 * 
	 * @see Site#getUrlImageAcces()
	 * @see Site#setUrlImageAcces(String)
	 */
	private String urlImageAcces;
	
	
	/**
	 * <p>Construteur par défaut</p>
	 */
	public Site() {}
	
	
	
	/**
	 * <p>Constructeur avec paramètre</p>
	 * 
	 * @param idSite Un identifiant de site
	 */
	public Site(int idSite) {
		this.idSite = idSite;
	}



	/**
	 * <p>Getter du parametre 'idSite'</p>
	 * 
	 * @return L'identifiant d'un site
	 * 
	 * @see Site#idSite
	 * @see Site#setIdSite(int)
	 */
	public int getIdSite() {
		return idSite;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idSite'</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * 
	 * @see Site#idSite
	 * @see Site#getIdSite()
	 */
	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'nom'</p>
	 * 
	 * @return Le nom d'un site
	 * 
	 * @see Site#nom
	 * @see Site#setNom(String)
	 */
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'nom'</p>
	 * 
	 * @param nom Le nom d'un site
	 * 
	 * @see Site#nom
	 * @see Site#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'description'</p>
	 * 
	 * @return La description d'un site
	 * 
	 * @see Site#description
	 * @see Site#setDescription(String)
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'description'</p>
	 * 
	 * @param description La description d'un site
	 * 
	 * @see Site#description
	 * @see Site#getDescription()
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'localisation'</p>
	 * 
	 * @return La localisation d'un site
	 * 
	 * @see Site#localisation
	 * @see Site#setLocalisation(String)
	 */
	public String getLocalisation() {
		return localisation;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'localisation'</p>
	 * 
	 * @param localisation La localisation d'un site
	 * 
	 * @see Site#localisation
	 * @see Site#getLocalisation()
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'infoAcces'</p>
	 * 
	 * @return Les informations d'accès à un site
	 * 
	 * @see Site#infoAcces
	 * @see Site#setInfoAcces(String)
	 */
	public String getInfoAcces() {
		return infoAcces;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'infoAcces'</p>
	 * 
	 * @param infoAcces Les informations d'accès à un site
	 * 
	 * @see Site#infoAcces
	 * @see Site#getInfoAcces()
	 */
	public void setInfoAcces(String infoAcces) {
		this.infoAcces = infoAcces;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'infoProximite'</p>
	 * 
	 * @return Les informations sur les alentours d'un site
	 * 
	 * @see Site#infoProximite
	 * @see Site#setInfoProximite(String)
	 */
	public String getInfoProximite() {
		return infoProximite;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'infoProximite'</p>
	 * 
	 * @param infoProximite Les informations sur les alentours d'un site
	 * 
	 * @see Site#infoProximite
	 * @see Site#getInfoProximite()
	 */
	public void setInfoProximite(String infoProximite) {
		this.infoProximite = infoProximite;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'urlImageSite'</p>
	 * 
	 * @return Le chemin vers l'image d'un site
	 * 
	 * @see Site#urlImageSite
	 * @see Site#setUrlImageSite(String)
	 */
	public String getUrlImageSite() {
		return urlImageSite;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'urlImageSite'</p>
	 * 
	 * @param urlImageSite Le chemin vers l'image d'un site
	 * 
	 * @see Site#urlImageSite
	 * @see Site#getUrlImageSite()
	 */
	public void setUrlImageSite(String urlImageSite) {
		this.urlImageSite = urlImageSite;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'urlImageAcces'</p>
	 * 
	 * @return Le chemin vers l'image d'accès d'un site
	 * 
	 * @see Site#urlImageAcces
	 * @see Site#setUrlImageAcces(String)
	 */
	public String getUrlImageAcces() {
		return urlImageAcces;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'urlImageAcces'</p>
	 * 
	 * @param urlImageAcces Le chemin vers l'image d'accès d'un site
	 * 
	 * @see Site#urlImageAcces
	 * @see Site#getUrlImageAcces()
	 */
	public void setUrlImageAcces(String urlImageAcces) {
		this.urlImageAcces = urlImageAcces;
	}
}
