package fr.openclassrooms.projet_6.model.pret;

import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Représente un pret<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idPret</li>
 * 		<li>d'une date => date</li>
 * 		<li>d'un état => etat</li>
 * 		<li>d'un utilisateur (à l'origine de la demande de prêt) => utilisateur</li>
 * 		<li>du topo conerné par le prêt => topo</li>
 * 		<li>du proprietaire du topo => proprietaire</li>
 * </ul>
 * 
 * @see Pret#idPret
 * @see Pret#getIdPret()
 * @see Pret#setIdPret(int)
 * @see Pret#date
 * @see Pret#getDate()
 * @see Pret#setDate(String)
 * @see Pret#etat
 * @see Pret#getEtat()
 * @see Pret#setEtat(String)
 * @see Pret#utilisateur
 * @see Pret#getUtilisateur()
 * @see Pret#setUtilisateur(Utilisateur)
 * @see Pret#topo
 * @see Pret#getTopo()
 * @see Pret#setTopo(Topo)
 * @see Pret#proprietaire
 * @see Pret#getProprietaire()
 * @see Pret#setProprietaire(Utilisateur)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
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
public class Pret {
	
	
	
	/**
	 * <p>Représente l'identifiant d'un prêt</p>
	 * 
	 * @see Pret#getIdPret()
	 * @see Pret#setIdPret(int)
	 */
	private int idPret;
	
	
	
	/**
	 * <p>Représente la date d'un prêt</p>
	 * 
	 * @see Pret#getDate()
	 * @see Pret#setDate(String)
	 */
	private String date;
	
	
	
	/**
	 * <p>Représente l'état d'un prêt</p>
	 * 
	 * @see Pret#getEtat()
	 * @see Pret#setEtat(String)
	 */
	private String etat;
	
	
	
	/**
	 * <p>Représente l'utilisateur à l'origine du prêt</p>
	 * 
	 * @see Pret#getUtilisateur()
	 * @see Pret#setUtilisateur(Utilisateur)
	 */
	private Utilisateur utilisateur;
	
	
	
	/**
	 * <p>Représente le topo associé au prêt</p>
	 * 
	 * @see Pret#getTopo()
	 * @see Pret#setTopo(Topo)
	 */
	private Topo topo;
	
	
	
	/**
	 * <p>Représente le proprietaire du topo associé au prêt</p>
	 * 
	 * @see Pret#getProprietaire()
	 * @see Pret#setProprietaire(Utilisateur)
	 */
	private Utilisateur proprietaire;
	
	
	
	/**
	 * <p>Contructeur par défaut</p>
	 * 
	 * @see Pret#Pret(int)
	 */
	public Pret() {}
	
	
	
	/**
	 * <p>Constructeur avec paramètre</p>
	 * 
	 * @param idPret L'identifiant d'un pret
	 * 
	 * @see Pret#idPret
	 * @see Pret#Pret()
	 */
	public Pret(int idPret) {
		this.idPret = idPret;
	}



	/**
	 * <p>Getter du parametre 'idPret'</p>
	 * 
	 * @return L'identifiant d'un prêt
	 * 
	 * @see Pret#idPret
	 * @see Pret#setIdPret(int)
	 */
	public int getIdPret() {
		return idPret;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idPret'</p>
	 * 
	 * @param idPret L'identifiant d'un prêt
	 * 
	 * @see Pret#idPret
	 * @see Pret#getIdPret()
	 */
	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'date'</p>
	 * 
	 * @return La date d'un prêt
	 * 
	 * @see Pret#date
	 * @see Pret#setDate(String)
	 */
	public String getDate() {
		return date;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'date'</p>
	 * 
	 * @param date La date d'un prêt
	 * 
	 * @see Pret#date
	 * @see Pret#getDate()
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'etat'</p>
	 * 
	 * @return L'état d'un prêt
	 * 
	 * @see Pret#etat
	 * @see Pret#setEtat(String)
	 */
	public String getEtat() {
		return etat;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'etat'</p>
	 * 
	 * @param etat L'état d'un prêt
	 * 
	 * @see Pret#etat
	 * @see Pret#getEtat()
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'utilisateur'</p>
	 * 
	 * @return L'utilisateur à l'origine du prêt
	 * 
	 * @see Pret#utilisateur
	 * @see Pret#setUtilisateur(Utilisateur)
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'utilisateur'</p>
	 * 
	 * @param utilisateur L'utilisateur à l'origine du prêt
	 * 
	 * @see Pret#utilisateur
	 * @see Pret#getUtilisateur()
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'topo'</p>
	 * 
	 * @return Le topo associé au prêt
	 * 
	 * @see Pret#topo
	 * @see Pret#setTopo(Topo)
	 */
	public Topo getTopo() {
		return topo;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'topo'</p>
	 * 
	 * @param topo Le topo associé au prêt
	 * 
	 * @see Pret#topo
	 * @see Pret#getTopo()
	 */
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'proprietaire'</p>
	 * 
	 * @return Le proprietaire du topo aoosicé au prêt
	 * 
	 * @see Pret#proprietaire
	 * @see Pret#setProprietaire(Utilisateur)
	 */
	public Utilisateur getProprietaire() {
		return proprietaire;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'proprietaire'</p>
	 * 
	 * @param proprietaire Le proprietaire du topo aoosicé au prêt
	 * 
	 * @see Pret#proprietaire
	 * @see Pret#getProprietaire()
	 */
	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}
}
