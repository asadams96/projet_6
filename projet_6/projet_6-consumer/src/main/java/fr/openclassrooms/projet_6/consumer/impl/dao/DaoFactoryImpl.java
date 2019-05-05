package fr.openclassrooms.projet_6.consumer.impl.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireSiteDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireTopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessageDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessagePretDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponProprietaireTopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponSiteTopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SecteurDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SiteDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.VoieDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.topo.TopoDao;
import fr.openclassrooms.projet_6.consumer.contract.dao.utilisateur.UtilisateurDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireSiteDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessageDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessagePretDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponSiteTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.pret.PretDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SecteurDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SiteDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.VoieDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.topo.TopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.CommentaireSiteRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.CommentaireTopoRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.MessagePretRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.MessageRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison.TamponProprietaireTopoRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison.TamponSiteTopoRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.pret.PretRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.SecteurRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.SiteRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.VoieRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.topo.TopoRM;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.utilisateur.UtilisateurRM;

/**
 * Implémentation de l'interface 'DaoFactory'
 * 
 * 
 * @see DaoFactory
 * @see DaoFactoryImpl#utilisateurDao
 * @see DaoFactoryImpl#messageDao
 * @see DaoFactoryImpl#messagePretDao
 * @see DaoFactoryImpl#commentaireSiteDao
 * @see DaoFactoryImpl#commentaireTopoDao
 * @see DaoFactoryImpl#tamponSiteTopoDao
 * @see DaoFactoryImpl#tamponProprietaireTopoDao
 * @see DaoFactoryImpl#pretDao
 * @see DaoFactoryImpl#siteDao
 * @see DaoFactoryImpl#secteurDao
 * @see DaoFactoryImpl#voieDao
 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
 * @see DaoFactoryImpl#getUtilisateurDao()
 * @see DaoFactoryImpl#setTopoDao(TopoDao)
 * @see DaoFactoryImpl#getTopoDao()
 * @see DaoFactoryImpl#setVoieDao(VoieDao)
 * @see DaoFactoryImpl#getVoieDao()
 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
 * @see DaoFactoryImpl#getSecteurDao()
 * @see DaoFactoryImpl#setSiteDao(SiteDao)
 * @see DaoFactoryImpl#getSiteDao()
 * @see DaoFactoryImpl#setPretDao(PretDao)
 * @see DaoFactoryImpl#getPretDao()
 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
 * @see DaoFactoryImpl#getTamponSiteTopoDao()
 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
 * @see DaoFactoryImpl#getCommentaireTopoDao()
 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
 * @see DaoFactoryImpl#getCommentaireSiteDao()
 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
 * @see DaoFactoryImpl#getMessagePretDao()
 * @see DaoFactoryImpl#setMessageDao(MessageDao)
 * @see DaoFactoryImpl#getMessageDao()
 * @see UtilisateurDao
 * @see UtilisateurDaoImpl
 * @see MessageDao
 * @see MessageDaoImpl
 * @see MessagePretDao
 * @see MessagePretDaoImpl
 * @see CommentaireSiteDao
 * @see CommentaireSiteDaoImpl
 * @see CommentaireTopoDao
 * @see CommentaireTopoDaoImpl
 * @see TamponSiteTopoDao
 * @see TamponSiteTopoDaoImpl
 * @see TamponProprietaireTopoDao
 * @see TamponProprietaireTopoDaoImpl
 * @see PretDao
 * @see PretDaoImpl
 * @see SiteDao
 * @see SiteDaoImpl
 * @see SecteurDao
 * @see SecteurDaoImpl
 * @see VoieDao
 * @see VoieDaoImpl
 * @see TopoDao
 * @see TopoDaoImpl
 * @see RowMapper
 * @see UtilisateurRM
 * @see TopoRM
 * @see VoieRM
 * @see SecteurRM
 * @see SiteRM
 * @see PretRM
 * @see MessageRM
 * @see MessagePretRM
 * @see CommentaireSiteRM
 * @see CommentaireTopoRM
 * @see TamponSiteTopoRM
 * @see TamponProprietaireTopoRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class DaoFactoryImpl implements DaoFactory {
	
	
	
	/**
	 * Objet 'UtilisateurDao' gardant en stock l'instance 'UtilisateurDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactoryImpl#getUtilisateurDao()
	 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactory#getUtilisateurDao()
	 * @see UtilisateurDaoImpl
	 * @see UtilisateurDao
	 */
	private UtilisateurDao utilisateurDao;
	
	
	
	/**
	 * Objet 'MessageDao' gardant en stock l'instance 'MessageDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setMessageDao(MessageDao)
	 * @see DaoFactoryImpl#getMessageDao()
	 * @see DaoFactoryImpl#setMessageDao(MessageDao)
	 * @see DaoFactory#getMessageDao()
	 * @see MessageDaoImpl
	 * @see MessageDao
	 */
	private MessageDao messageDao;
	
	
	
	/**
	 * Objet 'MessagePretDao' gardant en stock l'instance 'MessagePretDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
	 * @see DaoFactoryImpl#getMessagePretDao()
	 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
	 * @see DaoFactory#getMessagePretDao()
	 * @see MessagePretDaoImpl
	 * @see MessagePretDao
	 */
	private MessagePretDao messagePretDao;
	
	
	
	/**
	 * Objet 'CommentaireSiteDao' gardant en stock l'instance 'CommentaireSiteDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactoryImpl#getCommentaireSiteDao()
	 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactory#getCommentaireSiteDao()
	 * @see CommentaireSiteDaoImpl
	 * @see CommentaireSiteDao
	 */
	private CommentaireSiteDao commentaireSiteDao;
	
	
	
	/**
	 * Objet 'CommentaireTopoDao' gardant en stock l'instance 'CommentaireTopoDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactoryImpl#getCommentaireTopoDao()
	 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactory#getCommentaireTopoDao()
	 * @see CommentaireTopoDaoImpl
	 * @see CommentaireTopoDao
	 */
	private CommentaireTopoDao commentaireTopoDao;
	
	
	
	/**
	 * Objet 'TamponSiteTopoDao' gardant en stock l'instance 'TamponSiteTopoDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactoryImpl#getTamponSiteTopoDao()
	 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactory#getTamponSiteTopoDao()
	 * @see TamponSiteTopoDaoImpl
	 * @see TamponSiteTopoDao
	 */
	private TamponSiteTopoDao tamponSiteTopoDao;
	
	
	
	/**
	 * Objet 'TamponProprietaireTopoDao' gardant en stock l'instance 'TamponProprietaireTopoDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
	 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactory#getTamponProprietaireTopoDao()
	 * @see TamponProprietaireTopoDaoImpl
	 * @see TamponProprietaireTopoDao
	 */
	private TamponProprietaireTopoDao tamponProprietaireTopoDao;
	
	
	
	/**
	 * Objet 'PretDao' gardant en stock l'instance 'PretDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setPretDao(PretDao)
	 * @see DaoFactoryImpl#getPretDao()
	 * @see DaoFactoryImpl#setPretDao(PretDao)
	 * @see DaoFactory#getPretDao()
	 * @see PretDaoImpl
	 * @see PretDao
	 */
	private PretDao pretDao;
	
	
	
	/**
	 * Objet 'SiteDao' gardant en stock l'instance 'SiteDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setSiteDao(SiteDao)
	 * @see DaoFactoryImpl#getSiteDao()
	 * @see DaoFactoryImpl#setSiteDao(SiteDao)
	 * @see DaoFactory#getSiteDao()
	 * @see SiteDaoImpl
	 * @see SiteDao
	 */
	private SiteDao siteDao;
	
	
	
	/**
	 * Objet 'SecteurDao' gardant en stock l'instance 'SecteurDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactory#getSecteurDao()
	 * @see SecteurDaoImpl
	 * @see SecteurDao
	 */
	private SecteurDao secteurDao;
	
	
	
	/**
	 * Objet 'VoieDao' gardant en stock l'instance 'VoieDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setVoieDao(VoieDao)
	 * @see DaoFactoryImpl#getVoieDao()
	 * @see DaoFactoryImpl#setVoieDao(VoieDao)
	 * @see DaoFactory#getVoieDao()
	 * @see VoieDaoImpl
	 * @see VoieDao
	 */
	private VoieDao voieDao;
	
	
	
	/**
	 * Objet 'TopoDao' gardant en stock l'instance 'TopoDao' qui lui a été injecté
	 * 
	 * @see DaoFactoryImpl#setTopoDao(TopoDao)
	 * @see DaoFactoryImpl#getTopoDao()
	 * @see DaoFactoryImpl#setTopoDao(TopoDao)
	 * @see DaoFactory#getTopoDao()
	 * @see TopoDaoImpl
	 * @see TopoDao
	 */
	private TopoDao topoDao;
	
	
	
	/**
	 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactory#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactory#getUtilisateurDao()
	 * @see UtilisateurDao
	 * @see UtilisateurDaoImpl
	 */
	@Override
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	
	
	/**
	 * @see DaoFactory#getUtilisateurDao()
	 * @see DaoFactory#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactoryImpl#getUtilisateurDao()
	 * @see UtilisateurDao
	 * @see UtilisateurDaoImpl
	 */
	@Override
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setTopoDao(TopoDao)
	 * @see DaoFactory#setTopoDao(TopoDao)
	 * @see DaoFactory#getTopoDao()
	 * @see TopoDao
	 * @see TopoDaoImpl
	 */
	@Override
	public TopoDao getTopoDao() {
		return topoDao;
	}



	/**
	 * @see DaoFactory#getTopoDao()
	 * @see DaoFactory#setTopoDao(TopoDao)
	 * @see DaoFactoryImpl#getTopoDao()
	 * @see TopoDao
	 * @see TopoDaoImpl
	 */
	@Override
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}



	/**
	 * @see DaoFactoryImpl#setMessageDao(MessageDao)
	 * @see DaoFactory#setMessageDao(MessageDao)
	 * @see DaoFactory#getMessageDao()
	 * @see MessageDao
	 * @see MessageDaoImpl
	 */
	@Override
	public MessageDao getMessageDao() {
		return messageDao;
	}

	
	
	/** 
	 * @see DaoFactory#getMessageDao()
	 * @see DaoFactory#setMessageDao(MessageDao)
	 * @see DaoFactoryImpl#getMessageDao()
	 * @see MessageDao
	 * @see MessageDaoImpl
	 */
	@Override
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	
	
	/**
	 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
	 * @see DaoFactory#setMessagePretDao(MessagePretDao)
	 * @see DaoFactory#getMessagePretDao()
	 * @see MessagePretDao
	 * @see MessagePretDaoImpl
	 */
	@Override
	public MessagePretDao getMessagePretDao() {
		return messagePretDao;
	}

	
	
	/**
	 * @see DaoFactory#getMessagePretDao()
	 * @see DaoFactory#setMessagePretDao(MessagePretDao)
	 * @see DaoFactoryImpl#getMessagePretDao()
	 * @see MessagePretDao
	 * @see MessagePretDaoImpl
	 */
	@Override
	public void setMessagePretDao(MessagePretDao messagePretDao) {
		this.messagePretDao = messagePretDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactory#getCommentaireSiteDao()
	 * @see CommentaireSiteDao
	 * @see CommentaireSiteDaoImpl
	 */
	@Override
	public CommentaireSiteDao getCommentaireSiteDao() {
		return commentaireSiteDao;
	}

	
	
	/**
	 * @see DaoFactory#getCommentaireSiteDao()
	 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactoryImpl#getCommentaireSiteDao()
	 * @see CommentaireSiteDao
	 * @see CommentaireSiteDaoImpl
	 */
	@Override
	public void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao) {
		this.commentaireSiteDao = commentaireSiteDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactory#getCommentaireTopoDao()
	 * @see CommentaireTopoDao
	 * @see CommentaireTopoDaoImpl
	 */
	@Override
	public CommentaireTopoDao getCommentaireTopoDao() {
		return commentaireTopoDao;
	}

	
	
	/**
	 * @see DaoFactory#getCommentaireTopoDao()
	 * @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactoryImpl#getCommentaireTopoDao()
	 * @see CommentaireTopoDao
	 * @see CommentaireTopoDaoImpl
	 */
	@Override
	public void setCommentaireTopoDao(CommentaireTopoDao commentaireTopoDao) {
		this.commentaireTopoDao = commentaireTopoDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactory#getTamponSiteTopoDao()
	 * @see TamponSiteTopoDao
	 * @see TamponSiteTopoDaoImpl
	 */
	@Override
	public TamponSiteTopoDao getTamponSiteTopoDao() {
		return tamponSiteTopoDao;
	}

	
	
	/**
	 * @see DaoFactory#getTamponSiteTopoDao()
	 * @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactoryImpl#getTamponSiteTopoDao()
	 * @see TamponSiteTopoDao
	 * @see TamponSiteTopoDaoImpl
	 */
	@Override
	public void setTamponSiteTopoDao(TamponSiteTopoDao tamponSiteTopoDao) {
		this.tamponSiteTopoDao = tamponSiteTopoDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactory#getTamponProprietaireTopoDao()
	 * @see TamponProprietaireTopoDao
	 * @see TamponProprietaireTopoDaoImpl
	 */
	@Override
	public TamponProprietaireTopoDao getTamponProprietaireTopoDao() {
		return tamponProprietaireTopoDao;
	}

	
	
	/**
	 * @see DaoFactory#getTamponProprietaireTopoDao()
	 * @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
	 * @see TamponProprietaireTopoDao
	 * @see TamponProprietaireTopoDaoImpl
	 */
	@Override
	public void setTamponProprietaireTopoDao(TamponProprietaireTopoDao tamponProprietaireTopoDao) {
		this.tamponProprietaireTopoDao = tamponProprietaireTopoDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setPretDao(PretDao)
	 * @see DaoFactory#setPretDao(PretDao)
	 * @see DaoFactory#getPretDao()
	 * @see PretDao
	 * @see PretDaoImpl
	 */
	@Override
	public PretDao getPretDao() {
		return pretDao;
	}

	
	
	/**
	 * @see DaoFactory#getPretDao()
	 * @see DaoFactory#setPretDao(PretDao)
	 * @see DaoFactoryImpl#getPretDao()
	 * @see PretDao
	 * @see PretDaoImpl
	 */
	@Override
	public void setPretDao(PretDao pretDao) {
		this.pretDao = pretDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setSiteDao(SiteDao)
	 * @see DaoFactory#setSiteDao(SiteDao)
	 * @see DaoFactory#getSiteDao()
	 * @see SiteDao
	 * @see SiteDaoImpl
	 */
	@Override
	public SiteDao getSiteDao() {
		return siteDao;
	}

	
	
	/**
	 * @see DaoFactory#getSiteDao()
	 * @see DaoFactory#setSiteDao(SiteDao)
	 * @see DaoFactoryImpl#getSiteDao()
	 * @see SiteDao
	 * @see SiteDaoImpl
	 */
	@Override
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactory#setSecteurDao(SecteurDao)
	 * @see DaoFactory#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	@Override
	public SecteurDao getSecteurDao() {
		return secteurDao;
	}

	
	
	/**
	 * @see DaoFactory#getSecteurDao()
	 * @see DaoFactory#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	@Override
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}

	
	
	/**
	 * @see DaoFactoryImpl#setVoieDao(VoieDao)
	 * @see DaoFactory#setVoieDao(VoieDao)
	 * @see DaoFactory#getVoieDao()
	 * @see VoieDao
	 * @see VoieDaoImpl
	 */
	@Override
	public VoieDao getVoieDao() {
		return voieDao;
	}

	
	
	/**
	 * @see DaoFactory#getVoieDao()
	 * @see DaoFactory#setVoieDao(VoieDao)
	 * @see DaoFactoryImpl#getVoieDao()
	 * @see VoieDao
	 * @see VoieDaoImpl
	 */
	@Override
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}
}
