package fr.openclassrooms.projet_6.business.contract.manager.communication;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.CommentaireTopoManagerImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'CommentaireTopo'</p>
 * 
 * @see CommentaireTopoManager#getList(String)
 * @see CommentaireTopoManager#addComment(int, String, String)
 * @see CommentaireTopoManagerImpl#getList(String)
 * @see CommentaireTopoManagerImpl#addComment(int, String, String)
 * @see ManagerFactory#getCommentaireTopoManager()
 * @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
 * @see ManagerFactoryImpl#getCommentaireTopoManager()
 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
 * @see CommentaireTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface CommentaireTopoManager {

	
	
	/**
	 * <p>Récupère la lite des commentaires d'un topo</p>
	 * 
	 * @param idTopo L'identifiant du topo concerné
	 * @return Une liste d'instance de la classe 'CommentaireTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireTopoManagerImpl#getList(String)
	 * @see CommentaireTopo
	 * @see Message
	 */
	List<CommentaireTopo> getList(String idTopo) throws Exception;

	
	
	/**
	 * <p>Demande l'ajout d'un commentaire à la couche du dessous.</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param contenu Le contenu du commentaire
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireTopoManagerImpl#addComment(int, String, String)
	 * @see CommentaireTopo
	 * @see Message
	 */
	boolean addComment(int idUtilisateur, String idTopo, String contenu)throws Exception ;

}
