package fr.openclassrooms.projet_6.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.Parameter.Request;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.VoieManager;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;
import fr.openclassrooms.projet_6.webapp.bundle.ResourcesBundle;
import fr.openclassrooms.projet_6.webapp.interceptor.AuthentificationInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.EncodingInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.IndexInterceptor;
import fr.openclassrooms.projet_6.webapp.validator.InputValidation;



/**
 * <p>Classe action gérant la gestion des sites</p>
 * 
 * <p>Elle est implémenté de 3 actions :</p>
 * <ul>
 * 		<li>Afficher le catalogue de site (avec critères de recherche) => doList()</li>
 * 		<li>Afficher la fiche d'un site => doDetail()</li>
 * 		<li>Deposer un commentaire (sur une fiche de site) => doAddComment()</li>
 * </ul>
 * 
 * 
 * @see GestionSiteAction#doList()
 * @see GestionSiteAction#doDetail()
 * @see GestionSiteAction#doAddComment()
 * @see GestionSiteAction#request
 * @see GestionSiteAction#managerFactory
 * @see GestionSiteAction#resourcesBundle
 * @see GestionSiteAction#inputValidation
 * @see GestionSiteAction#contenu
 * @see GestionSiteAction#listTopo
 * @see GestionSiteAction#listSite
 * @see GestionSiteAction#listCommentaire
 * @see GestionSiteAction#criteresType
 * @see GestionSiteAction#criteresOrientation
 * @see GestionSiteAction#criteresLocalisation
 * @see GestionSiteAction#site
 * @see GestionSiteAction#idSite
 * @see GestionSiteAction#secteurListVoie
 * @see GestionSiteAction#setServletRequest(HttpServletRequest)
 * @see GestionSiteAction#setManagerFactory(ManagerFactory)
 * @see GestionSiteAction#setResourcesBundle(ResourcesBundle)
 * @see GestionSiteAction#setInputValidation(InputValidation)
 * @see GestionSiteAction#setCriteresType(String)
 * @see GestionSiteAction#setCriteresOrientation(String)
 * @see GestionSiteAction#setCriteresLocalisation(String)
 * @see GestionSiteAction#setContenu(String)
 * @see GestionSiteAction#setIdSite(int)
 * @see GestionSiteAction#getListTopo()
 * @see GestionSiteAction#getListSite()
 * @see GestionSiteAction#getListCommentaire()
 * @see GestionSiteAction#getResourcesBundle()
 * @see GestionSiteAction#getCriteresType()
 * @see GestionSiteAction#getCriteresOrientation()
 * @see GestionSiteAction#getCriteresLocalisation()
 * @see GestionSiteAction#getIdSite()
 * @see GestionSiteAction#getSite()
 * @see GestionSiteAction#getSecteurListVoie()
 * @see ResourcesBundle
 * @see InputValidation
 * @see GestionPretAction
 * @see GestionTopoAction
 * @see GestionUtilisateurAction
 * @see AuthentificationInterceptor
 * @see EncodingInterceptor
 * @see IndexInterceptor
 * @see Topo
 * @see Message
 * @see Site
 * @see CommentaireSite
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
public class GestionSiteAction extends ActionSupport implements ServletRequestAware {
	
		
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ManagerFactory'</p>
	 * 
	 * @see GestionSiteAction#doList()
	 * @see GestionSiteAction#doDetail()
	 * @see GestionSiteAction#doLibrary()
	 * @see GestionSiteAction#doAddLibrary()
	 * @see GestionSiteAction#doRemoveLibrary()
	 * @see GestionSiteAction#doAddComment()
	 * @see GestionSiteAction#setManagerFactory(ManagerFactory)
	 * @see ManagerFactory
	 */
	private ManagerFactory managerFactory;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ResourcesBundle'</p>
	 * 
	 * @see GestionSiteAction#doList()
	 * @see GestionSiteAction#getResourcesBundle()
	 * @see GestionSiteAction#setResourcesBundle(ResourcesBundle)
	 * @see ResourcesBundle
	 */
	private ResourcesBundle resourcesBundle;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'InputValidation'</p>
	 * 
	 * @see GestionSiteAction#setCriteresType(String)
	 * @see GestionSiteAction#setCriteresOrientation(String)
	 * @see GestionSiteAction#setCriteresLocalisation(String)
	 * @see GestionSiteAction#setIdSite(String)
	 * @see GestionSiteAction#setContenu(String)
	 * @see GestionSiteAction#setInputValidation(InputValidation)
	 * @see InputValidation
	 */
	private InputValidation inputValidation;

	
	
	/**
	 * <p>Objet servant à stocker la requête en cours</p>
	 * 

	 * @see GestionSiteAction#doAddComment()
	 * @see GestionSiteAction#setServletRequest(HttpServletRequest) 
	 * @see HttpServletRequest
	 */
	private HttpServletRequest request;	
	
	
	
	// ------------------------ Elements en entrée et sortie------------------------
	
	
	
	/**
	* <p>Objet servant à stocker le critère de type choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#getCriteresType()
	* @see GestionSiteAction#setCriteresType(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresType;
		
		
		
	/**
	* <p>Objet servant à stocker le critère d'orientation choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#getCriteresOrientation()
	* @see GestionSiteAction#setCriteresOrientation(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresOrientation;
		
		
		
	/**
	* <p>Objet servant à stocker le critère de localisation choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#getCriteresLocalisation()
	* @see GestionSiteAction#setCriteresLocalisation(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresLocalisation;
	
	
	
	/**
	* <p>Object servant à stocker une identifiant de 'Site'</p>
	* 
	* @see GestionSiteAction#getIdSite()
	* @see GestionSiteAction#setIdSite(int)
	* @see GestionSiteAction#doDetail()
	* @see Site
	*/
	private String idSite;
	

	
	/**
	 * <p>Objet servant à stocker le contenu du commentaire saisi par l'utilisateur</p>
	 * 
	 * @see GestionSiteAction#setContenu(String)
	 * @see GestionSiteAction#doAddComment()
	 */
	private String contenu;
		
		
		
	// ------------------------ Elements en sortie ------------------------	
		
		
		
	/**
	* <p>Object servant à stocker une liste d'objet "Site"</p>
	* 
	* @see GestionSiteAction#getListSite()
	* @see GestionSiteAction#doDetail()
	* @see Site
	*/
	private List<Site> listSite;
	
	
	
	/**
	 * <p>Objet 'Site' servant à stocker les details d'un site</p>
	 * 
	 * @see GestionSiteAction#getSite()
	 * @see GestionSiteAction#doDetail()
	 * @see Site
	 */
	private Site site;


	
	/**
	 * <p>Liste d'objet alternant secteur et liste de voie (associé au secteur)<p>
	 * 
	 * @see GestionSiteAction#getSecteurListVoie()
	 * @see GestionSiteAction#doAddComment()
	 * @see Secteur
	 * @see Voie
	 */
	private List<Object> secteurListVoie;



	/**
	 * <p>Liste d'instance de l'objet Topo</p>
	 * 
	 * @see GestionSiteAction#getListTopo()
	 * @see GestionSiteAction#doAddComment()
	 * @see Topo
	 */
	private List<Topo> listTopo;



	/**
	 * <p>Liste d'instance de l'object CommentaireSite</p>
	 * 
	 * @see GestionSiteAction#getListCommentaire()
	 * @see GestionSiteAction#doAddComment()
	 * @see CommentaireSite
	 * @see Message
	 */
	private List<CommentaireSite> listCommentaire;
	
	
	
	// --------------------------------- Setters ---------------------------------


	
	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @param request La requête en cours
	 * 
	 * @see GestionSiteAction#request
	 * @see ServletRequestAware
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}



	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'managerFactory'</p>
	 * 
	 * @param managerFactory Une instance de la classe 'ManagerFactory'
	 * 
	 * @see GestionSiteAction#managerFactory
	 * @see ManagerFactory
	 */
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'inputValidation'</p>
	 * 
	 * @param inputValidation Un instance de la classe 'InputValidation'
	 * 
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation
	 */
	public void setInputValidation(InputValidation inputValidation) {
		this.inputValidation = inputValidation;
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
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresType' en fonction 
	 * 	des	paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @param criteresType Un critère de type
	 * 
	 * @see GestionSiteAction#criteresType
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresType(String criteresType) {
		this.criteresType = inputValidation.inputFormat(criteresType);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresOrientation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @param criteresOrientation Un critère d'orientation
	 * 
	 * @see GestionSiteAction#criteresOrientation
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresOrientation(String criteresOrientation) {
		this.criteresOrientation = inputValidation.inputFormat(criteresOrientation);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresLocalisation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @param criteresLocalisation Un critère de localisation
	 * 
	 * @see GestionSiteAction#criteresLocalisation
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresLocalisation(String criteresLocalisation) {
		this.criteresLocalisation = inputValidation.inputFormat(criteresLocalisation);
	}
	
	
	
	/**
	 * <p>Setter servant à la vue 'site.jsp' pour définir l'objet 'idSite'</p>
	 * 
	 * @param idSite Un identifiant de site
	 * 
	 * @see GestionSiteAction#idSite
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdSite(String idSite) {
		this.idSite = inputValidation.inputFormat(idSite);
		
	}
	
	
	
	/**
	 * <p>Setter servant à la vue 'site.jsp' pour définir l'objet 'contenu'</p>
	 * 
	 * @param contenu Le contenu d'un commentaire
	 * 
	 * @see GestionSiteAction#contenu
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setContenu(String contenu) {
		this.contenu = inputValidation.inputFormat(contenu);
	}
	
	
	
	// --------------------------------- Getters ---------------------------------	

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @return Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionSiteAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresType' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @return Un critère de type
	 * 
	 * @see GestionSiteAction#criteresType
	 */
	public String getCriteresType() {
		return criteresType;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresOrientation' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @return Un critère d'orientation
	 * 
	 * @see GestionSiteAction#criteresOrientation
	 */
	public String getCriteresOrientation() {
		return criteresOrientation;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresLocalisation' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @return Un critère de localisation
	 * 
	 * @see GestionSiteAction#criteresLocalisation
	 */
	public String getCriteresLocalisation() {
		return criteresLocalisation;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'listSite' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'Site'
	 * 
	 * @see GestionSiteAction#listSite
	 * @see Site
	 */
	public List<Site> getListSite() {
		return listSite;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'idSite' depuis struts.xml</p>
	 * <p>Plus precisement l'action, 'site_comment'</p>
	 * 
	 * @return Un identifiant de site
	 * 
	 * @see GestionSiteAction#resourcesBundle
	 */
	public String getIdSite() {
		return idSite;
	}
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'site' depuis la vue 'site.jsp'</p>
	 * 
	 * @return Un instance de la classe 'Site'
	 * 
	 * @see GestionSiteAction#site
	 * @see Site
	 */
	public Site getSite() {
		return site;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'secteurListVoie' depuis la vue 'site.jsp'</p>
	 * 
	 * @return Un liste de la classe 'Object'
	 * 
	 * @see GestionSiteAction#listTopo
	 */
	public List<Object> getSecteurListVoie() {
		return secteurListVoie;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listTopo' depuis la vue 'site.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'Topo'
	 * 
	 * @see GestionSiteAction#listTopo
	 * @see Topo
	 */
	public List<Topo> getListTopo() {
		return listTopo;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listCommentaire' depuis la vue 'site.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'CommentaireSite'
	 * 
	 * @see GestionSiteAction#listTopo
	 * @see CommentaireSite
	 */
	public List<CommentaireSite> getListCommentaire() {
		return listCommentaire;
	}
	
	
	
	/**
	 * <p>Permet à la vue 'site.jsp' de récupérer le champs 'contenu' après un input</p>
	 * 
	 * @return Le contenu du commentaire
	 * 
	 * @see GestionSiteAction#contenu
	 */
	public String getContenu() {
		return contenu;
	}
	
	
	
	// --------------------------------- Methodes ---------------------------------




	/**
	* <p>Méthode servant à récuperer le catalogue de site avec ou sans critères de recherche.</p>
	* 
	* <p>Les critères possible sont :</p>
	* <ul>
	* 		<li>l'orientation du terrain</li>
	* 		<li>le type de terrain</li>
	* 		<li>la localisation du terrain</li>
	* </ul>
	* 
	* @return Retourne le résultat de l'action : 'success' ou 'error'
	* 
	* @see GestionSiteAction#criteresType
	* @see GestionSiteAction#criteresOrientation
	* @see GestionSiteAction#criteresLocalisation
	* @see GestionSiteAction#resourcesBundle
	* @see GestionSiteAction#managerFactory
	* @see GestionSiteAction#listSite
	* @see SiteManager#getList(String, String, String)
	* @see ResourcesBundle#getListOrientation()
	* @see ResourcesBundle#getListType()
	* @see ResourcesBundle#getListLocalisation()
	 */
	public String doList() {
			
		String vResult = ActionSupport.SUCCESS;
			
		if(criteresType != null && !criteresType.isEmpty()) {
				
			if(!resourcesBundle.getListType().contains(criteresType)) {
				
				this.addFieldError("criteresType", "Type inconnu");
				criteresType = null;
			}
		}
		if(criteresOrientation != null && !criteresOrientation.isEmpty()) {

			if(!resourcesBundle.getListOrientation().contains(criteresOrientation)) {
				this.addFieldError("criteresOrientation", "Orientation inconnu");
				criteresOrientation = null;
			}
		}
		if(criteresLocalisation != null && !criteresLocalisation.isEmpty()) {

			if(!resourcesBundle.getListLocalisation().contains(criteresLocalisation)) {
				this.addFieldError("criteresLocalisation", "Localisation inconnu");
				criteresLocalisation = null;
			}
		}
			
			
		try {
			listSite = managerFactory.getSiteManager().getList(criteresType, criteresOrientation, criteresLocalisation);
		}catch(Exception e) {
			this.addActionError("Une erreur s'est produit, veuillez reessayer plus tard...");
			vResult = ActionSupport.ERROR;
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à récuperer les détails d'un site.</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' 
	 * 
	 * @see GestionSiteAction#idSite
	 * @see GestionSiteAction#topo
	 * @see GestionSiteAction#listTopo
	 * @see GestionSiteAction#listCommentaire
	 * @see GestionSiteAction#secteurListVoie
	 * @see GestionSiteAction#managerFactory
	 * @see SiteManager#getCheckSite(String)
	 * @see SiteManager#getSite(String)
	 * @see SiteManager#getList(String, String, String)
	 * @see CommentaireSiteManager#getList(String)
	 * @see VoieManager#getSecteurListVoie(List)
	 */
	public String doDetail() {

		String vResult = ActionSupport.SUCCESS;

		try {
			if(idSite != null && !idSite.isEmpty() && managerFactory.getSiteManager().getCheckSite(idSite)) {
				site = managerFactory.getSiteManager().getSite(idSite);
				List<Secteur> listSecteur = managerFactory.getSecteurManager().getList(idSite);
				
				secteurListVoie = managerFactory.getVoieManager().getSecteurListVoie(listSecteur);
				listTopo = managerFactory.getTopoManager().getList(idSite);
				listCommentaire = managerFactory.getCommentaireSiteManager().getList(idSite);
			}
			else {
				vResult = ActionSupport.ERROR;
				this.addActionError("Le site demandé est inconnu.");
			}
		}catch(Exception e) {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
		}
		return vResult;
		
	}
	
	
	
	/**
	 * <p>Méthode servant à ajouter un commentaire à un site</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionSiteAction#idSite
	 * @see GestionSiteAction#contenu
	 * @see GestionSiteAction#request
	 * @see GestionSiteAction#managerFactory
	 * @see CommentaireSiteManager#addComment(int, String, String)
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see GestionSiteAction#inputValidation
	 * @see InputValidation#messageValidation(String)
	 * @see InputValidation#getMIN_CONTENU()
	 * @see InputValidation#getMAX_CONTENU()
	 */
	public String doAddComment() {
		String vResult = ActionSupport.ERROR;
		
		if(idSite != null && !idSite.isEmpty()) {
			if(contenu != null && !contenu.isEmpty() && inputValidation.messageValidation(contenu)) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getCommentaireSiteManager().addComment(idUtilisateur, idSite, contenu)) {
						vResult = ActionSupport.SUCCESS;
						this.addActionMessage("Le commentaire a été ajouté avec succès.");
					}
					else {
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}catch(Exception e) {
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
			}
			else {
				vResult = ActionSupport.INPUT;
				this.addFieldError("contenu", "Le commentaire doit etre compris entre "+inputValidation.getMIN_CONTENU()+" et "+inputValidation.getMAX_CONTENU()+" caractères.");
			}
		}
		else {
			this.addActionError("Site inconnu, ajout de commentaire impossible");
		}

		return vResult;		
	}
		
}
