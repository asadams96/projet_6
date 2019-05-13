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
import fr.openclassrooms.projet_6.webapp.interceptor.IndexInterceptor;
import fr.openclassrooms.projet_6.webapp.validator.InputValidation;



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
 * 
 * @see GestionUtilisateurAction#managerFactory
 * @see GestionUtilisateurAction#resourcesBundle
 * @see GestionUtilisateurAction#inputValidation
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
 * @see GestionUtilisateurAction#setInputValidation(InputValidation)
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
 * @see UtilisateurManager
 * @see ResourcesBundle
 * @see InputValidation
 * @see GestionPretAction
 * @see GestionSiteAction
 * @see GestionTopoAction
 * @see AuthentificationInterceptor
 * @see EncodingInterceptor
 * @see IndexInterceptor
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
	 * <p>Objet servant à stocker une instance de la classe 'InputValidation'</p>
	 * 
	 * @see GestionUtilisateurAction#setMail(String)
	 * @see GestionUtilisateurAction#setPseudo(String)
	 * @see GestionUtilisateurAction#setCivilite(String)
	 * @see GestionUtilisateurAction#setNom(String)
	 * @see GestionUtilisateurAction#setPrenom(String)
	 * @see GestionUtilisateurAction#setLocalisation(String)
	 * @see GestionUtilisateurAction#setIdUtilisateur(String)
	 * @see GestionUtilisateurAction#setInputValidation(InputValidation)
	 * @see InputValidation
	 */
	private InputValidation inputValidation;
	
	
	
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
	 * @param managerFactory Une instance de la classe 'ManagerFactory'
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
	 * @param resourcesBundle Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionSiteAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public void setResourcesBundle(ResourcesBundle resourcesBundle) {
		this.resourcesBundle = resourcesBundle;
	}
	
	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'inputValidation'</p>
	 * 
	 * @param inputValidation Un instance de la classe 'InputValidation'
	 * 
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation
	 */
	public void setInputValidation(InputValidation inputValidation) {
		this.inputValidation = inputValidation;
	}



	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @param request La requête en cours
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setMail(String mail) {
		this.mail = inputValidation.inputFormat(mail);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = inputValidation.inputFormat(pseudo);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCivilite(String civilite) {
		this.civilite = inputValidation.inputFormat(civilite);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setNom(String nom) {
		this.nom = inputValidation.inputFormat(nom);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setPrenom(String prenom) {
		this.prenom = inputValidation.inputFormat(prenom);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setLocalisation(String localisation) {
		this.localisation = inputValidation.inputFormat(localisation);
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
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdUtilisateur(String idUtilisateur) {
			this.idUtilisateur = inputValidation.inputFormat(idUtilisateur);		
		
	}
	
	
	
	// --------------------------------- Getters ---------------------------------
	


	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @return Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionUtilisateurAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer le paramètre 'mail' depuis les vues 'inscription.jsp', 'profil.jsp', 'connexion.jsp'</p>
	 * 
	 * @return L'adresse mail de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#mail
	 * */
	public String getMail() {
		return mail;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'pseudo' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @return Le pseudo de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'civilite' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @return La civilité de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#civilite
	 */
	public String getCivilite() {
		return civilite;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'nom' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @return Le nom de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * <p>Getter permettant de récupérer le paramètre 'prenom' depuis la vue 'inscription.jsp'</p>
	 * 
	 * @return Le prenom de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	
	/**
	 * <p>Getter permettant de récupérer le paramètre 'localisation' depuis les vues 'inscription.jsp', 'profil.jsp'</p>
	 * 
	 * @return La localisation de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#localisation
	 */
	public String getLocalisation() {
		return localisation;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer une instance de la classe Utilisateur depuis la vue 'profil.jsp'</p>
	 * 
	 * @return une instance de la classe 'Utilisateur'
	 * 
	 * @see GestionUtilisateurAction#utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	

	/**
	 * <p>Getter permettant de récupérer l'identifiant d'un Utilisateur depuis la vue 'profil.jsp'</p>
	 * 
	 * @return L'identifiant de l'utilisateur
	 * 
	 * @see GestionUtilisateurAction#idUtilisateur
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
	 * @see GestionUtilisateurAction#resourcesBundle
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#inputValidation
	 * @see InputValidation#mailValidation(String)
	 * @see InputValidation#pseudoValidation(String)
	 * @see InputValidation#civiliteValidation(String)
	 * @see InputValidation#nomValidation(String)
	 * @see InputValidation#prenomValidation(String)
	 * @see InputValidation#passValidation(String)
	 * @see InputValidation#getMIN_MAIL()
	 * @see InputValidation#getMIN_PSEUDO()
	 * @see InputValidation#getMIN_CIVILITE()
	 * @see InputValidation#getMIN_NOM()
	 * @see InputValidation#getMIN_PRENOM()
	 * @see InputValidation#getMIN_PASS()
	 * @see InputValidation#getMAX_MAIL()
	 * @see InputValidation#getMAX_PSEUDO()
	 * @see InputValidation#getMAX_CIVILITE()
	 * @see InputValidation#getMAX_NOM()
	 * @see InputValidation#getMAX_PRENOM()
	 * @see InputValidation#getMAX_PASS()
	 * @see ResourcesBundle#getListLocalisation()
	 * @see UtilisateurManager#addUtilisateur(Utilisateur)
	 */
	public String doInscription() {
		
		String vResult = ActionSupport.INPUT;
		Boolean fieldError = false;
		
		if(mail != null && civilite != null && nom != null && prenom != null && pseudo != null && pass != null && passBis != null && localisation != null) {
			if(mail.isEmpty() || !inputValidation.mailValidation(mail)) {
				fieldError = true;
				this.addFieldError("mail", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_MAIL()+" et "+inputValidation.getMAX_MAIL()+" caractères.");
			}
			if(civilite.isEmpty() || !inputValidation.civiliteValidation(civilite)) {
				fieldError = true;
				this.addFieldError("civilite", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_CIVILITE()+" et "+inputValidation.getMAX_CIVILITE()+" caractères.");
			}
			if(nom.isEmpty() || !inputValidation.nomValidation(nom)) {
				fieldError = true;
				this.addFieldError("nom", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_NOM()+" et "+inputValidation.getMAX_NOM()+" caractères.");
			}
			if(prenom.isEmpty() || !inputValidation.prenomValidation(prenom)) {
				fieldError = true;
				this.addFieldError("prenom", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PRENOM()+" et "+inputValidation.getMAX_PRENOM()+" caractères.");
			}
			if(pseudo.isEmpty() || !inputValidation.pseudoValidation(pseudo)) {
				fieldError = true;
					this.addFieldError("pseudo", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PSEUDO()+" et "+inputValidation.getMAX_PSEUDO()+" caractères.");
			}
			if(pass.isEmpty() || !inputValidation.passValidation(pass)) {
				fieldError = true;
				this.addFieldError("pass", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PASS()+" et "+inputValidation.getMAX_PASS()+" caractères.");
			}
			if(passBis.isEmpty() || !inputValidation.passValidation(passBis)) {
				fieldError = true;
				this.addFieldError("passBis", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PASS()+" et "+inputValidation.getMAX_PASS()+" caractères.");
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
	 * @see UtilisateurManager#getIdbyMail(String)
	 * @see UtilisateurManager#getCheckCoupleIdPass(Utilisateur)
	 * @see Utilisateur#Utilisateur(Integer, String)
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
	 * @see UtilisateurManager#getUtilisateur(int)
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
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see GestionUtilisateurAction#inputValidation
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see InputValidation#mailValidation(String)
	 * @see InputValidation#getMIN_MAIL()
	 * @see InputValidation#getMAX_MAIL()
	 * @see UtilisateurManager#setMailById(String, String)
	 * 
	 */
	public String doModifyMail() {
		
		String vResult = ActionSupport.INPUT;
		
		if(mail != null && !mail.isEmpty() && inputValidation.mailValidation(mail)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().getCheckMail(mail)) {
					if(this.managerFactory.getUtilisateurManager().setMailById(
							String.valueOf(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur()), mail)) {
						
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
			this.addFieldError("mail", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_MAIL()+" et "+inputValidation.getMAX_MAIL()+" caractères.");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier son pseudo<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#pseudo
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see GestionUtilisateurAction#inputValidation
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see InputValidation#pseudoValidation(String)
	 * @see InputValidation#getMIN_PSEUDO()
	 * @see InputValidation#getMAX_PSEUDO()
	 * @see UtilisateurManager#setPseudoById(String, String)
	 * 
	 */
	public String doModifyPseudo() {
		
		String vResult = ActionSupport.INPUT;
		
		if(pseudo != null && !pseudo.isEmpty() && inputValidation.pseudoValidation(pseudo)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().setPseudoById(
						String.valueOf(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur()), pseudo)) {
					
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
			this.addFieldError("pseudo", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PSEUDO()+" et "+inputValidation.getMAX_PSEUDO()+" caractères.");
		}
		
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode permettant à un utilisateur de modifier sa localisation<p>
	 * 
	 * @return Le résultat de la méthode : 'success', 'input', 'error'
	 * 
	 * @see GestionUtilisateurAction#localisation
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see GestionUtilisateurAction#resourcesBundle
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ResourcesBundle#getListLocalisation()
	 * @see UtilisateurManager#setLocalisationById(String, String)
	 * 
	 */
	public String doModifyLocalisation() {
	
		String vResult = ActionSupport.INPUT;
		
		if(localisation != null && !localisation.isEmpty() && this.resourcesBundle.getListLocalisation().contains(localisation)) {
			
			try {
				if(this.managerFactory.getUtilisateurManager().setLocalisationById(
						String.valueOf(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur()), localisation)) {
					
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
	 * @see GestionUtilisateurAction#idUtilisateur
	 * @see GestionUtilisateurAction#managerFactory
	 * @see GestionUtilisateurAction#request
	 * @see GestionUtilisateurAction#inputValidation
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see InputValidation#passValidation(String)
	 * @see InputValidation#getMIN_PASS())
	 * @see InputValidation#getMAX_PASS()
	 * @see UtilisateurManager#setPassById(String, String, String)
	 * 
	 */
	public String doModifyPass() {
	
		String vResult = ActionSupport.INPUT;
		
		if(pass != null && !pass.isEmpty() && inputValidation.passValidation(pass)) {
			if(passBis != null && !passBis.isEmpty() && inputValidation.passValidation(passBis)) {
				if(pass.equals(passBis)) {
					try {
						if(this.managerFactory.getUtilisateurManager().setPassById(
								String.valueOf(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur()), pass, passBis)) {
							
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
				this.addFieldError("passBis", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PASS()+" et "+inputValidation.getMAX_PASS()+" caractères.");
			}
		}
		else {
			this.addFieldError("pass", "Le champs est requis et doit être compris entre "+inputValidation.getMIN_PASS()+" et "+inputValidation.getMAX_PASS()+" caractères.");
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
	
	
}
