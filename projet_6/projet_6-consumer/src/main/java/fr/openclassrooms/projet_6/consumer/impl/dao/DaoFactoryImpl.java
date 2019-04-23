package fr.openclassrooms.projet_6.consumer.impl.dao;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireSiteDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireTopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessageDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessagePretDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponSiteTopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SecteurDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SiteDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.VoieDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.topo.TopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.utilisateur.UtilisateurDao;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;

public class DaoFactoryImpl implements DaoFactory {
	
	private MessageDao messageDao;
	private MessagePretDao messagePretDao;
	private CommentaireSiteDao commentaireSiteDao;
	private CommentaireTopoDao commentaireTopoDao;
	
	private TamponSiteTopoDao tamponSiteTopoDao;
	private TamponProprietaireTopo tamponProprietaireTopo;
	
	private PretDao pretDao;
	
	private SiteDao siteDao;
	private SecteurDao secteurDao;
	private VoieDao voieDao;
	
	private TopoDao topoDao;
	
	private UtilisateurDao utilisateurDao;

	
	
	@Override
	public MessageDao getMessageDao() {
		return messageDao;
	}

	@Override
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public MessagePretDao getMessagePretDao() {
		return messagePretDao;
	}

	@Override
	public void setMessagePretDao(MessagePretDao messagePretDao) {
		this.messagePretDao = messagePretDao;
	}

	@Override
	public CommentaireSiteDao getCommentaireSiteDao() {
		return commentaireSiteDao;
	}

	@Override
	public void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao) {
		this.commentaireSiteDao = commentaireSiteDao;
	}

	@Override
	public CommentaireTopoDao getCommentaireTopoDao() {
		return commentaireTopoDao;
	}

	@Override
	public void setCommentaireTopoDao(CommentaireTopoDao commentaireTopoDao) {
		this.commentaireTopoDao = commentaireTopoDao;
	}

	@Override
	public TamponSiteTopoDao getTamponSiteTopoDao() {
		return tamponSiteTopoDao;
	}

	@Override
	public void setTamponSiteTopoDao(TamponSiteTopoDao tamponSiteTopoDao) {
		this.tamponSiteTopoDao = tamponSiteTopoDao;
	}

	@Override
	public TamponProprietaireTopo getTamponProprietaireTopo() {
		return tamponProprietaireTopo;
	}

	@Override
	public void setTamponProprietaireTopo(TamponProprietaireTopo tamponProprietaireTopo) {
		this.tamponProprietaireTopo = tamponProprietaireTopo;
	}

	@Override
	public PretDao getPretDao() {
		return pretDao;
	}

	@Override
	public void setPretDao(PretDao pretDao) {
		this.pretDao = pretDao;
	}

	@Override
	public SiteDao getSiteDao() {
		return siteDao;
	}

	@Override
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Override
	public SecteurDao getSecteurDao() {
		return secteurDao;
	}

	@Override
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}

	@Override
	public VoieDao getVoieDao() {
		return voieDao;
	}

	@Override
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}

	@Override
	public TopoDao getTopoDao() {
		return topoDao;
	}

	@Override
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
}
