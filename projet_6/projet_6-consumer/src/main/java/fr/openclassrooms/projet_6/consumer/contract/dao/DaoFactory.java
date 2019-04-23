package fr.openclassrooms.projet_6.consumer.contract.dao;

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

public interface DaoFactory {
	

	void setUtilisateurDao(UtilisateurDao utilisateurDao);

	UtilisateurDao getUtilisateurDao();
	

	void setTopoDao(TopoDao topoDao);

	TopoDao getTopoDao();
	

	void setVoieDao(VoieDao voieDao);

	VoieDao getVoieDao();
	

	void setSecteurDao(SecteurDao secteurDao);

	SecteurDao getSecteurDao();
	

	void setSiteDao(SiteDao siteDao);

	SiteDao getSiteDao();
	

	void setPretDao(PretDao pretDao);

	PretDao getPretDao();
	

	void setTamponProprietaireTopo(TamponProprietaireTopo tamponProprietaireTopo);

	TamponProprietaireTopo getTamponProprietaireTopo();
	

	void setTamponSiteTopoDao(TamponSiteTopoDao tamponSiteTopoDao);

	TamponSiteTopoDao getTamponSiteTopoDao();
	

	void setCommentaireTopoDao(CommentaireTopoDao commentaireTopoDao);

	CommentaireTopoDao getCommentaireTopoDao();
	

	void setCommentaireSiteDao(CommentaireSiteDao commentaireSiteDao);

	CommentaireSiteDao getCommentaireSiteDao();
	

	void setMessagePretDao(MessagePretDao messagePretDao);

	MessagePretDao getMessagePretDao();
	

	void setMessageDao(MessageDao messageDao);

	MessageDao getMessageDao();

}
