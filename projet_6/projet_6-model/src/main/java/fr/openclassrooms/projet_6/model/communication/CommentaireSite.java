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
 * <p>Représente un commentaire de site<p>
 * <p>Hérite de la classe 'Message'</p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>des paramètres de la classe 'Message'</li>
 * 		<li>du site associé au commentaire => site</li>
 * </ul>
 * 
 * @see CommentaireSite#site
 * @see CommentaireSite#getSite()
 * @see CommentaireSite#setSite(Site)
 * @see Utilisateur
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
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireSite extends Message{
	
	
	
	/**
	 * <p>Représente Le site associé au message</p>
	 * 
	 * @see CommentaireSite#getSite()
	 * @see CommentaireSite#setSite(Site)
	 */
	private Site site;

	
	
	/**
	 * <p>Getter du parametre 'site'</p>
	 * 
	 * @return Le site associé au message
	 * 
	 * @see CommentaireSite#site
	 * @see CommentaireSite#setSite(Site)
	 */
	public Site getSite() {
		return site;
	}

	
	
	/**
	 * <p>Setter du parametre 'site'</p>
	 * 
	 * @param site Le site associé au message
	 * 
	 * @see CommentaireSite#site
	 * @see CommentaireSite#getSite()
	 */
	public void setSite(Site site) {
		this.site = site;
	}

}
