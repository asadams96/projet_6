package fr.openclassrooms.projet_6.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SiteManager;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;
import fr.openclassrooms.projet_6.webapp.bundle.ResourcesBundle;

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
	 * <p>Objet servant à stocker la requête en cours</p>
	 * 

	 * @see GestionSiteAction#doAddComment()
	 * @see GestionSiteAction#setServletRequest(HttpServletRequest) 
	 * @see HttpServletRequest
	 */
	private HttpServletRequest request;	
	
	
	
	// ------------------------ Elements en entrée ------------------------
	
	
	
	/**
	* <p>Objet servant à stocker le critère de type choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#setCriteresType(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresType;
		
		
		
	/**
	* <p>Objet servant à stocker le critère d'orientation choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#setCriteresOrientation(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresOrientation;
		
		
		
	/**
	* <p>Objet servant à stocker le critère de localisation choisi par l'utilisateur</p>
	* 
	* @see GestionSiteAction#setCriteresLocalisation(String)
	* @see GestionSiteAction#doList()
	*/
	private String criteresLocalisation;
		
		
		
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
	* <p>Object servant à stocker une identifiant de 'Site'</p>
	* 
	* @see GestionSiteAction#getIdSite()
	* @see GestionSiteAction#doDetail()
	* @see Site
	*/
	private String idSite;
	
	
	
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
	
	
	
	/**
	 * <p>Objet servant à stocker le contenu du commentaire saisi par l'utilisateur</p>
	 * 
	 * @see GestionSiteAction#setContenu(String)
	 * @see GestionSiteAction#doAddComment()
	 */
	private String contenu;
	
	
	
	// --------------------------------- Setters ---------------------------------


	
	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
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
	 * @see GestionSiteAction#managerFactory
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
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresType' en fonction 
	 * 	des	paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @see GestionSiteAction#criteresType
	 */
	public void setCriteresType(String criteresType) {
		this.criteresType = this.inputFormat(criteresType);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresOrientation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @see GestionSiteAction#criteresOrientation
	 */
	public void setCriteresOrientation(String criteresOrientation) {
		this.criteresOrientation = this.inputFormat(criteresOrientation);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-site.jsp' pour définir l'objet 'criteresLocalisation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-site.jsp'
	 * </p>
	 * 
	 * @see GestionSiteAction#criteresLocalisation
	 */
	public void setCriteresLocalisation(String criteresLocalisation) {
		this.criteresLocalisation = this.inputFormat(criteresLocalisation);
	}
	
	
	
	/**
	 * <p>Setter servant à la vue 'site.jsp' pour définir l'objet 'idSite'</p>
	 * 
	 * @see GestionSiteAction#idTopo
	 */
	public void setIdSite(int idSite) {
		try {

			this.idSite = String.valueOf(idSite);

		}catch(Exception e) {}
		
	}
	
	
	
	/**
	 * <p>Setter servant à la vue 'site.jsp' pour définir l'objet 'contenu'</p>
	 * 
	 * @see GestionSiteAction#contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = this.inputFormat(contenu);
	}
	
	
	
	// --------------------------------- Getters ---------------------------------	

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @see GestionSiteAction#resourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listSite' depuis la vue 'list-site.jsp'</p>
	 * 
	 * @see GestionSiteAction#listSite
	 */
	public List<Site> getListSite() {
		return listSite;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'idSite' depuis struts.xml</p>
	 * <p>Plus precisement l'action, 'site_comment'</p>
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 */
	public String getIdSite() {
		return idSite;
	}
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'site' depuis la vue 'site.jsp'</p>
	 * 
	 * @see GestionSiteAction#site
	 */
	public Site getSite() {
		return site;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'secteurListVoie' depuis la vue 'site.jsp'</p>
	 * 
	 * @see GestionSiteAction#listTopo
	 */
	public List<Object> getSecteurListVoie() {
		return secteurListVoie;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listTopo' depuis la vue 'site.jsp'</p>
	 * 
	 * @see GestionSiteAction#listTopo
	 */
	public List<Topo> getListTopo() {
		return listTopo;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listCommentaire' depuis la vue 'site.jsp'</p>
	 * 
	 * @see GestionSiteAction#listTopo
	 */
	public List<CommentaireSite> getListCommentaire() {
		return listCommentaire;
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
	* @see SiteManager#getList(String, String, String)
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
	 * @see GestionSiteAction#listSite
	 * @see GestionSiteAction#listCommentaire
	 * @see GestionSiteAction#managerFactory
	 * @see SiteManager#getCheckSite(String)
	 * @see SiteManager#getSite(String)
	 * @see SiteManager#getList(String, String, String)
	 * @see CommentaireSiteManager#getList(String)
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
			e.printStackTrace();
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
	 * @see GestionSiteAction#contenuValidation(String)
	 */
	public String doAddComment() {
		String vResult = ActionSupport.SUCCESS;
		
		if(idSite != null && !idSite.isEmpty()) {
			if(contenu != null && !contenu.isEmpty() && this.contenuValidation(contenu)) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getCommentaireSiteManager().addComment(idUtilisateur, idSite, contenu)) {
						this.addActionMessage("Le commentaire a été ajouté avec succès.");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
					e.printStackTrace();
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
			}
			else {
				vResult = ActionSupport.INPUT;
				this.addFieldError("contenu", "Le commentaire doit etre compris entre 25 et 500 caractères.");
			}
		}
		else {
			vResult = ActionSupport.ERROR;
			this.addActionError("Site inconnu, ajout de commentaire impossible");
		}

		return vResult;		
	}
	
	
	
	/**
	 * <p>Méthode servant à vérifier le contenu d'un commentaire<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs de 25 caractères</li>
	 * 		<li>La taille maximal du champs de 500 caractères (lié à l'espace alloué en BDD)</li>
	 * </ul>
	 * 
	 * @param contenu => Le contenu du commentaire
	 * @return Retourne le résultat de la validation => validé (=true) / refusé (=false)
	 * 
	 * @see GestionSiteAction#contenu
	 * @see GestionSiteAction#doAddComment()
	 */
	public Boolean contenuValidation(String contenu) {
		
		int longueurMin = 25, longueurMax = 500;
		
		Boolean vReturn = false;
		
		
		if(contenu.length() >= longueurMin && contenu.length() <= longueurMax) {
			vReturn = true;
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
	 * @see GestionSiteAction#setContenu(String)
	 * @see GestionSiteAction#setCriteresType(String)
	 * @see GestionSiteAction#setCriteresLocalisation(String)
	 * @see GestionSiteAction#setCriteresOrientation(String)
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
