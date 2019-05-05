package fr.openclassrooms.projet_6.business.contract.manager.communication;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireSiteManagerImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'CommentaireSite'</p>
 * 
 * 
 * @see CommentaireSiteManager#getList(String)
 * @see CommentaireSiteManager#addComment(int, String, String)
 * @see CommentaireSiteManagerImpl#getList(String)
 * @see CommentaireSiteManagerImpl#addComment(int, String, String)
 * @see ManagerFactory#getCommentaireSiteManager()
 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
 * @see ManagerFactoryImpl#getCommentaireSiteManager()
 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
 * @see CommentaireSite
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface CommentaireSiteManager {
	
	
	
	/**
	 * <p>Récupère la lite des commentaires d'un site</p>
	 * 
	 * @param idSite L'identifiant du site concerné
	 * @return Une liste d'instance de la classe 'CommentaireSite'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireSiteManagerImpl#getList(String)
	 * @see CommentaireSite
	 * @see Message
	 */
	List<CommentaireSite> getList(String idSite) throws Exception;
	
	
	
	/**
	 * <p>
	 * 	Apres plusieurs étapes de validation =>
	 * 	Demande l'ajout d'un commentaire à la couche du dessous.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idSIte L'identifiant du site concerné
	 * @param contenu Le contenu du commentaire
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireSIteManagerImpl#addComment(int, String, String)
	 * @see CommentaireSIte
	 * @see Message
	 */
	boolean addComment(int idUtilisateur, String idSite, String contenu) throws Exception;
}
