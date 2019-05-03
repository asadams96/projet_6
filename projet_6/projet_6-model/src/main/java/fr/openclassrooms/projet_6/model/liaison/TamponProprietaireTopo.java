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
 * <p>Représente la liaison entre un utilsateur, un topo et une quantité<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un utilisateur => proprietaire</li>
 * 		<li>d'un topo => topo</li>
 * 		<li>d'une quantité => quantite</li>
 * </ul>
 * 
 * @see TamponProprietaireTopo#proprietaire
 * @see TamponProprietaireTopo#getProprietaire()
 * @see TamponProprietaireTopo#setProprietaire(Utilisateur)
 * @see TamponProprietaireTopo#topo
 * @see TamponProprietaireTopo#getTopo()
 * @see TamponProprietaireTopo#setTopo(Topo)
 * @see TamponProprietaireTopo#quantite
 * @see TamponProprietaireTopo#getQuantite()
 * @see TamponProprietaireTopo#setQuantite(int)
 * @see Utilisateur
 * @see Topo
 * @see Voie
 * @see Site
 * @see Secteur
 * @see Pret
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
public class TamponProprietaireTopo {
	
	
	
	/**
	 * <p>Représente un utilisateur</p>
	 * 
	 * @see TamponProprietaireTopo#getProprietaire()
	 * @see TamponProprietaireTopo#setProprietaire(Utilisateur)
	 * @see Utilisateur
	 */
	private Utilisateur proprietaire;
	
	
	
	/**
	 * <p>Représente un topo</p>
	 * 
	 * @see TamponProprietaireTopo#getTopo()
	 * @see TamponProprietaireTopo#setTopo(Topo)
	 * @see Topo
	 */
	private Topo topo;
	
	
	
	/**
	 * <p>Représente la quantité de topo</p>
	 * 
	 * @see TamponProprietaireTopo#getQuantite()
	 * @see TamponProprietaireTopo#setQuantite(int)
	 */
	private int quantite;
	
	
	
	/**
	 * <p>Getter du parametre 'proprietaire'</p>
	 * 
	 * @return Un utilisateur
	 * 
	 * @see TamponProprietaireTopo#proprietaire
	 * @see TamponProprietaireTopo#setProprietaire(Utilisateur)
	 * @see Utilisateur
	 */
	public Utilisateur getProprietaire() {
		return proprietaire;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'proprietaire'</p>
	 * 
	 * @param proprietaire Un utilisateur
	 * 
	 * @see TamponProprietaireTopo#proprietaire
	 * @see TamponProprietaireTopo#getProprietaire()
	 * @see Utilisateur
	 */
	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'topo'</p>
	 * 
	 * @return Un topo
	 * 
	 * @see TamponProprietaireTopo#topo
	 * @see TamponProprietaireTopo#setTopo(Topo)
	 * @see Topo
	 */
	public Topo getTopo() {
		return topo;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'topo'</p>
	 * 
	 * @param topo Un topo
	 * 
	 * @see TamponProprietaireTopo#topo
	 * @see TamponProprietaireTopo#getTopo()
	 * @see Topo
	 */
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'quantite'</p>
	 * 
	 * @return La quantité de topo
	 * 
	 * @see TamponProprietaireTopo#quantite
	 * @see TamponProprietaireTopo#setQuantite(int)
	 */
	public int getQuantite() {
		return quantite;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'quantite'</p>
	 * 
	 * @param quantite Représente la quantité de topo
	 * 
	 * @see TamponProprietaireTopo#quantite
	 * @see TamponProprietaireTopo#getQuantite()
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
