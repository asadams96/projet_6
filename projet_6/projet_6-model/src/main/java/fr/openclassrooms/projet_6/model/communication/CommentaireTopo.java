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
 * <p>Représente un commentaire de topo<p>
 * <p>Hérite de la classe 'Message'</p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>des  paramètres de la classe 'Message'</li>
 * 		<li>d'un topo associé au commentaire => topo</li>
 * </ul>
 * 
 * @see CommentaireTopo#topo
 * @see CommentaireTopo#getTopo()
 * @see CommentaireTopo#setTopo(Topo)
 * @see CommentaireTopo#CommentaireTopo(int, String, String, Utilisateur, Topo)
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
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireTopo extends Message {

	
	
	/**
	 * <p>Représente le topo associé au commentaire</p>
	 * 
	 * @see CommentaireTopo#getIdTopo()
	 * @see CommentaireTopo#setIdTopo(int)
	 */
	private Topo topo;
	
	
	
	/**
	 * <p>Constructeur par défaut</p>
	 * 
	 * @see CommentaireTopo#CommentaireTopo(int, String, String, Utilisateur, Topo)
	 */
	public CommentaireTopo() {}
	
	
	
	/**
	 * <p>Constructeur avec paramètres</p>
	 * 
	 * @param idMessage L'identifiant du commentaire
	 * @param date La date du commentaire
	 * @param contenu Le contenu du commentaire
	 * @param auteur L'auteur du commentaire
	 * @param topo Le topo associé au commentaire
	 * 
	 * @see Message#setIdMessage(int)
	 * @see Message#setDate(String)
	 * @see Message#setContenu(String)
	 * @see Message#setAuteur(Utilisateur)
	 * @see CommentaireTopo#topo
	 * @see CommentaireTopo#CommentaireTopo()
	 */
	public CommentaireTopo(int idMessage, String date, String contenu, Utilisateur auteur, Topo topo) {
		this.setIdMessage(idMessage);
		this.setDate(date);
		this.setContenu(contenu);
		this.setAuteur(auteur);
		this.topo = topo;
	}

	
	
	/**
	 * <p>Getter du parametre 'topo'</p>
	 * 
	 * @return Le topo associé au commentaire
	 * 
	 * @see CommentaireTopo#topo
	 * @see CommentaireTopo#setTopo(Topo)
	 */
	public Topo getTopo() {
		return topo;
	}

	
	
	/**
	 * <p>Setter du parametre 'topo'</p>
	 * 
	 * @param topo Le topo associé au commentaire
	 * 
	 * @see CommentaireTopo#topo
	 * @see CommentaireTopo#getTopo()
	 * @see CommentaireTopo#CommentaireTopo(int, String, String, Utilisateur, Topo)
	 */
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
}
