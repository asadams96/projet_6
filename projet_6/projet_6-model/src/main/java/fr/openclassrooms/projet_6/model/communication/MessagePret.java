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
 * <p>Représente un message de pret<p>
 * <p>Hérite de la classe 'Message'</p>
 * <br />
 * <p>Est composé:</p>
 * <ul>
 * 		<li>des paramètres de la classe 'Message'</li>
 * 		<li>du prêt associé au message => pret</li>
 * </ul>
 * 
 * @see MessagePret#pret
 * @see MessagePret#getPret()
 * @see MessagePret#setPret(Pret)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
 * @see Pret
 * @see TamponProprietaireTopo
 * @see TamponSiteTopo
 * @see Message
 * @see CommentaireTopo
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class MessagePret extends Message {
	
	
	
	/**
	 * <p>Représente le prêt associé au message</p>
	 * 
	 * @see MessagePret#getPret()
	 * @see MessagePret#setPret(Pret)
	 */
	private Pret pret;

	
	
	/**
	 * <p>Constructeur avec paramètres</p>
	 * 
	 * @param idMessage L'identifiant du message
	 * @param date La date du message
	 * @param contenu Le contenu du message
	 * @param utilisateur L'auteur du message
	 * @param pret Le pret associé au message
	 * 
	 * @see MessagePret#MessagePret()
	 * @see MessagePret#pret
	 * @see Message#setAuteur(Utilisateur)
	 * @see Message#setIdMessage(int)
	 * @see Message#setDate(String)
	 * @see Message#setContenu(String)
	 */
	public MessagePret(int idMessage, String date, String contenu, Utilisateur utilisateur, Pret pret) {
		this.pret = pret;
		this.setIdMessage(idMessage);
		this.setDate(date);
		this.setContenu(contenu);
		this.setAuteur(utilisateur);
	}


	
	/**
	 * <p>Constructeur par défaut</p>
	 * 
	 * @see MessagePret#MessagePret(int, String, String, Utilisateur, Pret)
	 */
	public MessagePret() {}



	/**
	 * <p>Getter du parametre 'pret'</p>
	 * 
	 * @return Le prêt associé au message
	 * 
	 * @see MessagePret#pret
	 * @see MessagePret#setPret(Pret)
	 */
	public Pret getPret() {
		return pret;
	}

	
	
	/**
	 * <p>Setter du parametre 'pret'</p>
	 * 
	 * @param pret Le prêt associé au message
	 * 
	 * @see MessagePret#pret
	 * @see MessagePret#getPret()
	 */
	public void setPret(Pret pret) {
		this.pret = pret;
	}
}
