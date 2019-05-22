package fr.openclassrooms.projet_6.webapp.action;

import java.util.ArrayList;
import java.util.LinkedList;
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
import fr.openclassrooms.projet_6.webapp.interceptor.IndexInterceptor;
import fr.openclassrooms.projet_6.webapp.validator.InputValidation;

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
 * 		<li>Deposer un commentaire (sur une fiche de topo) => doAddComment()</li>
 * </ul>
 * 
 * 
 * @see GestionTopoAction#doList()
 * @see GestionTopoAction#doDetail()
 * @see GestionTopoAction#doLibrary()
 * @see GestionTopoAction#doAddLibrary()
 * @see GestionTopoAction#doRemoveLibrary()
 * @see GestionTopoAction#doAddComment()
 * @see GestionTopoAction#SPACE
 * @see GestionTopoAction#request
 * @see GestionTopoAction#managerFactory
 * @see GestionTopoAction#resourcesBundle
 * @see GestionTopoAction#inputValidation
 * @see GestionTopoAction#contenu
 * @see GestionTopoAction#quantiteTopo
 * @see GestionTopoAction#listTopo
 * @see GestionTopoAction#bibliotheque
 * @see GestionTopoAction#topo
 * @see GestionTopoAction#listSite
 * @see GestionTopoAction#listCommentaire
 * @see GestionTopoAction#criteresType
 * @see GestionTopoAction#criteresOrientation
 * @see GestionTopoAction#criteresLocalisation
 * @see GestionTopoAction#idTopo
 * @see GestionTopoAction#contenuCom
 * @see GestionTopoAction#idProprietaire
 * @see GestionTopoAction#listTamponProprietaireTopo
 * @see GestionTopoAction#setServletRequest(HttpServletRequest)
 * @see GestionTopoAction#setManagerFactory(ManagerFactory)
 * @see GestionTopoAction#setResourcesBundle(ResourcesBundle)
 * @see GestionTopoAction#setInputValidation(InputValidation)
 * @see GestionTopoAction#setCriteresType(String)
 * @see GestionTopoAction#setCriteresOrientation(String)
 * @see GestionTopoAction#setCriteresLocalisation(String)
 * @see GestionTopoAction#setIdTopo(int)
 * @see GestionTopoAction#setIdProprietaire(String)
 * @see GestionTopoAction#setContenu(String)
 * @see GestionTopoAction#setContenuCom(String)
 * @see GestionTopoAction#setQuantiteTopo(String)
 * @see GestionTopoAction#getSPACE()
 * @see GestionTopoAction#getListTopo()
 * @see GestionTopoAction#getBibliotheque()
 * @see GestionTopoAction#getTopo()
 * @see GestionTopoAction#getListSite()
 * @see GestionTopoAction#getListCommentaire()
 * @see GestionTopoAction#getListTamponProprietaireTopo()
 * @see GestionTopoAction#getResourcesBundle()
 * @see GestionTopoAction#getCriteresType()
 * @see GestionTopoAction#getCriteresOrientation()
 * @see GestionTopoAction#getCriteresLocalisation()
 * @see GestionTopoAction#getIdTopo()
 * @see GestionTopoAction#getContenu()
 * @see GestionTopoAction#getContenuCom()
 * @see GestionTopoAction#getIdProprietaire()
 * @see GestionTopoAction#getQuantiteTopo()
 * @see ResourcesBundle
 * @see InputValidation
 * @see GestionPretAction
 * @see GestionSiteAction
 * @see GestionUtilisateurAction
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
public class GestionTopoAction extends ActionSupport implements ServletRequestAware {
	
	
	/**
	 * 	<p>Objet servant à stocker un formattage</p>
	 * 
	 * @see GestionTopoAction#getSPACE()
	 */
	private final String SPACE = "  --  ";
	
	
	
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
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'InputValidation'</p>
	 * 
	 * @see GestionTopoAction#setCriteresType(String)
	 * @see GestionTopoAction#setCriteresOrientation(String)
	 * @see GestionTopoAction#setCriteresLocalisation(String)
	 * @see GestionTopoAction#setIdTopo(String)
	 * @see GestionTopoAction#setIdProprietaire(String)
	 * @see GestionTopoAction#setContenu(String)
	 * @see GestionTopoAction#setContenuCom(String)
	 * @see GestionTopoAction#setQuantiteTopo(String)
	 * @see GestionTopoAction#setInputValidation(InputValidation)
	 * @see InputValidation
	 */
	private InputValidation inputValidation;
		
	
	
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
	* <p>Objet servant à stocker le critère de type choisi par l'utilisateur</p>
	* 
	* @see GestionTopoAction#getCriteresType()
	* @see GestionTopoAction#setCriteresType(String)
	* @see GestionTopoAction#doList()
	*/
	private String criteresType;
		
		
		
	/**
	* <p>Objet servant à stocker le critère d'orientation choisi par l'utilisateur</p>
	* 
	* @see GestionTopoAction#getCriteresOrientation()
	* @see GestionTopoAction#setCriteresOrientation(String)
	* @see GestionTopoAction#doList()
	*/
	private String criteresOrientation;
		
		
		
	/**
	* <p>Objet servant à stocker le critère de localisation choisi par l'utilisateur</p>
	* 
	* @see GestionTopoAction#getCriteresLocalisation()
	* @see GestionTopoAction#setCriteresLocalisation(String)
	* @see GestionTopoAction#doList()
	*/
	private String criteresLocalisation;

	
	
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
	
	
	
	/**
	 * <p>Objet servant à stocker le contenu du message de pret saisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setContenu(String)
	 */
	private String contenu;
	
	
	
	/**
	 * <p>Objet servant à stocker le contenu du commentaire saisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setContenuCom(String) 
	 * @see GestionTopoAction#doAddComment()
	 */
	private String contenuCom;
	
	
	/**
	 * <p>Objet servant à stocker l'id du proprietaire choisi par l'utilisateur</p>
	 * 
	 * @see GestionTopoAction#setIdProprietaire(String)
	 */
	private String idProprietaire;
	
	
	
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
	
	
	
	/**
	 * <p>Objet servant à stocker une liste de TamponProprietaireTopo</p>
	 * 
	 * @see GestionTopoAction#doDetail()
	 * @see GestionTopoAction#getListTamponProprietaireTopo()
	 */
	private List<TamponProprietaireTopo> listTamponProprietaireTopo;
	
	
		
	// --------------------------------- Setters ---------------------------------
	
	
	
	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @param request La requête en cours
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
	 * @param managerFactory Une instance de la classe 'ManagerFactory'
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
	 * @param resourcesBundle Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionTopoAction#resourcesBundle
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
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation
	 */
	public void setInputValidation(InputValidation inputValidation) {
		this.inputValidation = inputValidation;
	}
	
	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresType' en fonction 
	 * 	des	paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @param criteresType Un critère de type
	 * 
	 * @see GestionTopoAction#criteresType
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresType(String criteresType) {
		this.criteresType = inputValidation.inputFormat(criteresType);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresOrientation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @param criteresOrientation Un critère d'orientation
	 * 
	 * @see GestionTopoAction#criteresOrientation
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresOrientation(String criteresOrientation) {
		this.criteresOrientation = inputValidation.inputFormat(criteresOrientation);
	}

	
	
	/**
	 * <p>
	 * 	Setter servant à la vue 'list-topo.jsp' pour définir l'objet 'criteresLocalisation' en fonction 
	 * 	des paramètres reçu en entrée du formulaire présent dans la page 'list-topo.jsp'
	 * </p>
	 * 
	 * @param criteresLocalisation Un critère de localisatopn
	 * 
	 * @see GestionTopoAction#criteresLocalisation
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setCriteresLocalisation(String criteresLocalisation) {
		this.criteresLocalisation = inputValidation.inputFormat(criteresLocalisation);
	}

	
	
	/**
	 * <p>Setter servant aux vues 'topo.jsp' & 'bibliotheque.jsp' pour définir l'objet 'idTopo'</p>
	 * 
	 * @param idTopo Un identifiant de topo
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdTopo(String idTopo) {
		this.idTopo = inputValidation.inputFormat(idTopo);		
	}

	
	
	/**
	 * <p>Setter servant à la vue 'topo.jsp' pour définir l'objet 'idProprietaire'</p>
	 * 
	 * @param idProprietaire L'identifiant du proprietaire
	 * 
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdProprietaire(String idProprietaire) {		
			this.idProprietaire = inputValidation.inputFormat(idProprietaire);
	}



	/**
	 * <p>Setter servant à la vue 'topo.jsp' pour définir l'objet 'contenu'</p>
	 * 
	 * @param contenu Le contenu du message de la demande de pret
	 * 
	 * @see GestionTopoAction#contenu
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setContenu(String contenu) {
		this.contenu = inputValidation.inputFormat(contenu);
	}
	
	
	/**
	 * <p>Setter servant à la vue 'topo.jsp' pour définir l'objet 'contenuCom'</p>
	 * 
	 * @param contenuCom Le contenu du commentaire
	 * 
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setContenuCom(String contenuCom) {
		this.contenuCom = inputValidation.inputFormat(contenuCom);
	}



	/**
	 * <p>Setter servant aux vues 'topo.jsp' & 'bibliotheque.jsp' pour définir l'objet 'quantiteTopo'</p>
	 * 
	 * @param La quantité de topo
	 * 
	 * @see GestionTopoAction#quantiteTopo
	 * @see GestionTopoAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setQuantiteTopo(String quantiteTopo) {
		this.quantiteTopo = inputValidation.inputFormat(quantiteTopo);
	}

	
	
	// --------------------------------- Getters ---------------------------------	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'SPACE' depuis la vue 'topo.jsp'</p>
	 * 
	 * @return L'objet 'SPACE'
	 * 
	 * @see GestionTopoAction#SPACE
	 */
	public String getSPACE() {
		return SPACE;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'listTopo' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @return Un liste d'instance de la classe 'Topo'
	 * 
	 * @see GestionTopoAction#listTopo
	 * @see Topo
	 */
	public List<Topo> getListTopo() {
		return listTopo;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'bibliotheque' depuis la vue 'bibliotheque.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'TamponProprietaireTopo'
	 * 
	 * @see GestionTopoAction#bibliotheque
	 * @see TamponProprietaireTopo
	 */
	public List<TamponProprietaireTopo> getBibliotheque() {
		return bibliotheque;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'topo' depuis la vue 'topo.jsp'</p>
	 * 
	 * @return Une instance de la classe 'Topo'
	 * 
	 * @see GestionTopoAction#topo
	 * @see Topo
	 */
	public Topo getTopo() {
		return topo;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listSite' depuis la vue 'topo.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'Site'
	 * 
	 * @see GestionTopoAction#listSite
	 * @see Site
	 */
	public List<Site> getListSite() {
		return listSite;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listCommentaire' depuis la vue 'topo.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'CommentaireTopo'
	 * 
	 * @see GestionTopoAction#listCommentaire
	 * @see CommentaireTopo
	 */
	public List<CommentaireTopo> getListCommentaire() {
		return listCommentaire;
	}
	

	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listTamponProprietaireTopo' depuis la vue 'topo.jsp'</p>
	 * 
	 * @return  Une liste d'instance de la classe 'listTamponProprietaireTopo'
	 * 
	 * @see GestionTopoAction#listTamponProprietaireTopo
	 * @see TamponProprietaireTopo
	 */
	public List<TamponProprietaireTopo> getListTamponProprietaireTopo() {
		return listTamponProprietaireTopo;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @return Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresType' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @return Un critère de type
	 * 
	 * @see GestionTopoAction#criteresType
	 */
	public String getCriteresType() {
		return criteresType;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresOrientation' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @return Un critère d'orientation
	 * 
	 * @see GestionTopoAction#criteresOrientation
	 */
	public String getCriteresOrientation() {
		return criteresOrientation;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'criteresLocalisation' depuis la vue 'list-topo.jsp'</p>
	 * 
	 * @return Un critère de localisation
	 * 
	 * @see GestionTopoAction#criteresLocalisation
	 */
	public String getCriteresLocalisation() {
		return criteresLocalisation;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'idTopo' depuis struts.xml</p>
	 * <p>Plus precisement l'action, 'topo_comment' / 'add_library'</p>
	 * 
	 * @return Un identifiant de topo
	 * 
	 * @see GestionTopoAction#resourcesBundle
	 */
	public String getIdTopo() {
		return idTopo;
	}

	
	
	/**
	 * <p>Getter permettant à la vue 'topo.jsp' de récupérer le champs 'contenu' après un input</p>
	 * 
	 * @return Le contenu du message de la demande de pret
	 * 
	 * @see GestionTopoAction#contenu
	 */
	public String getContenu() {
		return contenu;
	}

	

	/**
	 * <p>Getter permettant à la vue 'topo.jsp' de récupérer le champs 'contenuCom' après un input</p>
	 * 
	 * @return Le contenu du commentaire
	 * 
	 * @see GestionTopoAction#contenuCom
	 */
	public String getContenuCom() {
		return contenuCom;
	}


	
	/**
	 * <p>Getter permettant à la vue 'topo.jsp' de récupérer le champs 'idProprietaire' après un input</p>
	 * 
	 * @return L'identifiant du proprietaire
	 * 
	 * @see GestionTopoAction#idProprietaire
	 */
	public String getIdProprietaire() {
		return idProprietaire;
	}



	/**
	 * <p>Permet aux vues 'bibliotheque.jsp', 'topo.jsp' de récupérer le champs 'quantiteTopo' après un input</p>
	 * 
	 * @return La quantite de topo saisi
	 * 
	 * @see GestionTopoAction#quantiteTopo
	 */
	public String getQuantiteTopo() {
		return quantiteTopo;
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
	 * @see GestionTopoAction#listTopo
	 * @see TopoManager#getList(String, String, String)
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
	 * @see GestionTopoAction#listTamponProprietaireTopo
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see TopoManager#getCheckTopo(String)
	 * @see TopoManager#getTopo(String)
	 * @see TopoManager#getList(String, String, String)
	 * @see CommentaireTopoManager#getList(String)
	 * @see Request
	 */
	public String doDetail() {

		String vResult = ActionSupport.SUCCESS;

		try {
			if(idTopo != null && !idTopo.isEmpty() && managerFactory.getTopoManager().getCheckTopo(idTopo)) {
				topo = managerFactory.getTopoManager().getTopo(idTopo);
				listSite = managerFactory.getSiteManager().getList(idTopo);
				listCommentaire = managerFactory.getCommentaireTopoManager().getList(idTopo);
				
				String idUtilisateur = null;
				try {
					idUtilisateur = String.valueOf(((Utilisateur) request.getSession(false).getAttribute("utilisateur")).getIdUtilisateur());
				}catch(Exception e) {}
				listTamponProprietaireTopo = managerFactory.getTamponProprietaireTopoManager().getList(idTopo, idUtilisateur);
				
				// Si aucune liaison evite le null pour eviter exception topo.jsp dans le choix du proprio
				if(listTamponProprietaireTopo == null) {
					listTamponProprietaireTopo = new ArrayList<TamponProprietaireTopo>();
				}
			}
			else {
				vResult = ActionSupport.ERROR;
				this.addActionError("Le topo demandé est inconnu.");
			}
		}catch(Exception e) {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
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
		
		if(this.getText("pret.etat1") != null && this.getText("pret.etat2") != null && !this.getText("pret.etat1").isEmpty() && !this.getText("pret.etat2").isEmpty()) {
			try {
				int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
				bibliotheque = managerFactory.getTamponProprietaireTopoManager().getBibliotheque(idUtilisateur, this.getText("pret.etat1"), this.getText("pret.etat2"));
				
				// Dans le cas où l'utilisateur n'a jamais eu de topo (même avec quantite = 0 d'enregistré)
				if(bibliotheque == null) {
					bibliotheque = new LinkedList<TamponProprietaireTopo>();
				}
			}catch(Exception e) {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
			}
		}
		else {
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
		
		String vResult = ActionSupport.INPUT;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			if(quantiteTopo != null && !quantiteTopo.isEmpty()) {
				try {
					try {
						if(Integer.valueOf(quantiteTopo) > 0) {
							int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
							
							if(managerFactory.getTamponProprietaireTopoManager().addTampon(idUtilisateur, idTopo, Integer.valueOf(quantiteTopo))) {
								
								vResult = ActionSupport.SUCCESS;
								this.addActionMessage("Le topo a été ajouté à votre bibliothèque avec succès.");
								
							}
							else {
								vResult = ActionSupport.ERROR;
								this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
							}
						}
						else {
							this.addFieldError("quantiteTopo", "La quantite doit être supérieur à 0.");
						}
					}catch(NumberFormatException e) {
						this.addFieldError("quantiteTopo", "Ce champs ne doit comporter que des chiffres.");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
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
	 * <p>Méthode servant à supprimer un ou plusieurs même topo d'une bibliothèque utilisateur.</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#quantiteTopo
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see TamponProprietaireTopoManager#getCheckQuantity(int, String, int)
	 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
	 */
	public String doRemoveLibrary() {
		
		String vResult = ActionSupport.INPUT;
		Boolean fieldError = false;
		
		
		if(idTopo == null || idTopo.isEmpty() ) {
			this.addFieldError("idTopo", "Ce champs est vide");
			fieldError = true;
		}
		if(quantiteTopo == null || quantiteTopo.isEmpty()) {
			this.addFieldError("quantiteTopo", "Ce champs est vide");
			fieldError = true;
		}
		else {
			try {
				if(Integer.valueOf(quantiteTopo) <= 0) {
					this.addFieldError("quantiteTopo", "La quantite doit être supérieur à 0.");
				}
			}catch (NumberFormatException e) {
				this.addFieldError("quantiteTopo", "Ce champs ne doit comporter que des chiffres.");
				fieldError = true;
			}
		}
		
		
		
		if(!fieldError) {
			try {

				int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
						
				if(this.managerFactory.getTamponProprietaireTopoManager().getCheckQuantity(idUtilisateur, idTopo, Integer.valueOf(quantiteTopo))) {

					if(managerFactory.getTamponProprietaireTopoManager().removeTampon(idUtilisateur, idTopo, Integer.valueOf(quantiteTopo))) {
								
						vResult = ActionSupport.SUCCESS;
						this.addActionMessage("Le topo a été retiré de votre bibliothèque avec succès.");
								
					}
					else {
						vResult = ActionSupport.ERROR;
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}
				else {
					this.addFieldError("quantiteTopo", "La quantite doit être inférieur ou égal à la différence entre la quantité possédé et la quantité réservé/prêté.");
				}

		}catch(Exception e) {
			vResult = ActionSupport.ERROR;
			this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
		}
	}
		
	return vResult;
		
	}

	
	
	/**
	 * <p>Méthode servant à ajouter un commentaire à un topo</p>
	 * 
	 * @return Retourne le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionTopoAction#idTopo
	 * @see GestionTopoAction#contenuCom
	 * @see GestionTopoAction#request
	 * @see GestionTopoAction#managerFactory
	 * @see GestionTopoAction#inputValidation
	 * @see CommentaireTopoManager#addComment(int, String, String)
	 * @see InputValidation#messageValidation(String)
	 * @see InputValidation#getMIN_CONTENU()
	 * @see InputValidation#getMAX_CONTENU()
	 */
	public String doAddComment() {
		String vResult = ActionSupport.SUCCESS;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			if(contenuCom != null && !contenuCom.isEmpty() && inputValidation.messageValidation(contenuCom)) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(managerFactory.getCommentaireTopoManager().addComment(idUtilisateur, idTopo, contenuCom)) {
						this.addActionMessage("Le commentaire a été ajouté avec succès.");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
			}
			else {
				vResult = ActionSupport.INPUT;
				this.addFieldError("contenuCom", "Le commentaire doit etre compris entre "+inputValidation.getMIN_CONTENU()+" et "+inputValidation.getMAX_CONTENU()+" caractères.");
			}
		}
		else {
			vResult = ActionSupport.ERROR;
			this.addActionError("Topo inconnu, ajout de commentaire impossible");
		}

		return vResult;		
	}
		
}	
