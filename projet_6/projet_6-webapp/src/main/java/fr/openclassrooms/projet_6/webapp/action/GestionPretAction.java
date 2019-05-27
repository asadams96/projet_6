package fr.openclassrooms.projet_6.webapp.action;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessagePretManager;
import fr.openclassrooms.projet_6.business.contract.manager.pret.PretManager;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;
import fr.openclassrooms.projet_6.webapp.bundle.ResourcesBundle;
import fr.openclassrooms.projet_6.webapp.interceptor.AuthentificationInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.EncodingInterceptor;
import fr.openclassrooms.projet_6.webapp.interceptor.IndexInterceptor;
import fr.openclassrooms.projet_6.webapp.validator.InputValidation;
/**
 * <p>Classe gérant la gestion des prêts</p>
 * 
 * <p>Elle est implémenté de 7 actions :</p>
 * <ul>
 * 		<li>Afficher la liste des prêts / emprunts => doList()</li>
 * 		<li>Afficher les détails d'un prêt / emprunt => doDetail()</li>
 * 		<li>D'ajouter un message à un pret => doAddMessage()</li>
 * 		<li>De statuer sur une demande de prêt => doDecide()</li>
 * 		<li>D'annuler une demande prêt => doCancel()</li>
 * 		<li>De cloturer un prêt => doFinish()</li>
 * 		<li>De demander un prêt => doAsk()</li>
 * </ul>
 * 
 * 
 * @see GestionPretAction#logger
 * @see GestionPretAction#request
 * @see GestionPretAction#managerFactory
 * @see GestionPretAction#resourcesBundle
 * @see GestionPretAction#inputValidation
 * @see GestionPretAction#etat
 * @see GestionPretAction#type
 * @see GestionPretAction#idPret
 * @see GestionPretAction#contenu
 * @see GestionPretAction#idTopo
 * @see GestionPretAction#idProprietaire
 * @see GestionPretAction#pret
 * @see GestionPretAction#listPret
 * @see GestionPretAction#listMessage
 * @see GestionPretAction#getResourcesBundle()
 * @see GestionPretAction#getPret()
 * @see GestionPretAction#getListPret()
 * @see GestionPretAction#getListMessage()
 * @see GestionPretAction#getEtat()
 * @see GestionPretAction#getType()
 * @see GestionPretAction#getIdPret()
 * @see GestionPretAction#getIdTopo()
 * @see GestionPretAction#getIdProprietaire()
 * @see GestionPretAction#getContenu()
 * @see GestionPretAction#setServletRequest(HttpServletRequest)
 * @see GestionPretAction#setManagerFactory(ManagerFactory)
 * @see GestionPretAction#setInputValidation(InputValidation)
 * @see GestionPretAction#setResourcesBundle(ResourcesBundle)
 * @see GestionPretAction#setContenu(String)
 * @see GestionPretAction#setIdTopo(String)
 * @see GestionPretAction#setIdProprietaire(String)
 * @see GestionPretAction#setEtat(String)
 * @see GestionPretAction#setType(String)
 * @see GestionPretAction#setIdPret(String)
 * @see GestionPretAction#doList()
 * @see GestionPretAction#doDetail()
 * @see GestionPretAction#doAddMessage()
 * @see GestionPretAction#doDecide()
 * @see GestionPretAction#doCancel()
 * @see GestionPretAction#doFinish()
 * @see GestionPretAction#doAsk()
 * @see ResourcesBundle
 * @see InputValidation
 * @see GestionTopoAction
 * @see GestionSiteAction
 * @see GestionUtilisateurAction
 * @see AuthentificationInterceptor
 * @see EncodingInterceptor
 * @see IndexInterceptor
 * @see Topo
 * @see Message
 * @see MessagePret
 * @see Utilisateur
 * @see ManagerFactory
 * @see HttpServletRequest
 * @see ServletRequestAware
 * @see ActionSupport
 * @see Logger
 * @see LogManager#getLogger(Class)
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class GestionPretAction extends ActionSupport implements ServletRequestAware {
	
	
	
	/**
	 * <p>Logger de la classe 'GestionPretAction'</p>
	 * 
	 * @see Logger
	 * @see LogManager#getLogger(Class)
	 */
	private static Logger logger = LogManager.getLogger(GestionPretAction.class);
	
		
	
	/**
	 * <p>Objet servant à stocker la requête en cours</p>
	 * 

	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doDecide()
	 * @see GestionPretAction#doCancel()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#setServletRequest(HttpServletRequest) 
	 * @see HttpServletRequest
	 */
	private HttpServletRequest request;	
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ManagerFactory'</p>
	 * 
	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doDecide()
	 * @see GestionPretAction#doCancel()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#setManagerFactory(ManagerFactory)
	 * @see ManagerFactory
	 */
	private ManagerFactory managerFactory;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'ResourcesBundle'</p>
	 * 
	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#getResourcesBundle()
	 * @see GestionPretAction#setResourcesBundle(ResourcesBundle)
	 * @see ResourcesBundle
	 */
	private ResourcesBundle resourcesBundle;
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'InputValidation'</p>
	 * 
	 * @see GestionPretAction#setEtat(String)
	 * @see GestionPretAction#setType(String)
	 * @see GestionPretAction#setIdPret(String)
	 * @see GestionPretAction#setIdTopo(String)
	 * @see GestionPretAction#setIdProprietaire(String)
	 * @see GestionPretAction#setContenu(String)
	 * @see GestionPretAction#setInputValidation(InputValidation)
	 * @see InputValidation
	 */
	private InputValidation inputValidation;
	
	
		
	// --------------------------------- Éléments en entrée et sortie ---------------------------------
	
	
	/**
	 * <p>Objet servant à stocker l'etat d'un pret</p>
	 * 
	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#doDecide()
	 * @see GestionPretAction#doCancel()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#setEtat(String)
	 * @see GestionPretAction#getEtat()
	 */
	private String etat;
	
	
	
	/**
	 * <p>Objet servant à stocker le type d'un pret</p>
	 * 
	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#setType(String)
	 * @see GestionPretAction#getType()
	 */
	private String type;
	
	
	
	/**
	 * <p>Objet servant à stocker l'identifiant d'un pret</p>
	 * 
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doDecide()
	 * @see GestionPretAction#doCancel()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#setIdPret(String)
	 * @see GestionPretAction#getIdPret()
	 */
	private String idPret;
	
	
	
	/**
	 * <p>Objet servant à stocker le contenu du message de pret saisi par l'utilisateur</p>
	 * 
	 * @see GestionPretAction#getContenu()
	 * @see GestionPretAction#setContenu(String)
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doAsk()
	 */
	private String contenu;
	
	
	
	/**
	 * <p>Objet servant à stocker l'identifiant d'un topo</p>
	 * 
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#setIdTopo(String)
	 * @see GestionPretAction#getIdTopo()
	 */
	private String idTopo;
	
	
	
	/**
	 * <p>Objet servant à stocker l'identifiant d'un utilisateur proprietaire d'un topo</p>
	 * 
	 * @see GestionPretAction#doAsk()
	 * @see GestionPretAction#setIdProprietaire(String)
	 * @see GestionPretAction#getIdProprietaire()
	 */
	private String idProprietaire;
	
	
	
	// --------------------------------- Éléments en sortie ---------------------------------
	
	
	
	/**
	 * <p>Objet servant à stocker une instance de la classe 'Pret'</p>
	 * 
	 * @see GestionPretAction#doAddMessage()
	 * @see GestionPretAction#doDecide()
	 * @see GestionPretAction#doCancel()
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#doFinish()
	 * @see GestionPretAction#getPret()
	 * @see Pret
	 */
	private Pret pret;
	
	
	
	/**
	 * <p>Objet servant à stocker une liste d'instance de la classe 'Pret'</p>
	 * 
	 * @see GestionPretAction#doList()
	 * @see GestionPretAction#getListPret()
	 * @see Pret
	 */
	private List<Pret> listPret;
	
	
	
	/**
	 * <p>Objet servant à stocker une liste d'instance de la classe 'MessagePret'</p>
	 * 
	 * @see GestionPretAction#doDetail()
	 * @see GestionPretAction#getListMessage()
	 * @see MessagePret
	 */
	private List<MessagePret> listMessage;
	

	
	// --------------------------------- Getters ---------------------------------


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'resourcesBundle' depuis la vue 'list-pret.jsp'</p>
	 * 
	 * @return Une instance de la classe 'ResourcesBundle'
	 * 
	 * @see GestionPretAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public ResourcesBundle getResourcesBundle() {
		return resourcesBundle;
	}


	
	/**
	 * <p>Getter permettant de récupérer l'objet 'pret' depuis la vue 'pret.jsp'</p>
	 * 
	 * @return Une instance de la classe 'Pret'
	 * 
	 * @see GestionPretAction#pret
	 * @see Pret
	 */
	public Pret getPret() {
		return pret;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'listPret' depuis la vue 'list-pret.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'Pret'
	 * 
	 * @see GestionPretAction#listPret
	 * @see Pret
	 */
	public List<Pret> getListPret() {
		return listPret;
	}
	
	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'listMessage' depuis la vue 'pret.jsp'</p>
	 * 
	 * @return Une liste d'instance de la classe 'MessagePret'
	 * 
	 * @see GestionPretAction#listMessage
	 * @see MessagePret
	 */
	public List<MessagePret> getListMessage() {
		return listMessage;
	}

	
	
	/**
	 * <p>Getter permettant de récupérer l'objet 'etat' depuis les vues 'pret.jsp et 'list-pret.jsp'</p>
	 * 
	 * @return Un String représentant l'etat d'un prêt
	 * 
	 * @see GestionPretAction#etat
	 */
	public String getEtat() {
		return etat;
	}



	/**
	 * <p>Getter permettant de récupérer l'objet 'type' depuis les vues 'pret.jsp et 'list-pret.jsp' et servant à l'interceptor dans struts.xml pour la vue 'pret.jsp'</p>
	 * 
	 * @return Un String représentant le type d'un prêt
	 * 
	 * @see GestionPretAction#type
	 */
	public String getType() {
		return type;
	}


	
	/**
	 * <p>>Getter servant à l'interceptor dans struts.xml pour pouvoir lire et envoyer l'objet 'idPret' à la vue 'pret.jsp'</p>
	 * 
	 * @return Un String représentant l'identifiant d'un prêt
	 * 
	 * @see GestionPretAction#idPret
	 */
	public String getIdPret() {
		return idPret;
	}
	
	
	
	/**
	 * <p>Getter servant à l'interceptor dans struts.xml pour pouvoir lire et envoyer l'objet 'idTopo' à la vue 'topo.jsp après un input' </p>
	 * 
	 * @return Un String représentant l'identifiant d'un topo
	 * 
	 * @see GestionPretAction#idTopo
	 */
	public String getIdTopo() {
		return idTopo;
	}



	/**
	 * <p>Getter servant à l'interceptor dans struts.xml pour pouvoir lire et envoyer l'objet 'idProprietaire' à la vue 'topo.jsp après un input' </p>
	 * 
	 * @return Un String représentant l'identifiant d'un topo
	 * 
	 * @see GestionPretAction#idProprietaire
	 */
	public String getIdProprietaire() {
		return idProprietaire;
	}



	/**
	 * <p>Permet à la vue 'pret.jsp' de récupérer le champs 'contenu' après un input</p>
	 * 
	 * @return Le contenu du commentaire
	 * 
	 * @see GestionSiteAction#contenu
	 */
	public String getContenu() {
		return contenu;
	}
	
	
	
	// --------------------------------- Setters -------------------------



	/**
	 * <p>Setter servant à définir l'objet 'request' grâce à l'interface 'ServletRequestAware'</p>
	 * 
	 * @param request La requête en cours
	 * 
	 * @see GestionPretAction#request
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
	 * @see GestionPretAction#managerFactory
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
	 * @see GestionPretAction#inputValidation
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
	 * @see GestionPretAction#resourcesBundle
	 * @see ResourcesBundle
	 */
	public void setResourcesBundle(ResourcesBundle resourcesBundle) {
		this.resourcesBundle = resourcesBundle;
	}
	
	
	
	/**
	 * <p>Setter servant à la vue 'site.jsp' pour définir l'objet 'contenu'</p>
	 * 
	 * @param Le contenu du commentaire
	 * 
	 * @see GestionPretAction#contenu
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setContenu(String contenu) {
		this.contenu = inputValidation.inputFormat(contenu);
	}

	
	/**
	 * <p>Setter servant à l'interceptor dans l'action pret_ask</p>
	 * 	
	 * @param idTopo L'identifiant d'un topo
	 * 
	 * @see GestionPretAction#idTopo
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdTopo(String idTopo) {
		this.idTopo = idTopo;
	}


	/**
	 * <p>Setter servant à l'interceptor dans l'action pret_ask</p>
	 * 
	 * @param idProprietaire L'identifiant du proprietaire d'un prêt
	 * 
	 * @see GestionPretAction#idProprietaire
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdProprietaire(String idProprietaire) {
		this.idProprietaire = idProprietaire;
	}


	/**
	 * <p>Setter servant aux vues 'list-pret.jsp' et 'pret.jsp' pour définir l'objet 'etat'</p>
	 * 
	 * @param etat L'état d'un prêt
	 * 
	 * @see GestionPretAction#etat
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}


	/**
	 * <p>Setter servant à l'interceptor (action pret_ask) et à la vue 'pret.jsp' pour définir l'objet 'type'</p>
	 * 
	 * @param type Le type d'un prêt
	 * 
	 * @see GestionPretAction#type
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * <p>Setter servant aux interceptors et à la vue 'pret.jsp' pour définir l'objet 'id_Pret'</p>
	 * 
	 * @param idPret L'identifiant d'un prêt
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#inputFormat(String)
	 */
	public void setIdPret(String idPret) {
		this.idPret = idPret;
	}
	
	
	
	// --------------------------------- Methodes ---------------------------------
	
	 

	/**
	 * <p>Méthode servant à récuperer la liste des prêts ou emprunts d'un utilisateur</p>
	 * <p>Les critères de filtres sont en rapport à l'etat des prêts :</p>
	 * <ul>
	 * 		<li>Demandé</li>
	 * 		<li>En cours</li>
	 * 		<li>Terminé</li>
	 * 		<li>Annulé</li>
	 * 		<li>Refusé</li>
	 * <ul>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error'
	 * 
	 * @see GestionPretAction#type
	 * @see GestionPretAction#resourcesBundle
	 * @see GestionPretAction#etat
	 * @see GestionPretAction#listPret
	 * @see GestionPretAction#request
	 * @see GestionPretAction#managerFactory
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ResourcesBundle#getListTypePret()
	 * @see ResourcesBundle#getListEtatPret()
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#getListPret(Utilisateur, String, String)
	 * @see PretManager#getListPret(Utilisateur, String)
	 * @see Utilisateur
	 * @see Pret
	 * @see ActionSupport
	 * 
	 */
	public String doList() {
		
		String vResult = ActionSupport.SUCCESS;
		
		
		if(type != null && !type.isEmpty() && resourcesBundle.getListTypePret().contains(type)) {
			
			Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
			if(utilisateur != null) {
				try {
					if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
					
						if(etat != null && !etat.isEmpty() && resourcesBundle.getListEtatPret().contains(etat)) {
							listPret = this.managerFactory.getPretManager().getListPret(utilisateur, etat, type);
						}
					else {
							listPret = this.managerFactory.getPretManager().getListPret(utilisateur, type);
						}
						
					}
					else {
						vResult = ActionSupport.ERROR;
						this.addActionError("1Une erreur s'est produite. Veuillez réessayer plus tard...");
					}
				}catch(Exception e) {
					vResult = ActionSupport.ERROR;
					this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
					
					StringWriter stackTrace = new StringWriter();
					e.printStackTrace(new PrintWriter(stackTrace));
					logger.error(stackTrace.toString());
				}
			}
			else {
				vResult = ActionSupport.ERROR;
				this.addActionError("2Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
			
		}
		else {
			vResult = ActionSupport.ERROR;
			this.addActionError("3Une erreur s'est produite. Veuillez réessayer plus tard...");
		}
	
	
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à afficher les details d'un prêt.</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error'
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#resourcesBundle
	 * @see GestionPretAction#type
	 * @see GestionPretAction#request
	 * @see GestionPretAction#managerFactory
	 * @see GestionPretAction#pret
	 * @see GestionPretAction#listMessage
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ResourcesBundle#getListTypePret()
	 * @see PretManager#getCheckPret(String)
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#getPret(String)
	 * @see MessagePretManager#getList(String)
	 * @see Pret
	 * @see utilisateur
	 * @see MessagePret
	 * @see ActionSupport
	 */
	public String doDetail() {
		
		String vResult = ActionSupport.ERROR;
		
		if(idPret != null && !idPret.isEmpty() && type!= null && resourcesBundle.getListTypePret().contains(type)) {
			
			Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
			
			if(utilisateur != null) {
				try {
					if(this.managerFactory.getPretManager().getCheckPret(idPret)) {
						if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
							
							pret = this.managerFactory.getPretManager().getPret(idPret);
							listMessage = this.managerFactory.getMessagePretManager().getList(idPret);
							
							
							if((pret.getProprietaire().getIdUtilisateur() == utilisateur.getIdUtilisateur() && type.equals(this.getText("pret.type1"))) || 
									(pret.getUtilisateur().getIdUtilisateur() == utilisateur.getIdUtilisateur() && type.equals(this.getText("pret.type2")))) {
								
								vResult = ActionSupport.SUCCESS;
							}
							else {
								pret = null;
								listMessage = null;
								vResult = "error-forbidden";
							}
							
						}
						else {
							this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
						}
					}
					else {
						this.addActionError("Le prêt demandé n'existe pas...");
					}
				}catch(Exception e) {
					this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
					
					StringWriter stackTrace = new StringWriter();
					e.printStackTrace(new PrintWriter(stackTrace));
					logger.error(stackTrace.toString());
				}
			}
			else {
				this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
			}
			
		}
		else {
			this.addActionError("Une erreur s'est produite. Veuillez réessayer plus tard...");
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à ajouter un message à un pret</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#contenu
	 * @see GestionPretAction#request
	 * @see GestionPretAction#managerFactory
	 * @see GestionPretAction#inputValidation
	 * @see InputValidation#messageValidation(String)
	 * @see InputValidation#getMIN_CONTENU()
	 * @see InputValidation#getMAX_CONTENU()
	 * @see UtilisateurManager#getCheckUtilisateur(String)
	 * @see MessagePretManager#addMessage(int, String, String)
	 * @see MessagePret
	 * @see Utilisateur
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ActionSupport
	 */
	public String doAddMessage() {
		String vResult = ActionSupport.ERROR;
		
		if(idPret != null && !idPret.isEmpty()) {
			if(contenu != null && !contenu.isEmpty() && inputValidation.messageValidation(contenu)) {
				try {
					int idUtilisateur = ((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur();
					
					if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(String.valueOf(idUtilisateur))) {
					
						if(managerFactory.getMessagePretManager().addMessage(idUtilisateur, idPret, contenu)) {
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("Le message a été ajouté avec succès.");
						}
						else {
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}
					}
					else {
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}catch(Exception e) {
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					
					StringWriter stackTrace = new StringWriter();
					e.printStackTrace(new PrintWriter(stackTrace));
					logger.error(stackTrace.toString());
				}
			}
			else {
				vResult = ActionSupport.INPUT;
				this.addFieldError("contenu", "Le message doit etre compris entre "+inputValidation.getMIN_CONTENU()+" et "+inputValidation.getMAX_CONTENU()+" caractères.");
			}
		}
		else {
			this.addActionError("Pret inconnu, ajout de message impossible");
		}

		return vResult;		
	}
	
		
	
	/**
	 * <p>Méthode servant à décider de l'issu de la demande de prêt</p>
	 * <p>Uniquement accessible au proprietaire du topo concerné par le pret lorsque l'état est à "Demandé"</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error'
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#etat
	 * @see GestionPretAction#request
	 * @see GestionPretAction#managerFactory
	 * @see GestionPretAction#pret
	 * @see PretManager#getPret(String)
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#decide(Pret, String, String, String, String, String)
	 * @see Utilisateur
	 * @see Pret
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ActionSupport
	 */
	public String doDecide() {
		
		String vResult = ActionSupport.ERROR;

		if(idPret != null && etat != null && !idPret.isEmpty() && (etat.equals(this.getText("pret.etat2")) || etat.equals(this.getText("pret.etat5")))) {

			try {
				Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
				
				if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
					
					pret = this.managerFactory.getPretManager().getPret(idPret);
					
					if(pret != null) {
						if(this.managerFactory.getPretManager().decide(pret, etat, String.valueOf(utilisateur.getIdUtilisateur()), 
												this.getText("pret.etat1"), this.getText("pret.etat2"), this.getText("pret.etat5"))) {
							
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("La modification a bien été prise en compte.");
						}
						else {
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}
					}
					else {
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}
				else {
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
								
			}catch(Exception e) {
				this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				
				StringWriter stackTrace = new StringWriter();
				e.printStackTrace(new PrintWriter(stackTrace));
				logger.error(stackTrace.toString());
			}
			
		}

		return vResult;
	}
	
	
		
	/**
	 * <p>Méthode servant à annuler une demande de prêt</p>
	 * <p>Uniquement accessible par l'utilisateur à l'origine du pret lorsque l'état est toujours à "Demandé"</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error'
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#etat
	 * @see GestionPretAction#request
	 * @see GestionPretAction#pret
	 * @see GestionPretAction#managerFactory
	 * @see PretManager#getPret(String)
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#cancel(Pret, String, String, String, String)
	 * @see Utilisateur
	 * @see Pret
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ActionSupport
	 * 
	 */
	public String doCancel() {
		
		String vResult = ActionSupport.ERROR;
		
		if(idPret != null && etat != null && !idPret.isEmpty() && !etat.isEmpty() && etat.equals(this.getText("pret.etat4"))) {
			try {
				Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
				
				if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
					
					pret = this.managerFactory.getPretManager().getPret(idPret);
					
					if(pret != null) {
						if(this.managerFactory.getPretManager().cancel(pret, etat, String.valueOf(utilisateur.getIdUtilisateur()), 
																			this.getText("pret.etat1"), this.getText("pret.etat4"))) {
							
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("La modification a bien été prise en compte.");
						}
						else {
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}
					}
					else {
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}
				else {
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
								
			}catch(Exception e) {
				this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				
				StringWriter stackTrace = new StringWriter();
				e.printStackTrace(new PrintWriter(stackTrace));
				logger.error(stackTrace.toString());
			}
			
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à cloturer un prêt</p>
	 * <p>Uniquement accessible par l'utilisateur à l'origine du pret lorsque l'état est  à "En cours"</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error'
	 * 
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#etat
	 * @see GestionPretAction#type
	 * @see GestionPretAction#request
	 * @see GestionPretAction#pret
	 * @see GestionPretAction#managerFactory
	 * @see PretManager#getPret(String)
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#finish(Pret, String, String, String, String)
	 * @see Utilisateur
	 * @see Pret
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ActionSupport
	 * 
	 */
	public String doFinish() {
		
		String vResult = ActionSupport.ERROR;
		
		if(idPret != null && type!= null && etat != null && !idPret.isEmpty() && etat.equals(this.getText("pret.etat3")) && type.equals(this.getText("pret.type1"))) {
			try {
				Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
				
				if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(utilisateur)) {
					
					pret = this.managerFactory.getPretManager().getPret(idPret);
					
					if(pret != null) {
						if(this.managerFactory.getPretManager().finish(pret, etat, String.valueOf(utilisateur.getIdUtilisateur()), 
																			this.getText("pret.etat2"), this.getText("pret.etat3"))) {
							
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("La modification a bien été prise en compte.");
						}
						else {
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}
					}
					else {
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
					}
				}
				else {
					this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				}
								
			}catch(Exception e) {
				this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
				
				StringWriter stackTrace = new StringWriter();
				e.printStackTrace(new PrintWriter(stackTrace));
				logger.error(stackTrace.toString());
			}
			
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à demander un prêt</p>
	 * 
	 * @return Le résultat de l'action : 'success' ou 'error' ou 'input'
	 * 
	 * @see GestionPretAction#idTopo
	 * @see GestionPretAction#idProprietaire
	 * @see GestionPretAction#type
	 * @see GestionPretAction#contenu
	 * @see GestionPretAction#request
	 * @see GestionPretAction#idPret
	 * @see GestionPretAction#inputValidation
	 * @see GestionPretAction#managerFactory
	 * @see PretManager#getPret(String)
	 * @see UtilisateurManager#getCheckUtilisateur(Utilisateur)
	 * @see PretManager#ask(String, String, String, String, String)
	 * @see Utilisateur
	 * @see Pret
	 * @see HttpServletRequest
	 * @see ServletRequestAware
	 * @see ActionSupport
	 * @see InputValidation#messageValidation(String)
	 * @see InputValidation#getMIN_CONTENU()
	 * @see InputValidation#getMAX_CONTENU()
	 * 
	 */
	public String doAsk() {
		
		String vResult = ActionSupport.INPUT;
		
		if(idTopo != null && idProprietaire != null && contenu != null && type != null && type.equals(this.getText("pret.type2"))) {
			
			if(!idTopo.isEmpty() && this.getText("pret.etat1") != null && !this.getText("pret.etat1").isEmpty()) {
				Boolean fieldError = false;
				
				if(idProprietaire.isEmpty()) {
					fieldError = true;
					this.addFieldError("idProprietaire", "Vous devez choisir un proprietaire.");
				}
				if(!inputValidation.messageValidation(contenu)) {
					fieldError = true;
					this.addFieldError("contenu", "Le message doit etre compris entre "+inputValidation.getMIN_CONTENU()+" et "+inputValidation.getMAX_CONTENU()+" caractères.");
				}
				
				if(!fieldError) {
					try {						
							
						String idUtilisateur = String.valueOf(((Utilisateur) request.getSession().getAttribute("utilisateur")).getIdUtilisateur());
							
						if(idUtilisateur != null && !idUtilisateur.isEmpty()) {
							if(this.managerFactory.getUtilisateurManager().getCheckUtilisateur(idUtilisateur)) {
								
								idPret = this.managerFactory.getPretManager().ask(idTopo, idProprietaire, idUtilisateur, contenu, this.getText("pret.etat1"));
							}
						}
						else {
							vResult = ActionSupport.ERROR;
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}
						if(idPret != null && !idPret.isEmpty()) {
							vResult = ActionSupport.SUCCESS;
							this.addActionMessage("La demande de prêt à bien été prise en compte.");
						}
						else {
							vResult = ActionSupport.ERROR;
							this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						}					
					}catch(Exception e) {
						vResult = ActionSupport.ERROR;
						this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
						
						StringWriter stackTrace = new StringWriter();
						e.printStackTrace(new PrintWriter(stackTrace));
						logger.error(stackTrace.toString());
					}	
				}
			} 
			else {
				vResult = ActionSupport.ERROR;
				this.addActionError("Une erreur s'est produit. Veuillez reessayer plus tard...");
			}
		}
		
		return vResult;
	}
	
}


