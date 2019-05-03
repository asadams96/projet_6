package fr.openclassrooms.projet_6.business.contract.manager;

import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessageManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessagePretManager;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponProprietaireTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponSiteTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.pret.PretManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SecteurManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.VoieManager;
import fr.openclassrooms.projet_6.business.contract.manager.topo.TopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireSiteManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessageManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessagePretManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponProprietaireTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponSiteTopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.pret.PretManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SecteurManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.SiteManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.site.VoieManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.topo.TopoManagerImpl;
import fr.openclassrooms.projet_6.business.impl.manager.utilisateur.UtilisateurManagerImpl;



/**
 * <p>Interface Factory de la couche consumer<p>
 * <p>Permet de définir et de lire chaque Manager</p>
 * <p>Setter/Getter présent dans la couche business dans la classe 'AbstractManager'<p>
 *  
 *  
 *  @see ManagerFactoryImpl
 *  @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
 *  @see ManagerFactory#getUtilisateurManager()
 *  @see ManagerFactory#setTopoManager(TopoManager)
 *  @see ManagerFactory#getTopoManager()
 *  @see ManagerFactory#setVoieManager(VoieManager)
 *  @see ManagerFactory#getVoieManager()
 *  @see ManagerFactory#setSecteurManager(SecteurManager)
 *  @see ManagerFactory#getSecteurManager()
 *  @see ManagerFactory#setSiteManager(SiteManager)
 *  @see ManagerFactory#getSiteManager()
 *  @see ManagerFactory#setPretManager(PretManager)
 *  @see ManagerFactory#getPretManager()
 *  @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 *  @see ManagerFactory#getTamponProprietaireTopoManager()
 *  @see ManagerFactory#setTamponSiteTopoManager(TamponSiteTopoManager)
 *  @see ManagerFactory#getTamponSiteTopoManager()
 *  @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
 *  @see ManagerFactory#getCommentaireTopoManager()
 *  @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
 *  @see ManagerFactory#getCommentaireSiteManager()
 *  @see ManagerFactory#setMessagePretManager(MessagePretManager)
 *  @see ManagerFactory#getMessagePretManager()
 *  @see ManagerFactory#setMessageManager(MessageManager)
 *  @see ManagerFactory#getMessageManager()
 *  @see UtilisateurManager
 * 	@see UtilisateurManagerImpl
 * 	@see MessageManager
 * 	@see MessageManagerImpl
 * 	@see MessagePretManager
 * 	@see MessagePretManagerImpl
 * 	@see CommentaireSiteManager
 * 	@see CommentaireSiteManagerImpl
 * 	@see CommentaireTopoManager
 * 	@see CommentaireTopoManagerImpl
 * 	@see TamponSiteTopoManager
 * 	@see TamponSiteTopoManagerImpl
 * 	@see TamponProprietaireTopoManager
 * 	@see TamponProprietaireTopoManagerImpl
 * 	@see PretManager
 * 	@see PretManagerImpl
 * 	@see SiteManager
 * 	@see SiteManagerImpl
 * 	@see SecteurManager
 * 	@see SecteurManagerImpl
 * 	@see VoieManager
 * 	@see VoieManagerImpl
 * 	@see TopoManager
 * 	@see TopoManagerImpl
 *  
 *  
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface ManagerFactory {

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'UtilisateurManager'</p>
	 *  
	 * @param utilisateurManager => Nouvelle instance de la classe 'UtilisateurManager' qui est défini
	 * 
	 * @see ManagerFactory#getUtilisateurManager()
	 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactoryImpl#getUtilisateurManager()
	 * @see UtilisateurManager
	 * @see UtilisateurManagerImpl
	 */
	void setUtilisateurManager(UtilisateurManager utilisateurManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle d'utilisateurManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'UtilisateurManager'
	 * 
	 * @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactoryImpl#getUtilisateurManager()
	 * @see UtilisateurManager
	 * @see UtilisateurManagerImpl
	 */
	UtilisateurManager getUtilisateurManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TopoManager'</p>
	 *  
	 * @param topoManager => Nouvelle instance de la classe 'TopoManager' qui est défini
	 * 
	 * @see ManagerFactory#getTopoManager()
	 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
	 * @see ManagerFactoryImpl#getTopoManager()
	 * @see TopoManager
	 * @see TopoManagerImpl
	 */
	void setTopoManager(TopoManager topoManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de topoManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TopoManager'
	 * 
	 * @see ManagerFactory#setTopoManager(TopoManager)
	 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
	 * @see ManagerFactoryImpl#getTopoManager()
	 * @see TopoManager
	 * @see TopoManagerImpl
	 */
	TopoManager getTopoManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'VoieManager'</p>
	 *  
	 * @param voieManager => Nouvelle instance de la classe 'VoieManager' qui est défini
	 * 
	 * @see ManagerFactory#getVoieManager()
	 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
	 * @see ManagerFactoryImpl#getVoieManager()
	 * @see VoieManager
	 * @see VoieManagerImpl
	 */
	void setVoieManager(VoieManager voieManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de voieManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'VoieManager'
	 * 
	 * @see ManagerFactory#setVoieManager(VoieManager)
	 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
	 * @see ManagerFactoryImpl#getVoieManager()
	 * @see VoieManager
	 * @see VoieManagerImpl
	 */
	VoieManager getVoieManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'SecteurManager'</p>
	 *  
	 * @param secteurManager => Nouvelle instance de la classe 'SecteurManager' qui est défini
	 * 
	 * @see ManagerFactory#getSecteurManager()
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	void setSecteurManager(SecteurManager secteurManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de secteurManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'SecteurManager'
	 * 
	 * @see ManagerFactory#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	SecteurManager getSecteurManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'SecteurManager'</p>
	 *  
	 * @param secteurManager => Nouvelle instance de la classe 'SecteurManager' qui est défini
	 * 
	 * @see ManagerFactory#getSecteurManager()
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	void setSiteManager(SiteManager siteManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de secteurManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'SecteurManager'
	 * 
	 * @see ManagerFactory#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	SiteManager getSiteManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'PretManager'</p>
	 *  
	 * @param pretManager => Nouvelle instance de la classe 'PretManager' qui est défini
	 * 
	 * @see ManagerFactory#getPretManager()
	 * @see ManagerFactoryImpl#setPretManager(PretManager)
	 * @see ManagerFactoryImpl#getPretManager()
	 * @see PretManager
	 * @see PretManagerImpl
	 */
	void setPretManager(PretManager pretManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de pretManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'PretManager'
	 * 
	 * @see ManagerFactory#setPretManager(PretManager)
	 * @see ManagerFactoryImpl#setPretManager(PretManager)
	 * @see ManagerFactoryImpl#getPretManager()
	 * @see PretManager
	 * @see PretManagerImpl
	 */
	PretManager getPretManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TamponProprietaireTopoManager'</p>
	 *  
	 * @param tamponProprietaireTopoManager => Nouvelle instance de la classe 'TamponProprietaireTopoManager' qui est défini
	 * 
	 * @see ManagerFactory#getTamponProprietaireTopoManager()
	 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
	 * @see TamponProprietaireTopoManager
	 * @see TamponProprietaireTopoManagerImpl
	 */
	void setTamponProprietaireTopoManager(TamponProprietaireTopoManager tamponProprietaireTopoManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de tamponProprietaireTopoManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TamponProprietaireTopoManager'
	 * 
	 * @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
	 * @see TamponProprietaireTopoManager
	 * @see TamponProprietaireTopoManagerImpl
	 */
	TamponProprietaireTopoManager getTamponProprietaireTopoManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TamponSiteTopoManager'</p>
	 *  
	 * @param tamponSiteTopoManager => Nouvelle instance de la classe 'TamponSiteTopoManager' qui est défini
	 * 
	 * @see ManagerFactory#getTamponSiteTopoManager()
	 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
	 * @see TamponSiteTopoManager
	 * @see TamponSiteTopoManagerImpl
	 */
	void setTamponSiteTopoManager(TamponSiteTopoManager tamponSiteTopoManager);

	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de tamponSiteTopoManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TamponSiteTopoManager'
	 * 
	 * @see ManagerFactory#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
	 * @see TamponSiteTopoManager
	 * @see TamponSiteTopoManagerImpl
	 */
	TamponSiteTopoManager getTamponSiteTopoManager();

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'CommentaireTopoManager'</p>
	 *  
	 * @param commentaireTopoManager => Nouvelle instance de la classe 'CommentaireTopoManager' qui est défini
	 * 
	 * @see ManagerFactory#getCommentaireTopoManager()
	 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactoryImpl#getCommentaireTopoManager()
	 * @see CommentaireTopoManager
	 * @see CommentaireTopoManagerImpl
	 */
	void setCommentaireTopoManager(CommentaireTopoManager commentaireTopoManager);

	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de commentaireTopoManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'CommentaireTopoManager'
	 * 
	 * @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactoryImpl#getCommentaireTopoManager()
	 * @see CommentaireTopoManager
	 * @see CommentaireTopoManagerImpl
	 */
	CommentaireTopoManager getCommentaireTopoManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'CommentaireSiteManager'</p>
	 *  
	 * @param commentaireSiteManager => Nouvelle instance de la classe 'CommentaireSiteManager' qui est défini
	 * 
	 * @see ManagerFactory#getCommentaireSiteManager()
	 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactoryImpl#getCommentaireSiteManager()
	 * @see CommentaireSiteManager
	 * @see CommentaireSiteManagerImpl
	 */
	void setCommentaireSiteManager(CommentaireSiteManager commentaireSiteManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de commentaireSiteManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'CommentaireSiteManager'
	 * 
	 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactoryImpl#getCommentaireSiteManager()
	 * @see CommentaireSiteManager
	 * @see CommentaireSiteManagerImpl
	 */
	CommentaireSiteManager getCommentaireSiteManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'MessagePretManager'</p>
	 *  
	 * @param messagePretManager => Nouvelle instance de la classe 'MessagePretManager' qui est défini
	 * 
	 * @see ManagerFactory#getMessagePretManager()
	 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactoryImpl#getMessagePretManager()
	 * @see MessagePretManager
	 * @see MessagePretManagerImpl
	 */
	void setMessagePretManager(MessagePretManager messagePretManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de messagePretManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'MessagePretManager'
	 * 
	 * @see ManagerFactory#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactoryImpl#getMessagePretManager()
	 * @see MessagePretManager
	 * @see MessagePretManagerImpl
	 */
	MessagePretManager getMessagePretManager();

	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'MessageManager'</p>
	 *  
	 * @param messageManager => Nouvelle instance de la classe 'MessageManager' qui est défini
	 * 
	 * @see ManagerFactory#getMessageManager()
	 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
	 * @see ManagerFactoryImpl#getMessageManager()
	 * @see MessageManager
	 * @see MessageManagerImpl
	 */
	void setMessageManager(MessageManager messageManager);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de messageManager et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'MessageManager'
	 * 
	 * @see ManagerFactory#setMessageManager(MessageManager)
	 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
	 * @see ManagerFactoryImpl#getMessageManager()
	 * @see MessageManager
	 * @see MessageManagerImpl
	 */
	MessageManager getMessageManager();

}
