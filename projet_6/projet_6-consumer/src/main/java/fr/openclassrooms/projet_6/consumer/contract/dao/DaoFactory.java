package fr.openclassrooms.projet_6.consumer.contract.dao;

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
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.topo.*;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.*;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.*;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.*;
import fr.openclassrooms.projet_6.consumer.impl.dao.pret.*;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.*;


/**
 * <p>Interface Factory de la couche consumer<p>
 * <p>Permet de définir et de lire chaque Dao</p>
 * <p>Setter/Getter présent dans la couche business dans la classe 'AbstractManager'<p>
 *  
 *  
 *  @see DaoFactoryImpl
 *  @see DaoFactory#setUtilisateurDao(UtilisateurDao)
 *  @see DaoFactory#getUtilisateurDao()
 *  @see DaoFactory#setTopoDao(TopoDao)
 *  @see DaoFactory#getTopoDao()
 *  @see DaoFactory#setVoieDao(VoieDao)
 *  @see DaoFactory#getVoieDao()
 *  @see DaoFactory#setSecteurDao(SecteurDao)
 *  @see DaoFactory#getSecteurDao()
 *  @see DaoFactory#setSiteDao(SiteDao)
 *  @see DaoFactory#getSiteDao()
 *  @see DaoFactory#setPretDao(PretDao)
 *  @see DaoFactory#getPretDao()
 *  @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 *  @see DaoFactory#getTamponProprietaireTopoDao()
 *  @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
 *  @see DaoFactory#getTamponSiteTopoDao()
 *  @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
 *  @see DaoFactory#getCommentaireTopoDao()
 *  @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
 *  @see DaoFactory#getCommentaireSiteDao()
 *  @see DaoFactory#setMessagePretDao(MessagePretDao)
 *  @see DaoFactory#getMessagePretDao()
 *  @see DaoFactory#setMessageDao(MessageDao)
 *  @see DaoFactory#getMessageDao()
 *  @see UtilisateurDao
 * 	@see UtilisateurDaoImpl
 * 	@see MessageDao
 * 	@see MessageDaoImpl
 * 	@see MessagePretDao
 * 	@see MessagePretDaoImpl
 * 	@see CommentaireSiteDao
 * 	@see CommentaireSiteDaoImpl
 * 	@see CommentaireTopoDao
 * 	@see CommentaireTopoDaoImpl
 * 	@see TamponSiteTopoDao
 * 	@see TamponSiteTopoDaoImpl
 * 	@see TamponProprietaireTopoDao
 * 	@see TamponProprietaireTopoDaoImpl
 * 	@see PretDao
 * 	@see PretDaoImpl
 * 	@see SiteDao
 * 	@see SiteDaoImpl
 * 	@see SecteurDao
 * 	@see SecteurDaoImpl
 * 	@see VoieDao
 * 	@see VoieDaoImpl
 * 	@see TopoDao
 * 	@see TopoDaoImpl
 *  
 *  
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface DaoFactory {
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'UtilisateurDao'</p>
	 *  
	 * @param utilisateurDao => Nouvelle instance de la classe 'UtilisateurDao' qui est défini
	 * 
	 * @see DaoFactory#getUtilisateurDao()
	 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactoryImpl#getUtilisateurDao()
	 * @see UtilisateurDao
	 * @see UtilisateurDaoImpl
	 */
	void setUtilisateurDao(UtilisateurDao utilisateurDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle d'utilisateurDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'UtilisateurDao'
	 * 
	 * @see DaoFactory#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
	 * @see DaoFactoryImpl#getUtilisateurDao()
	 * @see UtilisateurDao
	 * @see UtilisateurDaoImpl
	 */
	UtilisateurDao getUtilisateurDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TopoDao'</p>
	 *  
	 * @param topoDao => Nouvelle instance de la classe 'TopoDao' qui est défini
	 * 
	 * @see DaoFactory#getTopoDao()
	 * @see DaoFactoryImpl#setTopoDao(TopoDao)
	 * @see DaoFactoryImpl#getTopoDao()
	 * @see TopoDao
	 * @see TopoDaoImpl
	 */
	void setTopoDao(TopoDao topoDao);

	
	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de topoDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TopoDao'
	 * 
	 * @see DaoFactory#setTopoDao(TopoDao)
	 * @see DaoFactoryImpl#setTopoDao(TopoDao)
	 * @see DaoFactoryImpl#getTopoDao()
	 * @see TopoDao
	 * @see TopoDaoImpl
	 */
	TopoDao getTopoDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'VoieDao'</p>
	 *  
	 * @param voieDao => Nouvelle instance de la classe 'VoieDao' qui est défini
	 * 
	 * @see DaoFactory#getVoieDao()
	 * @see DaoFactoryImpl#setVoieDao(VoieDao)
	 * @see DaoFactoryImpl#getVoieDao()
	 * @see VoieDao
	 * @see VoieDaoImpl
	 */
	void setVoieDao(VoieDao voieDao);

	
	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de voieDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'VoieDao'
	 * 
	 * @see DaoFactory#setVoieDao(VoieDao)
	 * @see DaoFactoryImpl#setVoieDao(VoieDao)
	 * @see DaoFactoryImpl#getVoieDao()
	 * @see VoieDao
	 * @see VoieDaoImpl
	 */
	VoieDao getVoieDao();
	
	
	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'SecteurDao'</p>
	 *  
	 * @param secteurDao => Nouvelle instance de la classe 'SecteurDao' qui est défini
	 * 
	 * @see DaoFactory#getSecteurDao()
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	void setSecteurDao(SecteurDao secteurDao);

	
	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de secteurDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'SecteurDao'
	 * 
	 * @see DaoFactory#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	SecteurDao getSecteurDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'SecteurDao'</p>
	 *  
	 * @param secteurDao => Nouvelle instance de la classe 'SecteurDao' qui est défini
	 * 
	 * @see DaoFactory#getSecteurDao()
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	void setSiteDao(SiteDao siteDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de secteurDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'SecteurDao'
	 * 
	 * @see DaoFactory#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
	 * @see DaoFactoryImpl#getSecteurDao()
	 * @see SecteurDao
	 * @see SecteurDaoImpl
	 */
	SiteDao getSiteDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'PretDao'</p>
	 *  
	 * @param pretDao => Nouvelle instance de la classe 'PretDao' qui est défini
	 * 
	 * @see DaoFactory#getPretDao()
	 * @see DaoFactoryImpl#setPretDao(PretDao)
	 * @see DaoFactoryImpl#getPretDao()
	 * @see PretDao
	 * @see PretDaoImpl
	 */
	void setPretDao(PretDao pretDao);

	
	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de pretDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'PretDao'
	 * 
	 * @see DaoFactory#setPretDao(PretDao)
	 * @see DaoFactoryImpl#setPretDao(PretDao)
	 * @see DaoFactoryImpl#getPretDao()
	 * @see PretDao
	 * @see PretDaoImpl
	 */
	PretDao getPretDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TamponProprietaireTopoDao'</p>
	 *  
	 * @param tamponProprietaireTopoDao => Nouvelle instance de la classe 'TamponProprietaireTopoDao' qui est défini
	 * 
	 * @see DaoFactory#getTamponProprietaireTopoDao()
	 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
	 * @see TamponProprietaireTopoDao
	 * @see TamponProprietaireTopoDaoImpl
	 */
	void setTamponProprietaireTopoDao(TamponProprietaireTopoDao tamponProprietaireTopoDao);

	
	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de tamponProprietaireTopoDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TamponProprietaireTopoDao'
	 * 
	 * @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
	 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
	 * @see TamponProprietaireTopoDao
	 * @see TamponProprietaireTopoDaoImpl
	 */
	TamponProprietaireTopoDao getTamponProprietaireTopoDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'TamponSiteTopoDao'</p>
	 *  
	 * @param tamponSiteTopoDao => Nouvelle instance de la classe 'TamponSiteTopoDao' qui est défini
	 * 
	 * @see DaoFactory#getTamponSiteTopoDao()
	 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactoryImpl#getTamponSiteTopoDao()
	 * @see TamponSiteTopoDao
	 * @see TamponSiteTopoDaoImpl
	 */
	void setTamponSiteTopoDao(TamponSiteTopoDao tamponSiteTopoDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de tamponSiteTopoDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'TamponSiteTopoDao'
	 * 
	 * @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
	 * @see DaoFactoryImpl#getTamponSiteTopoDao()
	 * @see TamponSiteTopoDao
	 * @see TamponSiteTopoDaoImpl
	 */
	TamponSiteTopoDao getTamponSiteTopoDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'CommentaireTopoDao'</p>
	 *  
	 * @param commentaireTopoDao => Nouvelle instance de la classe 'CommentaireTopoDao' qui est défini
	 * 
	 * @see DaoFactory#getCommentaireTopoDao()
	 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactoryImpl#getCommentaireTopoDao()
	 * @see CommentaireTopoDao
	 * @see CommentaireTopoDaoImpl
	 */
	void setCommentaireTopoDao(CommentaireTopoDao commentaireTopoDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de commentaireTopoDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'CommentaireTopoDao'
	 * 
	 * @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
	 * @see DaoFactoryImpl#getCommentaireTopoDao()
	 * @see CommentaireTopoDao
	 * @see CommentaireTopoDaoImpl
	 */
	CommentaireTopoDao getCommentaireTopoDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'CommentaireSiteDao'</p>
	 *  
	 * @param commentaireSiteDao => Nouvelle instance de la classe 'CommentaireSiteDao' qui est défini
	 * 
	 * @see DaoFactory#getCommentaireSiteDao()
	 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactoryImpl#getCommentaireSiteDao()
	 * @see CommentaireSiteDao
	 * @see CommentaireSiteDaoImpl
	 */
	void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de commentaireSiteDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'CommentaireSiteDao'
	 * 
	 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
	 * @see DaoFactoryImpl#getCommentaireSiteDao()
	 * @see CommentaireSiteDao
	 * @see CommentaireSiteDaoImpl
	 */
	CommentaireSiteDao getCommentaireSiteDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'MessagePretDao'</p>
	 *  
	 * @param messagePretDao => Nouvelle instance de la classe 'MessagePretDao' qui est défini
	 * 
	 * @see DaoFactory#getMessagePretDao()
	 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
	 * @see DaoFactoryImpl#getMessagePretDao()
	 * @see MessagePretDao
	 * @see MessagePretDaoImpl
	 */
	void setMessagePretDao(MessagePretDao messagePretDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de messagePretDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'MessagePretDao'
	 * 
	 * @see DaoFactory#setMessagePretDao(MessagePretDao)
	 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
	 * @see DaoFactoryImpl#getMessagePretDao()
	 * @see MessagePretDao
	 * @see MessagePretDaoImpl
	 */
	MessagePretDao getMessagePretDao();
	

	
	/**
	 * <p>Setter utilisé par Spring pour injecter et donc définir une nouvelle instance de la classe 'MessageDao'</p>
	 *  
	 * @param messageDao => Nouvelle instance de la classe 'MessageDao' qui est défini
	 * 
	 * @see DaoFactory#getMessageDao()
	 * @see DaoFactoryImpl#setMessageDao(MessageDao)
	 * @see DaoFactoryImpl#getMessageDao()
	 * @see MessageDao
	 * @see MessageDaoImpl
	 */
	void setMessageDao(MessageDao messageDao);

	
	
	/**
	 * <p>Getter pour récupérer l'instance actuelle de messageDao et pouvoir faire des opérations avec</p>
	 * 
	 * @return => L'instance actuelle de la classe 'MessageDao'
	 * 
	 * @see DaoFactory#setMessageDao(MessageDao)
	 * @see DaoFactoryImpl#setMessageDao(MessageDao)
	 * @see DaoFactoryImpl#getMessageDao()
	 * @see MessageDao
	 * @see MessageDaoImpl
	 */
	MessageDao getMessageDao();

}
