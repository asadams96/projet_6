package fr.openclassrooms.projet_6.webapp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;
import fr.openclassrooms.projet_6.webapp.bundle.ResourcesBundle;
import fr.openclassrooms.projet_6.webapp.interceptor.AuthentificationInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.EncodingInterceptor;



/**
 * <p>Classe action gérant la gestion des utilisateurs</p>
 * 
 * <p>Elle est implémenté de 8 actions :</p>
 * <ul>
 * 		<li>Afficher et gérer un formulaire d'inscription => doInscription()</li>
 * 		<li>Afficher et gérer un formulaire de connexion => doLogin()</li>
 * 		<li>Gérer un fla déconnexion d'un utilisateur => doLogout()</li>
 * 		<li>Afficher les détails d'un utilisateurs => doDetail();</li>
 * 		<li>Modifier l'adresse mail d'un utilisateur => doModifyMail()</li>
 * 		<li>Modifier le pseudo d'un utilisateur => doModifyPseudo()</li>
 * 		<li>Modifier la localisation d'un utilisateur => doModifLocalisation()</li>
 * 		<li>Modifier le mot de passe d'un utilisateur => doModifyPass()</li>
 * </ul>
 * 
 * <p>La méthode inputFormat(String) sert à formatter les saisis utilisateurs.</p>
 * 
 * <p>
 * 	La méthode validation(String) sert à vérifier que les entrées saisi par 
 * 	l'utilisateur respecte bien les contraintes défini dans cette même métode.
 * </p>
 * 
 * 
 * @see GestionUtilisateurAction#MIN_MAIL
 * @see GestionUtilisateurAction#MIN_NOM
 * @see GestionUtilisateurAction#MIN_PRENOM
 * @see GestionUtilisateurAction#MIN_CIVILITE
 * @see GestionUtilisateurAction#MIN_PSEUDO
 * @see GestionUtilisateurAction#MIN_PASS
 * @see GestionUtilisateurAction#MAX_MAIL
 * @see GestionUtilisateurAction#MAX_NOM
 * @see GestionUtilisateurAction#MAX_PRENOM
 * @see GestionUtilisateurAction#MAX_CIVILITE
 * @see GestionUtilisateurAction#MAX_PSEUDO
 * @see GestionUtilisateurAction#MAX_PASS
 * @see GestionUtilisateurAction#managerFactory
 * @see GestionUtilisateurAction#resourcesBundle
 * @see GestionUtilisateurAction#request
 * @see GestionUtilisateurAction#mail
 * @see GestionUtilisateurAction#pseudo
 * @see GestionUtilisateurAction#civilite
 * @see GestionUtilisateurAction#nom
 * @see GestionUtilisateurAction#prenom
 * @see GestionUtilisateurAction#localisation
 * @see GestionUtilisateurAction#pass
 * @see GestionUtilisateurAction#passBis
 * @see GestionUtilisateurAction#utilisateur
 * @see GestionUtilisateurAction#idUtilisateur
 * @see GestionUtilisateurAction#setManagerFactory(ManagerFactory)
 * @see GestionUtilisateurAction#setResourcesBundle(ResourcesBundle)
 * @see GestionUtilisateurAction#setServletRequest(HttpServletRequest)
 * @see GestionUtilisateurAction#setMail(String)
 * @see GestionUtilisateurAction#setPseudo(String)
 * @see GestionUtilisateurAction#setCivilite(String)
 * @see GestionUtilisateurAction#setNom(String)
 * @see GestionUtilisateurAction#setPrenom(String)
 * @see GestionUtilisateurAction#setLocalisation(String)
 * @see GestionUtilisateurAction#setPass(String)
 * @see GestionUtilisateurAction#setPassBis(String)
 * @see GestionUtilisateurAction#setIdUtilisateur(String)
 * @see GestionUtilisateurAction#getResourcesBundle()
 * @see GestionUtilisateurAction#getMail()
 * @see GestionUtilisateurAction#getPseudo()
 * @see GestionUtilisateurAction#getCivilite()
 * @see GestionUtilisateurAction#getNom()
 * @see GestionUtilisateurAction#getPrenom()
 * @see GestionUtilisateurAction#getLocalisation()
 * @see GestionUtilisateurAction#getUtilisateur()
 * @see GestionUtilisateurAction#getIdUtilisateur()
 * @see GestionUtilisateurAction#doInscription()
 * @see GestionUtilisateurAction#doLogin()
 * @see GestionUtilisateurAction#doLogout()
 * @see GestionUtilisateurAction#doDetail()
 * @see GestionUtilisateurAction#doModifyMail()
 * @see GestionUtilisateurAction#doModifyPseudo()
 * @see GestionUtilisateurAction#doModifyLocalisation()
 * @see GestionUtilisateurAction#doModifyPass()
 * @see GestionUtilisateurAction#validation(String, int, int)
 * @see GestionUtilisateurAction#inputFormat(String)
 * @see UtilisateurManager
 * @see ResourcesBundle
 * @see GestionPretAction
 * @see GestionSiteAction
 * @see GestionTopoAction
 * @see AuthentificationInterceptor
 * @see EncodingInterceptor
 * @see Topo
 * @see Message
 * @see Site
 * @see CommentaireTopo
 * @see ManagerFactory
 * @see HttpServletRequest
 * @see ServletRequestAware
 * @see ActionSupport
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class GestionUtilisateurAction extends ActionSupport implements ServletRequestAware {

	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'mail'</p>
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_MAIL = 10;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'nom'</p>
	 * 
	 * @see GestionUtilisateurAction#nom
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_NOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'prenom'</p>
	 * 
	 * @see GestionUtilisateurAction#prenom
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_PRENOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'civilite'</p>
	 * 
	 * @see GestionUtilisateurAction#civilite
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_CIVILITE = 1;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'pseudo'</p>
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_PSEUDO = 5;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour les paramètres 'pass'et 'pasBis'</p>
	 * 
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#passBis
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MIN_PASS = 8;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'mail'</p>
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_MAIL = 50;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'nom'</p>
	 * 
	 * @see GestionUtilisateurAction#nom
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_NOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'prenom'</p>
	 * 
	 * @see GestionUtilisateurAction#prenom
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_PRENOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'civilite'</p>
	 * 
	 * @see GestionUtilisateurAction#civilite
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_CIVILITE = 10;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pseudo'</p>
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_PSEUDO = 20;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pass'</p>
	 * 
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 */
	private final int MAX_PASS = 30;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ManagerFactory'</p>
	 * 
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doLogin()
	 * @see GestionUtilisateurAction#doLogout()
	 * @see GestionUtilisateurAction#doDetail()
	 * @see GestionUtilisateurAction#doModifyDetail()
	 * @see GestionUtilisateurAction#setManagerFactory(ManagerFactory)
	 * @see ManagerFactory
	 */
	private ManagerFactory managerFactory;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ResourcesBundle'</p>
	 * 
	 * @see GestionUtilisateurAction#doInscription
	 * @see GestionUtilisateurAction#getResourcesBundle()
	 * @see GestionUtilisateurAction#setResourcesBundle(ResourcesBundle)
	 * @see ResourcesBundle
	 */
	private ResourcesBundle resourcesBundle;
	
	
	
	/**
	 * <p>Objet servant à stocker la requête en cours</p>
	 * 

	 * @see GestionUtilisateurAction#doLogin
	 * @see GestionUtilisateurAction#doLogout
	 * @see GestionUtilisateurAction#setServletRequest(HttpServletRequest) 
	 * @see HttpServletRequest
	 */
	private HttpServletRequest request;
	
	
	
	// ------------------------ Elements en entrée et sortie ------------------------
	
	
	/**
	* <p>Objet servant à stocker l'adresse mail défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getMail()
	* @see GestionUtilisateurAction#setMail(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doLogin()
	* @see GestionUtilisateurAction#doDetail()
	* @see GestionUtilisateurAction#doModifyMail()
	*/
	private String mail;
	
	
	
	/**
	* <p>Objet servant à stocker le pseudo défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getPseudo()
	* @see GestionUtilisateurAction#setPseudo(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doDetail()
	* @see GestionUtilisateurAction#doModifyPseudo()
	*/
	private String pseudo;
	
	
	
	/**
	* <p>Objet servant à stocker la civilite défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getCivilite()
	* @see GestionUtilisateurAction#setCivilite(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doDetail()
	*/
	private String civilite;
	
	
	
	/**
	* <p>Objet servant à stocker le nom défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getNom()
	* @see GestionUtilisateurAction#setNom(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doDetail()
	*/
	private String nom;
	
	
	
	/**
	* <p>Objet servant à stocker le prenom défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getPrenom()
	* @see GestionUtilisateurAction#setPrenom(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doDetail()
	*/
	private String prenom;
	
	
	
	/**
	* <p>Objet servant à stocker la localisation défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#getLocalisation()
	* @see GestionUtilisateurAction#setLocalisation(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doDetail()
	* @see GestionUtilisateurAction#doModifyLocalisation()
	*/
	private String localisation;
	
	
	
	/**
	* <p>Objet servant à stocker le mot de passe défini par l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#setPass(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doLogin()
	* @see GestionUtilisateurAction#doModifyPass()
	*/
	private String pass;
	
	
	
	/**
	* <p>Objet servant à stocker la vérification de mot de passe de l'utilisateur</p>
	* 
	* @see GestionUtilisateurAction#setPassBis(String)(String)
	* @see GestionUtilisateurAction#doInscription()
	* @see GestionUtilisateurAction#doModifyPass()
	*/
	private String passBis;
	
	
	
	// ------------------------ Elements en sortie ------------------------	
	
	
	
	/**
	* <p>Objet servant à stocker une instance de la classe 'Utilisateur'</p>
	* 
	* @see GestionUtilisateurAction#setUtilisateur(Utilisateur)
	* @see GestionUtilisateurAction#doDetail()
	* @see GestionUtilisateurAction#doLogin()
	*/
	private Utilisateur utilisateur;
	
	
	
	/**
	 * <p>Objet servant à stocker l'identifiant d'un utilisateur</p>
	 * 
	 * @see GestionUtilisateurAction#setIdUtilisateur(String)
	 * @see GestionUtilisateurAction#doDetail()
	 * @see GestionUtilisateurAction#doModifyMail()
	 * @see GestionUtilisateurAction#doModifyPseudo()
	 * @see GestionUtilisateurAction#doModifyLocalisation()
	 * @see GestionUtilisateurAction#doModifyPass()
	 * 
	 */
	private String idUtilisateur;
	
	
	
	// --------------------------------- Setters ---------------------------------

	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'managerFactory'</p>
	 * 
	 * @see GestionUtilisateurAction#managerFactory
	 * @see ManagerFactory
	 */
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'resourcesBundle'</p>
	 * 
	 * @see GestionSiteAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public void setResourcesBundle(ResourcesBundle resourcesBundle) {
		this.resourcesBundle = resourcesBundle;
	}
	
	
	
	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @see GestionUtilisateurAction#request
	 * @see ServletRequestAware
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	
	/**
	 * <p>
	 * 	Setter servant au vues 'connexion.jsp', 'inscription.jsp',
	 * 	'profil.jsp' pour définir l'adresse mail saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param mail L'adresse mail saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setMail(String mail) {
		this.mail = this.inputFormat(mail);
	}



	/**
	 * <p>
	 * 	Setter servant au vues 'inscription.jsp', 
	 * 	'profil.jsp' pour définir le pseudo saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param pseudo Le pseudo saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = this.inputFormat(pseudo);
	}


	/**
	 * <p>
	 * 	Setter servant à la vue 'inscription.jsp' 
	 * 	pour définir la civilité saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param civilite La civilité saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#civilite
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setCivilite(String civilite) {
		this.civilite = this.inputFormat(civilite);
	}



	/**
	 * <p>
	 * 	Setter servant à la vue 'inscription.jsp' 
	 * 	pour définir le nom saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param nom Le nom saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#nom
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setNom(String nom) {
		this.nom = this.inputFormat(nom);
	}
	
	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'inscription.jsp' 
	 * 	pour définir le prenom saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param prenom Le prenom saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#prenom
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setPrenom(String prenom) {
		this.prenom = this.inputFormat(prenom);
	}


	
	/**
	 * <p>
	 * 	Setter servant au vues 'inscription.jsp', 
	 * 	'profil.jsp' pour définir la localisation saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param localisation La localisation choisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#localisation
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setLocalisation(String localisation) {
		this.localisation = this.inputFormat(localisation);
	}



	/**
	 * <p>
	 * 	Setter servant au vues 'connexion.jsp', 'inscription.jsp',
	 * 	'profil.jsp' pour définir le mot de passe saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param pass Le mot de passe saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


	
	/**
	 * <p>
	 * 	Setter servant au vues 'connexion.jsp', 'inscription.jsp', 'profil.jsp' 
	 * 	pour définir la confirmation de mot de passe saisi par l'utilisateur.
	 * </p>
	 * 
	 * @param pass Le mot de passe saisi par l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#passBis
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setPassBis(String passBis) {
		this.passBis = passBis;
	}
	
	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'profil.jsp' pour définir 
	 * 	l'identifiant de l'utilisateur qui modifie ses informations.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * 
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#inputFormat(String)
	 */
	public void setIdUtilisateur(String idUtilisateur) {
			this.idUtilisateur = this.inputFormat(idUtilisateur);		
		
	}
	
	
	
	// --------------------------------- Getters ---------------------------------
	


	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#resourcesBundle
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doDetail()
	 * @see ResourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer le paramètre 'mail' depuis les vues 'inscription.jsp', 'profil.jsp', 'connexion.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doDetail()
	 * @see @see GestionUtilisateurAction#doLogin()
	 */
	public String getMail() {
		return mail;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'pseudo' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doDetail()
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'civilite' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#civilite
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getCivilite() {
		return civilite;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'nom' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#nom
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'prenom' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#prenom
	 * @see GestionUtilisateurAction#doInscription()
	 */
	public String getPrenom() {
		return prenom;
	}


	
	/**
	 * <p>Getter permettant de récupérer le paramètre 'localisation' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#localisation
	 * @see GestionUtilisateurAction#doInscription()
	 * @see GestionUtilisateurAction#doDetail()
	 */
	public String getLocalisation() {
		return localisation;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer une instance de la classe Utilisateur depuis la vue 'profil.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#utilisateur
	 * @see GestionUtilisateurAction#doDetail()
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	

	/**
	 * <p>Getter permettant de récupérer l'identifiant d'un Utilisateur depuis la vue 'profil.jsp'</p>
	 * 
	 * @see GestionUtilisateurAction#utilisateur
	 * @see GestionUtilisateurAction#doDetail()
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}
	
	
	
	// --------------------------------- Methodes ---------------------------------
	

	/**
	 * <p>Méthode permettant à l'utilisateur de s'inscrire</p>
	 * 
	 * @return Retourne le résultat de la méthode : 'success' / 'input' / 'error'
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#civilite
	 * @see GestionUtilisateurAction#nom
	 * @see GestionUtilisateurAction#prenom
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#passBis
	 * @see GestionUtilisateurAction#localisation
	 * @see GestionUtilisateurAction#MIN_CIVILITE
	 * @see GestionUtilisateurAction#MAX_CIVILITE
	 * @see GestionUtilisateurAction#MIN_MAIL
	 * @see GestionUtilisateurAction#MAX_MAIL
	 * @see GestionUtilisateurAction#MIN_NOM
	 * @see GestionUtilisateurAction#MAX_NOM
	 * @see GestionUtilisateurAction#MIN_PRENOM
	 * @see GestionUtilisateurAction#MAX_PRENOM
	 * @see GestionUtilisateurAction#MIN_PSEUDO
	 * @see GestionUtilisateurAction#MAX_PSEUDO
	 * @see GestionUtilisateurAction#MIN_PASS
	 * @see GestionUtilisateurAction#MAX_PASS
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 * @see GestionUtilisateurAction#resourcesBundle
	 * @see GestionUtilisateurAction#managerFactory
	 * @see UtilisateurManager
	 */
	public String doInscription() {
		
		String vResult = ActionSupport.INPUT;
		Boolean fieldError = false;
		
		if(mail != null && civilite != null && nom != null && prenom != null && pseudo != null && pass != null && passBis != null && localisation != null) {
			if(mail.isEmpty() || !this.validation(mail, MIN_MAIL, MAX_MAIL)) {
				fieldError = true;
				this.addFieldError("mail", "Le champs est requis et doit être compris entre "+MIN_MAIL+" et "+MAX_MAIL+" caractères.");
			}
			if(civilite.isEmpty() || !this.validation(civilite, MIN_CIVILITE, MAX_CIVILITE)) {
				fieldError = true;
				this.addFieldError("civilite", "Le champs est requis et doit être compris entre "+MIN_CIVILITE+" et "+MAX_CIVILITE+" caractères.");
			}
			if(nom.isEmpty() || !this.validation(nom, MIN_NOM, MAX_NOM)) {
				fieldError = true;
				this.addFieldError("nom", "Le champs est requis et doit être compris entre "+MIN_NOM+" et "+MAX_NOM+" caractères.");
			}
			if(prenom.isEmpty() || !this.validation(prenom, MIN_PRENOM, MAX_PRENOM)) {
				fieldError = true;
				this.addFieldError("prenom", "Le champs est requis et doit être compris entre "+MIN_PRENOM+" et "+MAX_PRENOM+" caractères.");
			}
			if(pseudo.isEmpty() || !this.validation(pseudo, MIN_PSEUDO, MAX_PSEUDO)) {
				fieldError = true;
					this.addFieldError("pseudo", "Le champs est requis et doit être compris entre "+MIN_PSEUDO+" et "+MAX_PSEUDO+" caractères.");
			}
			if(pass.isEmpty() || !this.validation(pass, MIN_PASS, MAX_PASS)) {
				fieldError = true;
				this.addFieldError("pass", "Le champs est requis et doit être compris entre "+MIN_PASS+" et "+MAX_PASS+" caractères.");
			}
			if(passBis.isEmpty() || !this.validation(passBis, MIN_PASS, MAX_PASS)) {
				fieldError = true;
				this.addFieldError("passBis", "Le champs est requis et doit être compris entre "+MIN_PASS+" et "+MAX_PASS+" caractères.");
			}
			if(!pass.isEmpty() && !passBis.isEmpty() && !pass.equals(passBis)) {
				fieldError = true;
				this.addFieldError("passBis", "Le mot de passe ne correspond pas");
			}
			if(localisation.isEmpty()) {
				fieldError = true;
				this.addFieldError("localisation", "Le champs ne doit pas être vide.");
			}			
			else if(!resourcesBundle.getListLocalisation().contains(localisation)) {
				fieldError = true;
				this.addFieldError("localisation", "localisation inconnu");
				
			}
			if(!fieldError) {
				try {
					if(this.managerFactory.getUtilisateurManager().getCheckMail(mail)) {
						if(this.managerFactory.getUtilisateurManager().addUtilisateur(new Utilisateur(mail, civilite, nom, prenom, pseudo, localisation, pass))){
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("Compte crée avec succès");
						}
						else {
							vResult = ActionSupport.ERROR;
							this.addActionError("Une erreur s'est produit. Veuillez réessayer plus tard...");
						}
					}
					else {
						this.addFieldError("mail", "L'adresse mail est déja utilisé");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produit. Veuillez réessayer plus tard...");
				}
			}
			
		}
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à l'utilisateur de se connecter</p>
	 * 
	 * @return Retourne le résultat de la méthode : 'success' / 'input' / 'error'
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#utilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see UtilisateurManager
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 */
	public String doLogin () {
		
		String vResult = ActionSupport.INPUT;
		Boolean fieldError = false;
		
		if(mail != null && pass != null) {
			
			if(mail.isEmpty()) {
				fieldError = true;
				this.addFieldError("mail", "Le champs ne doit pas être vide.");
			}
			if(pass.isEmpty()) {
				fieldError = true;
				this.addFieldError("pass", "Le champs ne doit pas être vide.");
			}
			
			String idUtilisateur = null;
			if(!fieldError) {
				try {
					idUtilisateur = this.managerFactory.getUtilisateurManager().getIdbyMail(mail);
				}catch(Exception e) {
					this.addFieldError("mail", "Aucun compte n'est enregistré avec cette adresse mail");
				}
				try {
					if(idUtilisateur != null && !idUtilisateur.isEmpty()) {
						utilisateur = new Utilisateur(Integer.valueOf(idUtilisateur), pass);

						if(this.managerFactory.getUtilisateurManager().getCheckCoupleIdPass(utilisateur)) {
							utilisateur = this.managerFactory.getUtilisateurManager().getUtilisateur(utilisateur.getIdUtilisateur());
							
							if(utilisateur != null && utilisateur.getPass() == null) {
								
								request.changeSessionId();
								request.getSession().setAttribute("utilisateur", utilisateur);
								
								vResult = ActionSupport.SUCCESS;
							}
							else {
								vResult = ActionSupport.ERROR;
								this.addActionError("Une erreur s''est produit. Veuillez réessayer plus tard...");
							}
						}
						else {
							this.addFieldError("pass", "Mot de passe invalide");
						}
					}
			}catch(Exception e) {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
			}
			
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à l'utilisateur de se déconnecter</p>
	 * 
	 * @return Le résultat de la métode : 'success'
	 * 
	 * @see GestionUtilisateurAction#request
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 */
	public String doLogout() {
		
		request.getSession().invalidate();
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	/**
	 * <p>Méthode permettant de récupérer les informations d'un utilisateur</p>
	 * 
	 * @return Le résultat de la méthode 'success', 'error'
	 * 
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#utilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see UtilisateurManager
	 * @see Utilisateur
	 */
	public String doDetail() {
		
		String vResult = ActionSupport.ERROR;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty()) {
			try {
				if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(idUtilisateur)) {
					
					utilisateur = null ;
					utilisateur = this.managerFactory.getUtilisateurManager().getUtilisateur(Integer.valueOf(idUtilisateur));
					
					if(utilisateur != null) {
						vResult = ActionSupport.SUCCESS;
					}
				
				}
				else {
					this.addActionError("Utilisateur inconnu...");
				}
			}catch(Exception e) {
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
		}
		else {
			this.addActionError("Utilisateur inconnu...");
		}
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier son adresse mail<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#mail
	 * @see GestionUtilisateurAction#MIN_MAIL
	 * @see GestionUtilisateurAction#MAX_MAIL
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * 
	 */
	public String doModifyMail() {
		
		String vResult = ActionSupport.INPUT;
		
		if(mail != null && !mail.isEmpty() && this.validation(mail, MIN_MAIL, MAX_MAIL)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().getCheckMail(mail)) {
					if(this.managerFactory.getUtilisateurManager().setMailById(idUtilisateur, mail)) {
						Utilisateur utilisateur = this.managerFactory.getUtilisateurManager()
								.getUtilisateur(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
						
						request.changeSessionId();
						request.getSession().removeAttribute("utilisateur");
						request.getSession().setAttribute("utilisateur", utilisateur);
						
						this.addActionMessage("Adresse mail modifiée avec succès");
						vResult = ActionSupport.SUCCESS;
					}
					else {
						vResult = ActionSupport.ERROR;
						this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
					}
				}
				else {
					this.addFieldError("mail", "Cette adresse mail est déjà utilisé.");
				}
			}catch(Exception e) {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
		}
		else {
			this.addFieldError("mail", "Le champs est requis et doit être compris entre "+MIN_MAIL+" et "+MAX_MAIL+" caractères.");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier son pseudo<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#MIN_PSEUDO
	 * @see GestionUtilisateurAction#MAX_PSEUDO
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * 
	 */
	public String doModifyPseudo() {
		
		String vResult = ActionSupport.INPUT;
		
		if(pseudo != null && !pseudo.isEmpty() && this.validation(pseudo, MIN_PSEUDO, MAX_PSEUDO)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().setPseudoById(idUtilisateur, pseudo)) {
					Utilisateur utilisateur = this.managerFactory.getUtilisateurManager()
							.getUtilisateur(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
					
					request.changeSessionId();
					request.getSession().removeAttribute("utilisateur");
					request.getSession().setAttribute("utilisateur", utilisateur);
					
					this.addActionMessage("Pseudo modifié avec succès");
					vResult = ActionSupport.SUCCESS;
				}
				else {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
				}
			}catch(Exception e) {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
		}
		else {
			this.addFieldError("pseudo", "Le champs est requis et doit être compris entre "+MIN_PSEUDO+" et "+MAX_PSEUDO+" caractères.");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier sa localisation<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#localisation
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * 
	 */
	public String doModifyLocalisation() {
	
		String vResult = ActionSupport.INPUT;
		
		if(localisation != null && !localisation.isEmpty() && this.resourcesBundle.getListLocalisation().contains(localisation)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().setLocalisationById(idUtilisateur, localisation)) {
					Utilisateur utilisateur = this.managerFactory.getUtilisateurManager()
							.getUtilisateur(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
					
					request.changeSessionId();
					request.getSession().removeAttribute("utilisateur");
					request.getSession().setAttribute("utilisateur", utilisateur);
					
					this.addActionMessage("Localisation modifiée avec succès");
					vResult = ActionSupport.SUCCESS;
				}
				else {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
				}
			}catch(Exception e) {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
		}
		else {
			this.addFieldError("localisation", "Localisation inconnu");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier son mot de passe<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#pass
	 * @see GestionUtilisateurAction#MIN_PASS
	 * @see GestionUtilisateurAction#MAX_PASS
	 * @see GestionUtilisateurAction#validation(String, int, int)
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * 
	 */
	public String doModifyPass() {
	
		String vResult = ActionSupport.INPUT;
		
		if(pass != null && !pass.isEmpty() && this.validation(pass, MIN_PASS, MAX_PASS)) {
			if(passBis != null && !passBis.isEmpty() && this.validation(passBis, MIN_PASS, MAX_PASS)) {
				if(pass.equals(passBis)) {
					try {
						if(this.managerFactory.getUtilisateurManager().setPassById(idUtilisateur, pass, passBis)) {
							Utilisateur utilisateur = this.managerFactory.getUtilisateurManager()
									.getUtilisateur(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
							
							request.changeSessionId();
							request.getSession().removeAttribute("utilisateur");
							request.getSession().setAttribute("utilisateur", utilisateur);
							
							this.addActionMessage("Mot de passe modifié avec succès");
							vResult = ActionSupport.SUCCESS;
						}
						else {
							vResult = ActionSupport.ERROR;
							this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
						}
					}catch(Exception e) {
						vResult = ActionSupport.ERROR;
						this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
					}
				}
				else {
					this.addFieldError("passBis", "Le mot de passe ne correspond pas");
				}
			}
			else {
				this.addFieldError("passBis", "Le champs est requis et doit être compris entre "+MIN_PASS+" et "+MAX_PASS+" caractères.");
			}
		}
		else {
			this.addFieldError("pass", "Le champs est requis et doit être compris entre "+MIN_PASS+" et "+MAX_PASS+" caractères.");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à valider les input<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs</li>
	 * 		<li>La taille maximal du champss (lié à l'espace alloué)</li>
	 * </ul>
	 * 
	 * @param input  Le contenu de l'input
	 * @param longueurMin La longueur minimal du champs
	 * @param longueurMax La longueur maximal du champs
	 * @return Retourne le résultat de la validation => validée (=true) / refusée (=false)
	 * 
	 * @see GestionUtilisateurAction#setMail(String)
	 * @see GestionUtilisateurAction#setPseudo(String)
	 * @see GestionUtilisateurAction#setCivilite(String)
	 * @see GestionUtilisateurAction#setNom(String)
	 * @see GestionUtilisateurAction#setPrenom(String)
	 * @see GestionUtilisateurAction#setPass(String)
	 * @see GestionUtilisateurAction#setPassBis(String)
	 * @see GestionUtilisateurAction#MIN_MAIL
	 * @see GestionUtilisateurAction#MIN_NOM
	 * @see GestionUtilisateurAction#MIN_PRENOM
	 * @see GestionUtilisateurAction#MIN_CIVILITE
	 * @see GestionUtilisateurAction#MIN_PSEUDO
	 * @see GestionUtilisateurAction#MIN_PASS
	 * @see GestionUtilisateurAction#MAX_MAIL
	 * @see GestionUtilisateurAction#MAX_NOM
	 * @see GestionUtilisateurAction#MAX_PRENOM
	 * @see GestionUtilisateurAction#MAX_CIVILITE
	 * @see GestionUtilisateurAction#MAX_PSEUDO
	 * @see GestionUtilisateurAction#MAX_PASS
	 */
	public Boolean validation(String input, int longueurMin, int longueurMax) {
				
		Boolean vReturn = false;
		
		if(input != null && !input.isEmpty()) {
			if(input.length() >= longueurMin && input.length() <= longueurMax) {
				vReturn = true;
			}
		}
		
		return vReturn;
	}
	
	
	
	/**
	 * 
	 * <p>Méthode servant à formatter toutes les entrées saisi par l'utilisateur</p>
	 * <p>Vérification de l'entrée puis formattage en retirant tous les espaces superflus</p>
	 * 
	 * @param input La saisi de l'utilisateur
	 * @return La saisi de l'utilisateur à présent formatté
	 * 
	 * @see GestionUtilisateurAction#setMail(String)
	 * @see GestionUtilisateurAction#setPseudo(String)
	 * @see GestionUtilisateurAction#setCivilite(String)
	 * @see GestionUtilisateurAction#setNom(String)
	 * @see GestionUtilisateurAction#setPrenom(String)
	 * @see GestionUtilisateurAction#setLocalisation(String)
	 * @see GestionUtilisateurAction#setIdUtilisateur(String)
	 */
	public String inputFormat(String input) {
		
		if(input != null && !input.isEmpty()) {
			for(int i = 0; i < input.length()-1; i++) {
				String character = input.substring(i, i+1);
				String characterBis = input.substring(i+1, i+2);
							
				if(character.equals(" ") && characterBis.equals(" ")) {
					input = input.substring(0, i)+input.substring(i+1, input.length());
					i--;
				}
			}
			if(input.startsWith(" ")) {
				input = input.substring(1);
			}
			
			if(input.endsWith(" ")) {
				input = input.substring(0, input.length()-1);
			}
		}
		
		return input;
	} 
}
