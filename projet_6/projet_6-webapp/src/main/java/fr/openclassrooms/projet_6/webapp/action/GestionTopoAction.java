package fr.openclassrooms.projet_6.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponProprietaireTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.topo.TopoManager;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;
import fr.openclassrooms.projet_6.webapp.bundle.ResourcesBundle;
import fr.openclassrooms.projet_6.webapp.interceptor.AuthentificationInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.EncodingInterceptor;

/**
 * <p>Classe action gérant la gestion des topos</p>
 * 
 * <p>Elle est implémenté de 6 actions :</p>
 * <ul>
 * 		<li>Afficher le catalogue de topo (avec critères de recherche) => doList()</li>
 * 		<li>Afficher la fiche d'un topo => doDetail()</li>
 * 		<li>Afficher la bibliothèque de l'utilisateur => doLibrary()</li>
 * 		<li>Ajouter un topo à la bibliothèque => doAddLibrary()</li>
 * 		<li>Supprimer un topo de la bibliothèque => doRemoveLibrary()</li>
 * 		<li>Deposer un commentaire (sur une fiche de topo) => doAddComment();</li>
 * </ul>
 * 
 * <p>La méthode inputFormat(String) sert à formatter les saisis utilisateurs.</p>
 * 
 * <p>
 * 	La méthode contenuValidation(String) sert à vérifier que le contenu du commentaire
 * 	saisi par l'utilisateur respecte bien les contraintes défini dans cette même métode.
 * </p>
 * 
 * 
 * @see GestionTopoAction#doList()
 * @see GestionTopoAction#doDetail()
 * @see GestionTopoAction#doLibrary()
 * @see GestionTopoAction#doAddLibrary()
 * @see GestionTopoAction#doRemoveLibrary()
 * @see GestionTopoAction#doAddComment()
 * @see GestionTopoAction#inputFormat(String)
 * @see GestionTopoAction#contenuValidation(String)
 * @see ResourcesBundle
 * @see GestionPretAction
 * @see GestionSiteAction
 * @see GestionUtilisateurAction
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
public class GestionTopoAction extends ActionSupport implements ServletRequestAware {
	
	
	
	/**
	 * <p>Objet servant à stocker la requête en cours</p>
	 * 
	 * @see GestionTopoAction#doLibrary()
	 * @see GestionTopoAction#doAddLibrary()
	 * @see GestionTopoAction#doRemoveLibrary()
	 * @see GestionTopoAction#doAddComment()
	 * @see GestionTopoAction#setServletRequest(HttpServletRequest) 
	 * @see HttpServletRequest
	 */
	private HttpServletRequest request;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ManagerFactory'</p>
	 * 
	 * @see GestionTopoAction#doList()
	 * @see GestionTopoAction#doDetail()
	 * @see GestionTopoAction#doLibrary()
	 * @see GestionTopoAction#doAddLibrary()
	 * @see GestionTopoAction#doRemoveLibrary()
	 * @see GestionTopoAction#doAddComment()
	 * @see GestionTopoAction#setManagerFactory(ManagerFactory)
	 * @see ManagerFactory
	 */
	private ManagerFactory managerFactory;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ResourcesBundle'</p>
	 * 
	 * @see GestionTopoAction#doList()
	 * @see GestionTopoAction#getResourcesBundle()
	 * @see GestionTopoAction#setResourcesBundle(ResourcesBundle)
	 * @see ResourcesBundle
	 */
	private ResourcesBundle resourcesBundle;

	
	
	
	// ------------------------ Elements en entrée ------------------------
	
	
	
	/**
	 * <p>Objet servant à stocker le critère de type choisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setCriteresType(String)
	 * @see GestionTopoAction#doList()
	 */
	private String criteresType;
	
	
	
	/**
	 * <p>Objet servant à stocker le critère d'orientation choisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setCriteresOrientation(String)
	 * @see GestionTopoAction#doList()
	 */
	private String criteresOrientation;
	
	
	
	/**
	 * <p>Objet servant à stocker le critère de localisation choisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setCriteresLocalisation(String)
	 * @see GestionTopoAction#doList()
	 */
	private String criteresLocalisation;
	
	
	
	
	/**
	 * <p>Objet servant à stocker le contenu du commentaire saisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setContenu(String)
	 * @see GestionTopoAction#doAddComment()
	 */
	private String contenu;
	
	
	
	/**
	 * <p>
	 * 	Objet servant à stocker la quantité de topo choisi par l'utilisateur
	 * 	pour un ajout ou une suppression dans sa bibliothèque
	 * </p>
	 * 
	 * @see GestionTopoAction#setQuantiteTopo(String)
	 * @see GestionTopoAction#doAddLibrary()
	 * @see GestionTopoAction#doRemoveLibrary()
	 */
	private String quantiteTopo;
	
	
	
	// ------------------------ Elements en sortie ------------------------
	
	
	/**
	 * <p>Object servant à stocker une liste de l'objet 'Topo'</p>
	 * 
	 * @see GestionTopoAction#getListTopo()
	 * @see GestionTopoAction#doList()
	 * @see Topo
	 */
	private List<Topo> listTopo;
	
	
	
	/**
	 * <p>
	 * 	Object servant à stocker la bibliothèque de l'utilisateur
	 * 	qui est composé de deux éléments :
	 * </p>
	 * <ul>
	 * 		<li>L'objet 'Utilisateur'</li>
	 * 		<li>L'objet 'Topo'</li>
	 * 		<li>L'objet 'quantite' associé</li>
	 * </ul>
	 * 
	 * @see GestionTopoAction#getBibliotheque()
	 * @see GestionTopoAction#doLibrary()
	 * @see Topo
	 * @see TamponProprietaireTopo
	 */
	private List<TamponProprietaireTopo> bibliotheque;
	
	
	
	/**
	 * <p>Objet 'Topo' servant à stocker les details d'un topo</p>
	 * 
	 * @see GestionTopoAction#getTopo()
	 * @see GestionTopoAction#doDetail()
	 * @see Topo
	 */
	private Topo topo;
	
	
	
	/**
	 * <p>Object servant à stocker une liste d'objet "Site"</p>
	 * 
	 * @see GestionTopoAction#getListSite()
	 * @see GestionTopoAction#doDetail()
	 * @see Site
	 */
	private List<Site> listSite;
	
	
	
	/**
	 * <p>Object servant à stocker une liste d'objet "CommentaireTopo"</p>
	 * 
	 * @see GestionTopoAction#getListCommentaire()
	 * @see GestionTopoAction#doDetail()
	 * @see CommentaireTopo
	 */
	private List<CommentaireTopo> listCommentaire;
	
	
	
	// ------------------------ Elements en entrée et sortie ------------------------

	
	
	/**
	 * <p>Objet servant à stocker un id de topo</p>
	 * 
	 * @see GestionTopoAction#setIdTopo(int)
	 * @see GestionTopoAction#doDetail()
	 * @see GestionTopoAction#doAddLibrary()
	 * @see GestionTopoAction#doRemoveLibrary()
	 * @see GestionTopoAction#doAddComment()
	 */
	private String idTopo;
	
	
	
	
	// --------------------------------- Setters ---------------------------------
	
	
	
	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @see GestionTopoAction#request
	 * @see ServletRequestAware
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'managerFactory'</p>
	 * 
	 * @see GestionTopoAction#managerFactory
	 * @see ManagerFactory
	 */
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	
	
	
	/**
	 * <p>Setter servant à Spring pour injecter et donc définir l'objet 'resourcesBundle'</p>
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public void setResourcesBundle(ResourcesBundle resourcesBundle) {
		this.resourcesBundle = resourcesBundle;
	}
	
	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresType' en fonction 
	 * 	des	paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @see GestionTopoAction#criteresType
	 */
	public void setCriteresType(String criteresType) {
		this.criteresType = this.inputFormat(criteresType);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresOrientation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @see GestionTopoAction#criteresOrientation
	 */
	public void setCriteresOrientation(String criteresOrientation) {
		this.criteresOrientation = this.inputFormat(criteresOrientation);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresLocalisation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @see GestionTopoAction#criteresLocalisation
	 */
	public void setCriteresLocalisation(String criteresLocalisation) {
		this.criteresLocalisation = this.inputFormat(criteresLocalisation);
	}

	
	
	/**
	 * <p>Setter servant aux vues 'topo.jsp' & 'bibliotheque.jsp' pour définir l'objet 'idTopo'</p>
	 * 
	 * @see GestionTopoAction#idTopo
	 */
	public void setIdTopo(int idTopo) {
		try {

			this.idTopo = String.valueOf(idTopo);

		}catch(Exception e) {}
		
	}

	
	
	/**
	 * <p>Setter servant à la vue 'topo.jsp' pour définir l'objet 'contenu'</p>
	 * 
	 * @see GestionTopoAction#contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = this.inputFormat(contenu);
	}
	
	
	
	/**
	 * <p>Setter servant aux vues 'topo.jsp' & 'bibliotheque.jsp' pour définir l'objet 'quantiteTopo'</p>
	 * 
	 * @see GestionTopoAction#quantiteTopo
	 */
	public void setQuantiteTopo(String quantiteTopo) {
		this.quantiteTopo = this.inputFormat(quantiteTopo);
	}

	
	
	// --------------------------------- Getters ---------------------------------	
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listTopo' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @see GestionTopoAction#listTopo
	 */
	public List<Topo> getListTopo() {
		return listTopo;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'bibliotheque' depuis la vue 'bibliotheque.jsp'</p>
	 * 
	 * @see GestionTopoAction#bibliotheque
	 */
	public List<TamponProprietaireTopo> getBibliotheque() {
		return bibliotheque;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'topo' depuis la vue 'topo.jsp'</p>
	 * 
	 * @see GestionTopoAction#topo
	 */
	public Topo getTopo() {
		return topo;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listSite' depuis la vue 'topo.jsp'</p>
	 * 
	 * @see GestionTopoAction#listSite
	 */
	public List<Site> getListSite() {
		return listSite;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listCommentaire' depuis la vue 'topo.jsp'</p>
	 * 
	 * @see GestionTopoAction#listCommentaire
	 */
	public List<CommentaireTopo> getListCommentaire() {
		return listCommentaire;
	}
	

	
	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'idTopo' depuis struts.xml</p>
	 * <p>Plus precisement l'action, 'topo_comment' / 'add_library'</p>
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 */
	public String getIdTopo() {
		return idTopo;
	}
	
	
	
	// --------------------------------- Methodes ---------------------------------
	
	
	
	/**
	 * <p>Méthode servant à récuperer le catalogue de topo avec ou sans critères de recherche.</p>
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
	 * @see GestionTopoAction#criteresType
	 * @see GestionTopoAction#criteresOrientation
	 * @see GestionTopoAction#criteresLocalisation
	 * @see GestionTopoAction#resourcesBundle
	 * @see GestionTopoAction#managerFactory
	 * @see TopoManager#getList(String, String, String)
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
			listTopo = managerFactory.getTopoManager().getList(criteresType, criteresOrientation, criteresLocalisation);
		}catch(Exception e) {
			this.addActionError("Une erreur s'est produit, veuillez reessayer plus tard...");
			vResult = ActionSupport.ERROR;
		}
		
		return vResult;
	}

	
	
	/**
	 * <p>Méthode servant à récuperer les détails d'un topo.</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' 
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#topo
	 * @see GestionTopoAction#listSite
	 * @see GestionTopoAction#listCommentaire
	 * @see GestionTopoAction#managerFactory
	 * @see TopoManager#getCheckTopo(String)
	 * @see TopoManager#getTopo(String)
	 * @see TopoManager#getList(String, String, String)
	 * @see CommentaireTopoManager#getList(String)
	 */
	public String doDetail() {

		String vResult = ActionSupport.SUCCESS;

		try {
			if(idTopo != null && !idTopo.isEmpty() && managerFactory.getTopoManager().getCheckTopo(idTopo)) {
				topo = managerFactory.getTopoManager().getTopo(idTopo);
				listSite = managerFactory.getSiteManager().getList(idTopo);
				listCommentaire = managerFactory.getCommentaireTopoManager().getList(idTopo);
			}
			else {
				vResult = ActionSupport.ERROR;
				this.addActionError("Le topo demandé est inconnu.");
			}
		}catch(Exception e) {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
			e.printStackTrace();
		}
		return vResult;
		
	}
	
	
	
	/**
	 * <p>Méthode servant à récuperer la bibliothèque d'un utilisateur</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' 
	 * 
	 *  @see GestionTopoAction#request
	 *  @see GestionTopoAction#bibliotheque
	 *  @see GestionTopoAction#managerFactory
	 *  @see TamponProprietaireTopoManager#getLibrary(int)
	 */
	public String doLibrary() {
		String vResult = ActionSupport.SUCCESS;
		
		try {
			int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
			bibliotheque = managerFactory.getTamponProprietaireTopoManager().getBibliotheque(idUtilisateur);
		}catch(Exception e) {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
		}

		return vResult;
	}

	
	
	/**
	 * <p>Méthode servant à ajouter un ou plusieurs même topo dans une bibliothèque utilisateur</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#quantiteTopo
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
	 */
	public String doAddLibrary() {
		
		String vResult = ActionSupport.SUCCESS;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			if(quantiteTopo != null && !quantiteTopo.isEmpty() && !quantiteTopo.equals("0") && !quantiteTopo.contains("-")) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getTamponProprietaireTopoManager().addTampon(idUtilisateur, idTopo, Integer.valueOf(quantiteTopo))) {
						
						this.addActionMessage("Le topo a été ajouté à votre bibliothèque avec succès.");
						
					}
					else {
						vResult = ActionSupport.ERROR;
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}catch(Exception e) {
					vResult = ActionSupport.INPUT;
					this.addFieldError("quantiteTopo", "Ce champs ne doit comporter que des chiffres.");
				}
			}
			else {
				vResult = ActionSupport.INPUT;
				this.addFieldError("quantiteTopo", "Ce champs est vide");
			}
		}
		else {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
		}
		
		return vResult;
	}

	
	
	/**
	 * <p>Méthode servant à supprimer un ou plusieurs même topo d'une bibliothèque utilisateur.</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#quantiteTopo
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
	 */
	public String doRemoveLibrary() {
		
		String vResult = ActionSupport.INPUT;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			if(quantiteTopo != null && !quantiteTopo.isEmpty() && !quantiteTopo.equals("0") && !quantiteTopo.contains("-") ) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getTamponProprietaireTopoManager().removeTampon(idUtilisateur, idTopo, Integer.valueOf(quantiteTopo))) {
						
						vResult = ActionSupport.SUCCESS;
						this.addActionMessage("Le topo a été retiré de votre bibliothèque avec succès.");
						
					}
					else {
						this.addActionError("Retrait impossible. Verifier que vous possédez un nombre suffisant de topo et que tous les prêts les concernants ont été traités...");
					}
				}catch(Exception e) {
					this.addFieldError("quantiteTopo", "Ce champs ne doit comporter que des chiffres.");
				}
			}
			else {
				this.addFieldError("quantiteTopo", "Ce champs est vide");
			}
		}
		else {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
		}
		
		return vResult;
		
	}

	
	
	/**
	 * <p>Méthode servant à ajouter un commentaire à un topo</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#contenu
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see GestionTopoAction#contenuValidation(String)
	 */
	public String doAddComment() {
		String vResult = ActionSupport.SUCCESS;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			if(contenu != null && !contenu.isEmpty() && this.contenuValidation(contenu)) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getCommentaireTopoManager().addComment(idUtilisateur, idTopo, contenu)) {
						this.addActionMessage("Le commentaire a été ajouté avec succès.");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
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
			this.addActionError("Topo inconnu, ajout de commentaire impossible");
		}

		return vResult;		
	}
	
	
	
	/**
	 * 
	 * <p>Méthode servant à formatter toutes les entrées saisi par l'utilisateur</p>
	 * <p>Vérification de l'entrée puis formattage en retirant tous les espaces superflus</p>
	 * 
	 * @param input La saisi de l'utilisateur
	 * @return La saisi de l'utilisateur à présent formatté
	 * 
	 * @see GestionTopoAction#setContenu(String)
	 * @see GestionTopoAction#setQuantiteTopo(String)
	 * @see GestionTopoAction#setCriteresType(String)
	 * @see GestionTopoAction#setCriteresLocalisation(String)
	 * @see GestionTopoAction#setCriteresOrientation(String)
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
	 * @see GestionTopoAction#contenu
	 * @see GestionTopoAction#doAddComment()
	 */
	public Boolean contenuValidation(String contenu) {
		
		int longueurMin = 25, longueurMax = 500;
		
		Boolean vReturn = false;
		
		
		if(contenu.length() >= longueurMin && contenu.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}
	
}	
