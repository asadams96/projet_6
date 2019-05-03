package fr.openclassrooms.projet_6.model.topo;

import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Représente un topo<p>
 * <br />
 * <p>Est composé:</p>
 * <u>
 * 		<li>d'un identifiant => idTopo</li>
 * 		<li>d'un titre => titre</li>
 * 		<li>d'un auteur => auteur</li>
 * 		<li>d'une année d'édition => annee</li>
 * 		<li>d'une description => description</li>
 * 		<li>d'un chemin vers l'image du topo => urlImage</li>
 * </ul>
 * 
 * @see Topo#idTopo 
 * @see Topo#getIdTopo()
 * @see Topo#setIdTopo(int)
 * @see Topo#titre
 * @see Topo#getTitre()
 * @see Topo#setTitre(String)
 * @see Topo#auteur
 * @see Topo#getAuteur()
 * @see Topo#setAuteur(String)
 * @see Topo#annee
 * @see Topo#getAnnee()
 * @see Topo#setAnnee(String)
 * @see Topo#description
 * @see Topo#getDescription()
 * @see Topo#setDescription(String)
 * @see Topo#urlImage
 * @see Topo#getUrlImage()
 * @see Topo#setUrlImage(String)
 * @see Utilisateur
 * @see Voie
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
public class Topo {

	
	
	/**
	 * <p>Représente l'identifiant d'un topo</p>
	 * 
	 * @see Topo#getIdTopo()
	 * @see Topo#setIdTopo(int)
	 */
	private int idTopo;
	
	
	
	/**
	 * <p>Représente le titre d'un topo</p>
	 * 
	 * @see Topo#getTitre()
	 * @see Topo#setTitre(String)
	 */
	private String titre;
	
	
	
	/**
	 * <p>Représente l'auteur d'un topo</p>
	 * 
	 * @see Topo#getAuteur()
	 * @see Topo#setAuteur(String)
	 */
	private String auteur;
	
	
	
	/**
	 * <p>Représente l'année d'un topo</p>
	 * 
	 * @see Topo#getAnnee()
	 * @see Topo#setAnnee(String)
	 */
	private String annee;
	
	
	
	/**
	 * <p>Représente la description d'un topo</p>
	 * 
	 * @see Topo#getDescription()
	 * @see Topo#setDescription(String)
	 */
	private String description;
	
	
	
	/**
	 * <p>Représente le chemin de l'image d'un topo</p>
	 * 
	 * @see Topo#getUrlImage()
	 * @see Topo#setUrlImage(String)
	 */
	private String urlImage;
	
	
	
	/**
	 * <p>Constructeur par défaut</p>
	 * 
	 * @see Topo#Topo(int)
	 */
	public Topo() {}
	
	
	
	/**
	 * <p>Constructeur avec paramètre</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * 
	 * @see Topo#Topo()
	 * @see Topo#idTopo
	 */
	public Topo(int idTopo) {
		this.idTopo = idTopo;
	}



	/**
	 * <p>Getter du parametre 'idTopo'</p>
	 * 
	 * @return L'identifiant d'un topo
	 * 
	 * @see Topo#getIdTopo()
	 * @see Topo#setIdTopo(int)
	 */
	public int getIdTopo() {
		return idTopo;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'idTopo'</p>
	 * 
	 * @param nom L'identifiant d'un topo
	 * 
	 * @see Topo#nom
	 * @see Topo#getNom()
	 */
	public void setIdTopo(int idTopo) {
		this.idTopo = idTopo;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'titre'</p>
	 * 
	 * @return Le titre d'un topo
	 * 
	 * @see Topo#titre
	 * @see Topo#setTitre(String)
	 */
	public String getTitre() {
		return titre;
	}
	
	
	
	/**
	 * <p>Setter du parametre 'titre'</p>
	 * 
	 * @param nom Le titre d'un topo
	 * 
	 * @see Topo#titre
	 * @see Topo#getTitre()
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'auteur'</p>
	 * 
	 * @return L' auteur d'un topo
	 * 
	 * @see Topo#auteur
	 * @see Topo#setAuteur(String)
	 */
	public String getAuteur() {
		return auteur;
	}
	
	
	
	/**
	 * <p>Setter du parametre'auteur'</p>
	 * 
	 * @param nom L' auteur d'un topo
	 * 
	 * @see Topo#auteur
	 * @see Topo#getAuteur()
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'annee'</p>
	 * 
	 * @return L'annee d'un topo
	 * 
	 * @see Topo#annee
	 * @see Topo#setAnnee(String)
	 */
	public String getAnnee() {
		return annee;
	}
	
	
	
	/**
	 * <p>Setter du parametre'annee'</p>
	 * 
	 * @param nom L'annee d'un topo
	 * 
	 * @see Topo#annee
	 * @see Topo#getAuteur()
	 */
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'description'</p>
	 * 
	 * @return La description d'un topo
	 * 
	 * @see Topo#description
	 * @see Topo#setDescription(String)
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	/**
	 * <p>Setter du parametre'description'</p>
	 * 
	 * @param nom La description d'un topo
	 * 
	 * @see Topo#description
	 * @see Topo#getDescription()
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	/**
	 * <p>Getter du parametre 'urlImage'</p>
	 * 
	 * @return Le chemin de l'image d'un topo
	 * 
	 * @see Topo#urlImage
	 * @see Topo#setUrlImage(String)
	 */
	public String getUrlImage() {
		return urlImage;
	}
	
	
	
	/**
	 * <p>Setter du parametre'urlImage'</p>
	 * 
	 * @param nom Le chemin de l'image d'un topo
	 * 
	 * @see Topo#urlImage
	 * @see Topo#getUrlImage()
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
