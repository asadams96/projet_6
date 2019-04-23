package fr.openclassrooms.projet_6.business.impl.manager;

import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessageManager;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessagePretManager;
import fr.openclassrooms.projet_6.business.contract.manager.liaison.TamponSiteTopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.pret.PretManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SecteurManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.SiteManager;
import fr.openclassrooms.projet_6.business.contract.manager.site.VoieManager;
import fr.openclassrooms.projet_6.business.contract.manager.topo.TopoManager;
import fr.openclassrooms.projet_6.business.contract.manager.utilisateur.UtilisateurManager;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;

public class ManagerFactoryImpl {
	
	private MessageManager messageManager;
	private MessagePretManager messagePretManager;
	private CommentaireSiteManager commentaireSiteManager;
	private CommentaireTopoManager commentaireTopoManager;
	
	private TamponSiteTopoManager tamponSiteTopoManager;
	private TamponProprietaireTopo tamponProprietaireTopo;
	
	private PretManager pretManager;
	
	private SiteManager siteManager;
	private SecteurManager secteurManager;
	private VoieManager voieManager;
	
	private TopoManager topoManager;
	
	private UtilisateurManager utilisateurManager;
	
	

	public MessageManager getMessageManager() {
		return messageManager;
	}

	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	public MessagePretManager getMessagePretManager() {
		return messagePretManager;
	}

	public void setMessagePretManager(MessagePretManager messagePretManager) {
		this.messagePretManager = messagePretManager;
	}

	public CommentaireSiteManager getCommentaireSiteManager() {
		return commentaireSiteManager;
	}

	public void setCommentaireSiteManager(CommentaireSiteManager commentaireSiteManager) {
		this.commentaireSiteManager = commentaireSiteManager;
	}

	public CommentaireTopoManager getCommentaireTopoManager() {
		return commentaireTopoManager;
	}

	public void setCommentaireTopoManager(CommentaireTopoManager commentaireTopoManager) {
		this.commentaireTopoManager = commentaireTopoManager;
	}

	public TamponSiteTopoManager getTamponSiteTopoManager() {
		return tamponSiteTopoManager;
	}

	public void setTamponSiteTopoManager(TamponSiteTopoManager tamponSiteTopoManager) {
		this.tamponSiteTopoManager = tamponSiteTopoManager;
	}

	public TamponProprietaireTopo getTamponProprietaireTopo() {
		return tamponProprietaireTopo;
	}

	public void setTamponProprietaireTopo(TamponProprietaireTopo tamponProprietaireTopo) {
		this.tamponProprietaireTopo = tamponProprietaireTopo;
	}

	public PretManager getPretManager() {
		return pretManager;
	}

	public void setPretManager(PretManager pretManager) {
		this.pretManager = pretManager;
	}

	public SiteManager getSiteManager() {
		return siteManager;
	}

	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
	}

	public SecteurManager getSecteurManager() {
		return secteurManager;
	}

	public void setSecteurManager(SecteurManager secteurManager) {
		this.secteurManager = secteurManager;
	}

	public VoieManager getVoieManager() {
		return voieManager;
	}

	public void setVoieManager(VoieManager voieManager) {
		this.voieManager = voieManager;
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}

	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}

	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}
}
