package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireSiteDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe CommentaireSite</p>
 * 
 * 
 * @see CommentaireSiteDao#getIdsComment(String)
 * @see CommentaireSiteDao#addComment(int, String)
 * @see CommentaireSiteDaoImpl#getIdsComment(String)
 * @see CommentaireSiteDaoImpl#addComment(int, String)
 * @see DaoFactory#getCommentaireSiteDao()
 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
 * @see DaoFactoryImpl#getCommentaireSiteDao()
 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
 * @see CommentaireSite
 * @see Message
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface CommentaireSiteDao {
	
	
	
	/**
	 * <p>Récupère une liste d'id de commentaire en fonction de l'identifiant d'un site</p>
	 * 
	 * @param idSite L'identifiant d'un site
	 * @return Une liste d'identifiant de commentaire
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireSiteDaoImpl#getIdsComment(String)
	 * @see CommentaireSite
	 */
	List<Integer> getIdsComment(String idSite) throws Exception;
	
	
	
	/**
	 * <p>Enregistrer le commentaire souhaité</p>
	 * 
	 * @param idNewMessage L'id du commentaire à enregistrer
	 * @param idSite L'identifiant du site concerné par le commentaire
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non. 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireSiteDaoImpl#addComment(int, String)
	 * @see CommentaireSite
	 */
	boolean addComment(int idNewMessage, String idSite) throws Exception;

}
