package fr.openclassrooms.projet_6.business.impl.manager;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
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
 * Implémentation de l'interface 'ManagerFactory'
 * 
 * 
 * @see ManagerFactory
 * @see ManagerFactoryImpl#utilisateurManager
 * @see ManagerFactoryImpl#messageManager
 * @see ManagerFactoryImpl#messagePretManager
 * @see ManagerFactoryImpl#commentaireSiteManager
 * @see ManagerFactoryImpl#commentaireTopoManager
 * @see ManagerFactoryImpl#tamponSiteTopoManager
 * @see ManagerFactoryImpl#tamponProprietaireTopoManager
 * @see ManagerFactoryImpl#pretManager
 * @see ManagerFactoryImpl#siteManager
 * @see ManagerFactoryImpl#secteurManager
 * @see ManagerFactoryImpl#voieManager
 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
 * @see ManagerFactoryImpl#getUtilisateurManager()
 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
 * @see ManagerFactoryImpl#getTopoManager()
 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
 * @see ManagerFactoryImpl#getVoieManager()
 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
 * @see ManagerFactoryImpl#getSecteurManager()
 * @see ManagerFactoryImpl#setSiteManager(SiteManager)
 * @see ManagerFactoryImpl#getSiteManager()
 * @see ManagerFactoryImpl#setPretManager(PretManager)
 * @see ManagerFactoryImpl#getPretManager()
 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
 * @see ManagerFactoryImpl#getCommentaireTopoManager()
 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
 * @see ManagerFactoryImpl#getCommentaireSiteManager()
 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
 * @see ManagerFactoryImpl#getMessagePretManager()
 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
 * @see ManagerFactoryImpl#getMessageManager()
 * @see UtilisateurManager
 * @see UtilisateurManagerImpl
 * @see MessageManager
 * @see MessageManagerImpl
 * @see MessagePretManager
 * @see MessagePretManagerImpl
 * @see CommentaireSiteManager
 * @see CommentaireSiteManagerImpl
 * @see CommentaireTopoManager
 * @see CommentaireTopoManagerImpl
 * @see TamponSiteTopoManager
 * @see TamponSiteTopoManagerImpl
 * @see TamponProprietaireTopoManager
 * @see TamponProprietaireTopoManagerImpl
 * @see PretManager
 * @see PretManagerImpl
 * @see SiteManager
 * @see SiteManagerImpl
 * @see SecteurManager
 * @see SecteurManagerImpl
 * @see VoieManager
 * @see VoieManagerImpl
 * @see TopoManager
 * @see TopoManagerImpl
 * @see AbstractManager
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class ManagerFactoryImpl implements ManagerFactory {
	
	
	
	/**
	 * Objet 'UtilisateurManager' gardant en stock l'instance 'UtilisateurManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactoryImpl#getUtilisateurManager()
	 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactory#getUtilisateurManager()
	 * @see UtilisateurManagerImpl
	 * @see UtilisateurManager
	 */
	private UtilisateurManager utilisateurManager;
	
	
	
	/**
	 * Objet 'MessageManager' gardant en stock l'instance 'MessageManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
	 * @see ManagerFactoryImpl#getMessageManager()
	 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
	 * @see ManagerFactory#getMessageManager()
	 * @see MessageManagerImpl
	 * @see MessageManager
	 */
	private MessageManager messageManager;
	
	
	
	/**
	 * Objet 'MessagePretManager' gardant en stock l'instance 'MessagePretManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactoryImpl#getMessagePretManager()
	 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactory#getMessagePretManager()
	 * @see MessagePretManagerImpl
	 * @see MessagePretManager
	 */
	private MessagePretManager messagePretManager;
	
	
	
	/**
	 * Objet 'CommentaireSiteManager' gardant en stock l'instance 'CommentaireSiteManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactoryImpl#getCommentaireSiteManager()
	 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactory#getCommentaireSiteManager()
	 * @see CommentaireSiteManagerImpl
	 * @see CommentaireSiteManager
	 */
	private CommentaireSiteManager commentaireSiteManager;
	
	
	
	/**
	 * Objet 'CommentaireTopoManager' gardant en stock l'instance 'CommentaireTopoManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactoryImpl#getCommentaireTopoManager()
	 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactory#getCommentaireTopoManager()
	 * @see CommentaireTopoManagerImpl
	 * @see CommentaireTopoManager
	 */
	private CommentaireTopoManager commentaireTopoManager;
	
	
	
	/**
	 * Objet 'TamponSiteTopoManager' gardant en stock l'instance 'TamponSiteTopoManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
	 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactory#getTamponSiteTopoManager()
	 * @see TamponSiteTopoManagerImpl
	 * @see TamponSiteTopoManager
	 */
	private TamponSiteTopoManager tamponSiteTopoManager;
	
	
	
	/**
	 * Objet 'TamponProprietaireTopoManager' gardant en stock l'instance 'TamponProprietaireTopoManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
	 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactory#getTamponProprietaireTopoManager()
	 * @see TamponProprietaireTopoManagerImpl
	 * @see TamponProprietaireTopoManager
	 */
	private TamponProprietaireTopoManager tamponProprietaireTopoManager;
	
	
	
	/**
	 * Objet 'PretManager' gardant en stock l'instance 'PretManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setPretManager(PretManager)
	 * @see ManagerFactoryImpl#getPretManager()
	 * @see ManagerFactoryImpl#setPretManager(PretManager)
	 * @see ManagerFactory#getPretManager()
	 * @see PretManagerImpl
	 * @see PretManager
	 */
	private PretManager pretManager;
	
	
	
	/**
	 * Objet 'SiteManager' gardant en stock l'instance 'SiteManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setSiteManager(SiteManager)
	 * @see ManagerFactoryImpl#getSiteManager()
	 * @see ManagerFactoryImpl#setSiteManager(SiteManager)
	 * @see ManagerFactory#getSiteManager()
	 * @see SiteManagerImpl
	 * @see SiteManager
	 */
	private SiteManager siteManager;
	
	
	
	/**
	 * Objet 'SecteurManager' gardant en stock l'instance 'SecteurManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactory#getSecteurManager()
	 * @see SecteurManagerImpl
	 * @see SecteurManager
	 */
	private SecteurManager secteurManager;
	
	
	
	/**
	 * Objet 'VoieManager' gardant en stock l'instance 'VoieManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
	 * @see ManagerFactoryImpl#getVoieManager()
	 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
	 * @see ManagerFactory#getVoieManager()
	 * @see VoieManagerImpl
	 * @see VoieManager
	 */
	private VoieManager voieManager;
	
	
	
	/**
	 * Objet 'TopoManager' gardant en stock l'instance 'TopoManager' qui lui a été injecté
	 * 
	 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
	 * @see ManagerFactoryImpl#getTopoManager()
	 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
	 * @see ManagerFactory#getTopoManager()
	 * @see TopoManagerImpl
	 * @see TopoManager
	 */
	private TopoManager topoManager;
	
	
	
	/**
	 * @see ManagerFactoryImpl#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactory#getUtilisateurManager()
	 * @see UtilisateurManager
	 * @see UtilisateurManagerImpl
	 */
	@Override
	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	
	
	/**
	 * @see ManagerFactory#getUtilisateurManager()
	 * @see ManagerFactory#setUtilisateurManager(UtilisateurManager)
	 * @see ManagerFactoryImpl#getUtilisateurManager()
	 * @see UtilisateurManager
	 * @see UtilisateurManagerImpl
	 */
	@Override
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
	 * @see ManagerFactory#setMessageManager(MessageManager)
	 * @see ManagerFactory#getMessageManager()
	 * @see MessageManager
	 * @see MessageManagerImpl
	 */
	@Override
	public MessageManager getMessageManager() {
		return messageManager;
	}

	
	
	/** 
	 * @see ManagerFactory#getMessageManager()
	 * @see ManagerFactory#setMessageManager(MessageManager)
	 * @see ManagerFactoryImpl#getMessageManager()
	 * @see MessageManager
	 * @see MessageManagerImpl
	 */
	@Override
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactory#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactory#getMessagePretManager()
	 * @see MessagePretManager
	 * @see MessagePretManagerImpl
	 */
	@Override
	public MessagePretManager getMessagePretManager() {
		return messagePretManager;
	}

	
	
	/**
	 * @see ManagerFactory#getMessagePretManager()
	 * @see ManagerFactory#setMessagePretManager(MessagePretManager)
	 * @see ManagerFactoryImpl#getMessagePretManager()
	 * @see MessagePretManager
	 * @see MessagePretManagerImpl
	 */
	@Override
	public void setMessagePretManager(MessagePretManager messagePretManager) {
		this.messagePretManager = messagePretManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactory#getCommentaireSiteManager()
	 * @see CommentaireSiteManager
	 * @see CommentaireSiteManagerImpl
	 */
	@Override
	public CommentaireSiteManager getCommentaireSiteManager() {
		return commentaireSiteManager;
	}

	
	
	/**
	 * @see ManagerFactory#getCommentaireSiteManager()
	 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
	 * @see ManagerFactoryImpl#getCommentaireSiteManager()
	 * @see CommentaireSiteManager
	 * @see CommentaireSiteManagerImpl
	 */
	@Override
	public void setCommentaireSiteManager(CommentaireSiteManager commentaireSiteManager) {
		this.commentaireSiteManager = commentaireSiteManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactory#getCommentaireTopoManager()
	 * @see CommentaireTopoManager
	 * @see CommentaireTopoManagerImpl
	 */
	@Override
	public CommentaireTopoManager getCommentaireTopoManager() {
		return commentaireTopoManager;
	}

	
	
	/**
	 * @see ManagerFactory#getCommentaireTopoManager()
	 * @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
	 * @see ManagerFactoryImpl#getCommentaireTopoManager()
	 * @see CommentaireTopoManager
	 * @see CommentaireTopoManagerImpl
	 */
	@Override
	public void setCommentaireTopoManager(CommentaireTopoManager commentaireTopoManager) {
		this.commentaireTopoManager = commentaireTopoManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactory#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactory#getTamponSiteTopoManager()
	 * @see TamponSiteTopoManager
	 * @see TamponSiteTopoManagerImpl
	 */
	@Override
	public TamponSiteTopoManager getTamponSiteTopoManager() {
		return tamponSiteTopoManager;
	}

	
	
	/**
	 * @see ManagerFactory#getTamponSiteTopoManager()
	 * @see ManagerFactory#setTamponSiteTopoManager(TamponSiteTopoManager)
	 * @see ManagerFactoryImpl#getTamponSiteTopoManager()
	 * @see TamponSiteTopoManager
	 * @see TamponSiteTopoManagerImpl
	 */
	@Override
	public void setTamponSiteTopoManager(TamponSiteTopoManager tamponSiteTopoManager) {
		this.tamponSiteTopoManager = tamponSiteTopoManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactory#getTamponProprietaireTopoManager()
	 * @see TamponProprietaireTopoManager
	 * @see TamponProprietaireTopoManagerImpl
	 */
	@Override
	public TamponProprietaireTopoManager getTamponProprietaireTopoManager() {
		return tamponProprietaireTopoManager;
	}

	
	
/**
	 * @see ManagerFactory#getTamponProprietaireTopoManager()
	 * @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
	 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
	 * @see TamponProprietaireTopoManager
	 * @see TamponProprietaireTopoManagerImpl
	 */
	@Override
	public void setTamponProprietaireTopoManager(TamponProprietaireTopoManager tamponProprietaireTopoManager) {
		this.tamponProprietaireTopoManager = tamponProprietaireTopoManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setPretManager(PretManager)
	 * @see ManagerFactory#setPretManager(PretManager)
	 * @see ManagerFactory#getPretManager()
	 * @see PretManager
	 * @see PretManagerImpl
	 */
	@Override
	public PretManager getPretManager() {
		return pretManager;
	}

	
	
	/**
	 * @see ManagerFactory#getPretManager()
	 * @see ManagerFactory#setPretManager(PretManager)
	 * @see ManagerFactoryImpl#getPretManager()
	 * @see PretManager
	 * @see PretManagerImpl
	 */
	@Override
	public void setPretManager(PretManager pretManager) {
		this.pretManager = pretManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setSiteManager(SiteManager)
	 * @see ManagerFactory#setSiteManager(SiteManager)
	 * @see ManagerFactory#getSiteManager()
	 * @see SiteManager
	 * @see SiteManagerImpl
	 */
	@Override
	public SiteManager getSiteManager() {
		return siteManager;
	}

	
	
	/**
	 * @see ManagerFactory#getSiteManager()
	 * @see ManagerFactory#setSiteManager(SiteManager)
	 * @see ManagerFactoryImpl#getSiteManager()
	 * @see SiteManager
	 * @see SiteManagerImpl
	 */
	@Override
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setSecteurManager(SecteurManager)
	 * @see ManagerFactory#setSecteurManager(SecteurManager)
	 * @see ManagerFactory#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	@Override
	public SecteurManager getSecteurManager() {
		return secteurManager;
	}

	
	
	/**
	 * @see ManagerFactory#getSecteurManager()
	 * @see ManagerFactory#setSecteurManager(SecteurManager)
	 * @see ManagerFactoryImpl#getSecteurManager()
	 * @see SecteurManager
	 * @see SecteurManagerImpl
	 */
	@Override
	public void setSecteurManager(SecteurManager secteurManager) {
		this.secteurManager = secteurManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setVoieManager(VoieManager)
	 * @see ManagerFactory#setVoieManager(VoieManager)
	 * @see ManagerFactory#getVoieManager()
	 * @see VoieManager
	 * @see VoieManagerImpl
	 */
	@Override
	public VoieManager getVoieManager() {
		return voieManager;
	}

	
	
	/**
	 * @see ManagerFactory#getVoieManager()
	 * @see ManagerFactory#setVoieManager(VoieManager)
	 * @see ManagerFactoryImpl#getVoieManager()
	 * @see VoieManager
	 * @see VoieManagerImpl
	 */
	@Override
	public void setVoieManager(VoieManager voieManager) {
		this.voieManager = voieManager;
	}

	
	
	/**
	 * @see ManagerFactoryImpl#setTopoManager(TopoManager)
	 * @see ManagerFactory#setTopoManager(TopoManager)
	 * @see ManagerFactory#getTopoManager()
	 * @see TopoManager
	 * @see TopoManagerImpl
	 */
	@Override
	public TopoManager getTopoManager() {
		return topoManager;
	}

	
	
	/**
	 * @see ManagerFactory#getTopoManager()
	 * @see ManagerFactory#setTopoManager(TopoManager)
	 * @see ManagerFactoryImpl#getTopoManager()
	 * @see TopoManager
	 * @see TopoManagerImpl
	 */
	@Override
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}
}
