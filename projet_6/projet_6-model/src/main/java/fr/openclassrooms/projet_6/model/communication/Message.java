package fr.openclassrooms.projet_6.model.communication;

import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>Représente un message<p>
 * <p>Classe mère de :</p>
 * <ul>
 * 		<li>'MessagePret'</li>
 * 		<li>'CommentaireTopo'</li>
 * 		<li>'CommentaireSite'</li>
 * </ul>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idMessage</li>
 * 		<li>d'une date => date</li>
 * 		<li>d'un contenu => contenu</li>
 * 		<li>d'un auteur => </li>
 * </ul>
 * 
 * @see Message#idMessage
 * @see Message#getIdMessage()
 * @see Message#setIdMessage(int)
 * @see Message#date
 * @see Message#getDate()
 * @see Message#setDate(String)
 * @see Message#contenu
 * @see Message#getContenu()
 * @see Message#setContenu(String)
 * @see Message#auteur
 * @see Message#getAuteur()
 * @see Message#setAuteur(Utilisateur)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
 * @see Pret
 * @see TamponProprietaireTopo
 * @see TamponSiteTopo
 * @see MessagePret
 * @see CommentaireTopo
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class Message {
	
	
	
	/**
	 * <p>Représente l'identifiant d'un message</p>
	 * 
	 * @see Message#getIdMessage()
	 * @see Message#setIdMessage(int)
	 */
	private int idMessage;
	
	
	
	/**
	 * <p>Représente la date d'un message</p>
	 * 
	 * @see Message#getDate()
	 * @see Message#setDate(String)
	 */
	private String date;
	
	
	
	/**
	 * <p>Représente le contenu d'un message</p>
	 * 
	 * @see Message#getContenu()
	 * @see Message#setContenu(String)
	 */
	private String contenu;
	
	
	
	/**
	 * <p>Représente l'auteur d'un message</p>
	 * 
	 * @see Message#getAuteur()
	 * @see Message#setAuteur(Utilisateur)
	 */
	private Utilisateur auteur;
	
	
	
	/**
	 * <p>Getter du parametre 'idMessage'</p>
	 * 
	 * @return L'identifiant d'un message
	 * 
	 * @see Message#idMessage
	 * @see Message#setIdMessage(int)
	 */
	public int getIdMessage() {
		return idMessage;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idMessage'</p>
	 * 
	 * @param idMessage L'identifiant d'un message
	 * 
	 * @see Message#idMessage
	 * @see Message#getIdMessage()
	 */
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'date'</p>
	 * 
	 * @return La date d'un message
	 * 
	 * @see Message#date
	 * @see Message#setDate(String)
	 */
	public String getDate() {
		return date;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'date'</p>
	 * 
	 * @param date La date d'un message
	 * 
	 * @see Message#date
	 * @see Message#getDate()
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'contenu'</p>
	 * 
	 * @return Le contenu d'un message
	 * 
	 * @see Message#contenu
	 * @see Message#setContenu(String)
	 */
	public String getContenu() {
		return contenu;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'contenu'</p>
	 * 
	 * @param contenu Le contenu d'un message
	 * 
	 * @see Message#contenu
	 * @see Message#getContenu()
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'auteur'</p>
	 * 
	 * @return L'auteur d'un message
	 * 
	 * @see Message#auteur
	 * @see Message#setAuteur(Utilisateur)
	 */
	public Utilisateur getAuteur() {
		return auteur;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'auteur'</p>
	 * 
	 * @param auteur L'auteur d'un message
	 * 
	 * @see Message#auteur
	 * @see Message#getAuteur()
	 */
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
}
