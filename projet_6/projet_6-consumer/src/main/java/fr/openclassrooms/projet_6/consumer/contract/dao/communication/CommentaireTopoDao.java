package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireTopoDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe CommentaireTopo</p>
 * 
 *  
 * @see CommentaireTopoDao#getIdsComment(String)
 * @see CommentaireTopoDao#addComment(int, String)
 * @see CommentaireTopoDaoImpl#getIdsComment(String)
 * @see CommentaireTopoDaoImpl#addComment(int, String)
 * @see DaoFactory#getCommentaireTopoDao()
 * @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
 * @see DaoFactoryImpl#getCommentaireTopoDao()
 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
 * @see CommentaireTopo
 * @see Message
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface CommentaireTopoDao {

	
	
	/**
	 * <p>Récupère une liste d'id de commentaire en fonction de l'identifiant d'un topo</p>
	 * 
	 * @param idTopo L'identifiant d'un topo
	 * @return Une liste d'identifiant de commentaire
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireTopoDaoImpl#getIdsComment(String)
	 * @see CommentaireTopo
	 */
	List<Integer> getIdsComment(String idTopo) throws Exception;

	
	
	/**
	 * <p>Enregistrer le commentaire souhaité</p>
	 * 
	 * @param idNewMessage L'id du commentaire à enregistrer
	 * @param idTopo L'identifiant du topo concerné par le commentaire
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non. 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see CommentaireTopoDaoImpl#addComment(int, String)
	 * @see CommentaireTopo
	 */
	boolean addComment(int idNewMessage, String idTopo) throws Exception;

}
