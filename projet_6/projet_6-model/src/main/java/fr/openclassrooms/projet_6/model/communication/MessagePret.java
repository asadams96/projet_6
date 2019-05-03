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
