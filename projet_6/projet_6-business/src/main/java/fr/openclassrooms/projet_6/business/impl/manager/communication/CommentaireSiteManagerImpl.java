package fr.openclassrooms.projet_6.business.impl.manager.communication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Implémentation de l'interface 'CommentaireSiteManager'</p>
 * <p>Dédié au traitement métier de la classe 'CommentaireSite'</p>
 * 
 * 

 * @see CommentaireSiteManagerImpl#getList(String)
 * @see CommentaireSiteManagerImpl#addComment(int, String, String)
 * @see CommentaireSiteManagerImpl#validation(String, int, int)
 * @see CommentaireSiteManager#getList(String)
 * @see CommentaireSiteManager#addComment(int, String, String)
 * @see ManagerFactory#getCommentaireSiteManager()
 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
 * @see ManagerFactoryImpl#getCommentaireSiteManager()
 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
 * @see CommentaireSite
 * @see DaoFactory
 * @see DaoFactoryImpl
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireSiteManagerImpl extends AbstractManager implements CommentaireSiteManager {
	
	
	
	/**
	 * @see CommentaireSiteManager#getList(String)
	 * @see CommentaireSite
	 * @see Message
	 */
	@Override
	public List<CommentaireSite> getList(String idSite) throws Exception {
					
		List<Integer> listIdsMessage = this.getDaoFactory().getCommentaireSiteDao().getIdsComment(idSite);
			
		List<CommentaireSite> listCommentaireSite = new ArrayList<CommentaireSite>();
			
		for(int idMessage : listIdsMessage) {
				
			Message message = this.getManagerFactory().getMessageManager().getMessage(idMessage);

			CommentaireSite commentaireSite = new CommentaireSite(idMessage, message.getDate(), message.getContenu(), 
												this.getDaoFactory().getUtilisateurDao().getUtilisateur(message.getAuteur().getIdUtilisateur()), 
																										this.getDaoFactory().getSiteDao().getSite(Integer.valueOf(idSite)));
				
			listCommentaireSite.add(commentaireSite);
		}
		
		return listCommentaireSite;
	}
	
	
	
	/**
	 * @see CommentaireSiteManager#addComment(int, String, String)
	 * @see CommentaireSiteManagerImpl#validation(String, int, int)
	 * @see CommentaireSite
	 * @see Message
	 */
	@Override
	public boolean addComment(int idUtilisateur, String idSite, String contenu) throws Exception  {

		Boolean vResult = false;
		
		Timestamp date = new Timestamp(new Date().getTime());			
			
		if(this.getManagerFactory().getMessageManager().addMessage(idUtilisateur, contenu, date)) {
				int idNewMessage = Integer.valueOf(this.getManagerFactory().getMessageManager().getIdMessage(idUtilisateur, date));
				
			if(this.getDaoFactory().getCommentaireSiteDao().addComment(idNewMessage, idSite)) {
				vResult = true;
			}
		}
		
		return vResult;
	}
	
	
}
