package fr.openclassrooms.projet_6.model.liaison;

import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Représente la liaison entre un site et un topo<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un site=> site</li>
 * 		<li>d'un topo=> topo</li>
 * </ul>
 * 
 * @see TamponSiteTopo#site
 * @see TamponSiteTopo#getSite()
 * @see TamponSiteTopo#setSite(Site)
 * @see TamponSiteTopo#topo
 * @see TamponSiteTopo#getTopo()
 * @see TamponSiteTopo#setTopo(Topo)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
 * @see Pret
 * @see TamponProprietaireTopo
 * @see Message
 * @see MessagePret
 * @see CommentaireTopo
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponSiteTopo {
	
	
	
	/**
	 * <p>Représente un site</p>
	 * 
	 * @see TamponSiteTopo#getSite()
	 * @see TamponSiteTopo#setSite(Site)
	 */
	private Site site;
	
	
	
	/**
	 * <p>Représente un topo</p>
	 * 
	 * @see TamponSiteTopo#getTopo()
	 * @see TamponSiteTopo#setTopo(Topo)
	 */
	private Topo topo;
	
	
	
	/**
	 * <p>Getter du parametre 'site'</p>
	 * 
	 * @return Un site
	 * 
	 * @see TamponSiteTopo#site
	 * @see TamponSiteTopo#setSite(Site)
	 */
	public Site getSite() {
		return site;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'site'</p>
	 * 
	 * @param site Un site
	 * 
	 * @see TamponSiteTopo#site
	 * @see TamponSiteTopo#getSite()
	 */
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'topo'</p>
	 * 
	 * @return Un topo
	 * 
	 * @see TamponSiteTopo#topo
	 * @see TamponSiteTopo#setTopo(Topo)
	 */
	public Topo getTopo() {
		return topo;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'topo'</p>
	 * 
	 * @param topo Un topo
	 * 
	 * @see TamponSiteTopo#topo
	 * @see TamponSiteTopo#getTopo()
	 */
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
}
