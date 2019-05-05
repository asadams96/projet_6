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
 * <p>Représente un secteur<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idSecteur</li>
 * 		<li>d'un numero de secteur => numero</li>
 * 		<li>d'un nom => nom</li>
 * 		<li>d'un type => type</li>
 * 		<li>d'une orientation => orientation</li>
 * 		<li>d'informations => info</li>
 * 		<li>d'un chemin d'acces vers une image du secteur => urlImageSite</li>
 * 		<li>d'un identifiant du site dans lequel le secteur se trouve =>idSite</li>
 * </ul>
 * 
 * @see Secteur#idSecteur
 * @see Secteur#getIdSecteur()
 * @see Secteur#setIdSecteur(int)
 * @see Secteur#numero
 * @see Secteur#getNumero()
 * @see Secteur#setNumero(int)
 * @see Secteur#nom
 * @see Secteur#getNom()
 * @see Secteur#setNom(String)
 * @see Secteur#type
 * @see Secteur#getType()
 * @see Secteur#setType(String)
 * @see Secteur#orientation
 * @see Secteur#getOrientation()
 * @see Secteur#setOrientation(String)
 * @see Secteur#info
 * @see Secteur#getInfo()
 * @see Secteur#setInfo(String)
 * @see Secteur#urlImage
 * @see Secteur#getUrlImage()
 * @see Secteur#setUrlImage(String)
 * @see Secteur#idSite
 * @see Secteur#getIdSite()
 * @see Secteur#setIdSite(int)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
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
public class Secteur {
	
	
	
	/**
	 * <p>Représente l'identifiant d'un secteur</p>
	 * 
	 * @see Secteur#getIdSecteur()
	 * @see Secteur#setIdSecteur(int)
	 */
	private int idSecteur;
	
	
	
	/**
	 * <p>Représente le numero d'un secteur</p>
	 * 
	 * @see Secteur#getNumeroSecteur()
	 * @see Secteur#setNumeroSecteur(int)
	 */
	private int numero;
	
	
	/**
	 * <p>Représente le nom d'un secteur</p>
	 * 
	 * @see Secteur#getNom()
	 * @see Secteur#setNom(String)
	 */
	private String nom;
	
	
	
	/**
	 * <p>Représente le type d'un secteur</p>
	 * 
	 * @see Secteur#getType()
	 * @see Secteur#setType(String)
	 */
	private String type;
	
	
	
	/**
	 * <p>Représente l'orientation d'un secteur</p>
	 * 
	 * @see Secteur#getOrientation()
	 * @see Secteur#setOrientation(String)
	 */
	private String orientation;
	
	
	
	/**
	 * <p>Représente les informations d'un secteur</p>
	 * 
	 * @see Secteur#getInfo()
	 * @see Secteur#setInfo(String)
	 */
	private String info;
	
	
	
	/**
	 * <p>Représente le chemin vers l'image d'un secteur</p>
	 * 
	 * @see Secteur#getUrlImage()
	 * @see Secteur#setUrlImage(String)
	 */
	private String urlImage;
	
	
	
	/**
	 * <p>Représente l'identifiant du site où se trouve un secteur</p>
	 * 
	 * @see Secteur#getIdSite()
	 * @see Secteur#setIdSite(int)
	 */
	private int idSite;
	
	
	
	/**
	 * <p>Getter du parametre 'idSecteur'</p>
	 * 
	 * @return L'identifiant d'un secteur
	 * 
	 * @see Secteur#idSecteur
	 * @see Secteur#setIdSecteur(int)
	 */
	public int getIdSecteur() {
		return idSecteur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'numero'</p>
	 * 
	 * @return Le numero d'un secteur
	 * 
	 * @see Secteur#numero
	 * @see Secteur#setNumero(int)
	 */
	public int getNumero() {
		return numero;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'nom'</p>
	 * 
	 * @return Le nom d'un secteur
	 * 
	 * @see Secteur#nom
	 * @see Secteur#setNom(String)
	 */
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'type'</p>
	 * 
	 * @return Le type d'un secteur
	 * 
	 * @see Secteur#type
	 * @see Secteur#setType(String)
	 */
	public String getType() {
		return type;
	}



	/**
	 * <p>Getter du parametre 'orientation'</p>
	 * 
	 * @return L'orientation d'un secteur
	 * 
	 * @see Secteur#orientation
	 * @see Secteur#setOrientation(String)
	 */
	public String getOrientation() {
		return orientation;
	}



	/**
	 * <p>Getter du parametre 'info'</p>
	 * 
	 * @return Les informations d'un secteur
	 * 
	 * @see Secteur#info
	 * @see Secteur#setInfo(String)
	 */
	public String getInfo() {
		return info;
	}



	/**
	 * <p>Getter du parametre 'urlImage'</p>
	 * 
	 * @return Le chemin vers l'image d'un secteur
	 * 
	 * @see Secteur#urlImage
	 * @see Secteur#setUrlImage(String)
	 */
	public String getUrlImage() {
		return urlImage;
	}



	/**
	 * <p>Getter du parametre 'idSite'</p>
	 * 
	 * @return L'identifiant du site d'un secteur
	 * 
	 * @see Secteur#idSite
	 * @see Secteur#setIdSite(int)
	 */
	public int getIdSite() {
		return idSite;
	}



	/**
	 * <p>Setter du parametre 'idSecteur'</p>
	 * 
	 * @param idSecteur L'identifiant d'un secteur
	 * 
	 * @see Secteur#idSecteur
	 * @see Secteur#getIdSecteur()
	 */
	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'numero'</p>
	 * 
	 * @param numero Le numero d'un secteur
	 * 
	 * @see Secteur#numero
	 * @see Secteur#getNumero()
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}



	/**
	 * <p>Setter du parametre 'nom'</p>
	 * 
	 * @param nom Le nom d'un secteur
	 * 
	 * @see Secteur#nom
	 * @see Secteur#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * <p>Setter du parametre 'type'</p>
	 * 
	 * @param type Le type d'un secteur
	 * 
	 * @see Secteur#type
	 * @see Secteur#getType()
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'orientation'</p>
	 * 
	 * @param orientation L'orientation d'un secteur
	 * 
	 * @see Secteur#orientation
	 * @see Secteur#getOrientation()
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'info'</p>
	 * 
	 * @param info Les informations d'un secteur
	 * 
	 * @see Secteur#info
	 * @see Secteur#getInfo()
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'urlImage'</p>
	 * 
	 * @param urlImage Le chemin vers l'image d'un secteur
	 * 
	 * @see Secteur#urlImage
	 * @see Secteur#getUrlImage()
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idSite'</p>
	 * 
	 * @param idSite L'identifiant du site d'un secteur
	 * 
	 * @see Secteur#idSite
	 * @see Secteur#getIdSite()
	 */
	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}
	
	

}
