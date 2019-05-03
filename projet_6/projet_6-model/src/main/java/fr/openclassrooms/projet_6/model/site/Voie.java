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
 * <p>Représente une voie<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idVoie</li>
 * 		<li>d'un numero => numero</li>
 * 		<li>d'un nom => nom</li>
 * 		<li>d'une cotation => cotation</li>
 * 		<li>d'une longueur => longueur</li>
 * 		<li>d'une hauteur => hauteur</li>
 * 		<li>d'un nombre de point d'ancrage => nbrPoint</li>
 * 		<li>d'un type de point d'ancrage => typePoint</li>
 * 		<li>d'une remarque => remarque</li>
 * 		<li>de l'identifiant du secteur où se trouve la voie => idSecteur</li>
 * </ul>
 * 
 * @see Voie#idVoie
 * @see Voie#getIdVoie()
 * @see Voie#setIdVoie(int)
 * @see Voie#numero
 * @see Voie#getNumero()
 * @see Voie#setNumero(int)
 * @see Voie#nom
 * @see Voie#getNom()
 * @see Voie#setNom(String)
 * @see Voie#cotation
 * @see Voie#getCotation()
 * @see Voie#setCotation(String)
 * @see Voie#longueur
 * @see Voie#getLongueur()
 * @see Voie#setLongueur(String)
 * @see Voie#hauteur
 * @see Voie#getHauteur()
 * @see Voie#setHauteur(String)
 * @see Voie#nbrPoint
 * @see Voie#getNbrPoint()
 * @see Voie#setNbrPoint(String)
 * @see Voie#typePoint
 * @see Voie#getTypePoint()
 * @see Voie#setTypePoint(String)
 * @see Voie#remarque
 * @see Voie#getRemarque()
 * @see Voie#setRemarque(String)
 * @see Voie#idSecteur
 * @see Voie#getIdSecteur()
 * @see Voie#setIdSecteur(int)
 * @see Utilisateur
 * @see Topo
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
public class Voie {
	
	
	/**
	 * <p>Représente l'identifiant d'une voie</p>
	 * 
	 * @see Voie#getIdVoie()
	 * @see Voie#setIdVoie(int)
	 */
	private int idVoie;
	
	
	
	/**
	 * <p>Représente le numero d'une voie</p>
	 * 
	 * @see Voie#getNumero()
	 * @see Voie#setNumero(int)
	 */
	private int numero;
	
	
	
	/**
	 * <p>Représente le nom d'une voie</p>
	 * 
	 * @see Voie#getNom()
	 * @see Voie#setNom(String)
	 */
	private String nom;
	
	
	
	/**
	 * <p>Représente la cotation d'une voie</p>
	 * 
	 * @see Voie#getCotation()
	 * @see Voie#setCotation(String)
	 */
	private String cotation;
	
	
	
	/**
	 * <p>Représente la longueur d'une voie</p>
	 * 
	 * @see Voie#getLongueur()
	 * @see Voie#setLongueur(String)
	 */
	private String longueur;
	
	
	
	/**
	 * <p>Représente la hauteur d'une voie</p>
	 * 
	 * @see Voie#getHauteur()
	 * @see Voie#setHauteur(String)
	 */
	private String hauteur;
	
	
	
	/**
	 * <p>Représente le nombre de point d'ancrage d'une voie</p>
	 * 
	 * @see Voie#getNbrPoint()
	 * @see Voie#setNbrPoint(String)
	 */
	private String nbrPoint;
	
	
	
	/**
	 * <p>Représente le type de point d'ancrage d'une voie</p>
	 * 
	 * @see Voie#getTypePoint()
	 * @see Voie#setTypePoint(String)
	 */
	private String typePoint;
	
	
	
	/**
	 * <p>Représente la remarque lié à la voie</p>
	 * 
	 * @see Voie#getRemarque()
	 * @see Voie#setRemarque(String)
	 */
	private String remarque;
	
	
	
	/**
	 * <p>Représente l'identifiant du secteur d'une voie</p>
	 * 
	 * @see Voie#getIdSecteur()
	 * @see Voie#setIdSecteur(int)
	 */
	private int idSecteur;
	
	
	
	/**
	 * <p>Getter du parametre 'idVoie'</p>
	 * 
	 * @return L'identifiant d'une voie
	 * 
	 * @see Voie#idVoie
	 * @see Voie#setIdVoie(int)
	 */
	public int getIdVoie() {
		return idVoie;
	}
	
	
	/**
	 * <p>Setter du parametre 'idVoie'</p>
	 * 
	 * @param idVoie L'identifiant d'une voie
	 * 
	 * @see Voie#idVoie
	 * @see Voie#getIdVoie()
	 */
	public void setIdVoie(int idVoie) {
		this.idVoie = idVoie;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'numero'</p>
	 * 
	 * @return Le numero d'une voie
	 * 
	 * @see Voie#numero
	 * @see Voie#setNumero(int)
	 */
	public int getNumero() {
		return numero;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'numero'</p>
	 * 
	 * @param numero Le numero d'une voie
	 * 
	 * @see Voie#numero
	 * @see Voie#getNumero()
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'nom'</p>
	 * 
	 * @return Le nom d'une voie
	 * 
	 * @see Voie#nom
	 * @see Voie#setNom(String)
	 */
	public String getNom() {
		return nom;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'nom'</p>
	 * 
	 * @param nom Le nom d'une voie
	 * 
	 * @see Voie#nom
	 * @see Voie#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'cotation'</p>
	 * 
	 * @return La cotation d'une voie
	 * 
	 * @see Voie#cotation
	 * @see Voie#setCotation(String)
	 */
	public String getCotation() {
		return cotation;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'cotation'</p>
	 * 
	 * @param cotation La cotation d'une voie
	 * 
	 * @see Voie#cotation
	 * @see Voie#getCotation()
	 */
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'longueur'</p>
	 * 
	 * @return La longueur d'une voie
	 * 
	 * @see Voie#longueur
	 * @see Voie#setLongueur(String)
	 */
	public String getLongueur() {
		return longueur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'longueur'</p>
	 * 
	 * @param longueur La longueur d'une voie
	 * 
	 * @see Voie#longueur
	 * @see Voie#getLongueur()
	 */
	public void setLongueur(String longueur) {
		this.longueur = longueur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'hauteur'</p>
	 * 
	 * @return La hauteur d'une voie
	 * 
	 * @see Voie#hauteur
	 * @see Voie#setHauteur(String)
	 */
	public String getHauteur() {
		return hauteur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'hauteur'</p>
	 * 
	 * @param hauteur La hauteur d'une voie
	 * 
	 * @see Voie#hauteur
	 * @see Voie#getHauteur()
	 */
	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'nbrPoint'</p>
	 * 
	 * @return Le nombre e point d'ancrage d'une voie
	 * 
	 * @see Voie#nbrPoint
	 * @see Voie#setNbrPoint(String)
	 */
	public String getNbrPoint() {
		return nbrPoint;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'nbrPoint'</p>
	 * 
	 * @param nbrPoint Le nombre de point d'ancrage d'une voie
	 * 
	 * @see Voie#nbrPoint
	 * @see Voie#getNbrPoint()
	 */
	public void setNbrPoint(String nbrPoint) {
		this.nbrPoint = nbrPoint;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'typePoint'</p>
	 * 
	 * @return Le type de point d'ancrage d'une voie
	 * 
	 * @see Voie#typePoint
	 * @see Voie#setTypePoint(String)
	 */
	public String getTypePoint() {
		return typePoint;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'typePoint'</p>
	 * 
	 * @param typePoint Le type de point d'ancrage d'une voie
	 * 
	 * @see Voie#typePoint
	 * @see Voie#getTypePoint()
	 */
	public void setTypePoint(String typePoint) {
		this.typePoint = typePoint;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'trmarque'</p>
	 * 
	 * @return La remarque d'une voie
	 * 
	 * @see Voie#remarque
	 * @see Voie#setRemarque(String)
	 */
	public String getRemarque() {
		return remarque;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'remarque'</p>
	 * 
	 * @param remarque La remarque d'une voie
	 * 
	 * @see Voie#remarque
	 * @see Voie#getRemarque()
	 */
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'idSecteur'</p>
	 * 
	 * @return L'identifiant de secteur d'une voie
	 * 
	 * @see Voie#idSecteur
	 * @see Voie#setIdSecteur(int)
	 */
	public int getIdSecteur() {
		return idSecteur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idSecteur'</p>
	 * 
	 * @param idSecteur L'identifiant de secteur d'une voie
	 * 
	 * @see Voie#idSecteur
	 * @see Voie#getIdSecteur()
	 */
	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}

}
