package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import java.util.List;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessagePretDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.MessagePret;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe MessagePret</p>
 * 
 * 
 * @see MessagePretDaoImpl#getIdsMessage(String)
 * @see MessagePretDaoImpl#addMessage(int, String)
 * @see MessagePretDao#getIdsMessage(String)
 * @see MessagePretDao#addMessage(int, String)
 * @see DaoFactory#getMessagePretDao()
 * @see DaoFactory#setMessagePretDao(MessagePretDao)
 * @see DaoFactoryImpl#getMessagePretDao()
 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
 * @see MessagePret
 * @see Message
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface MessagePretDao {

	
	
	/**
	 * <p>Récupère une liste d'id de message de prêt en fonction de l'identifiant d'un pret</p>
	 * 
	 * @param idPret L'identifiant d'un prêt
	 * @return Une liste d'identifiant de message de prêt
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessagePretDaoImpl#getIdsMessage(String)
	 * @see MessagePretDao
	 */
	List<Integer> getIdsMessage(String idPret) throws Exception;

	
	
	/**
	 * <p>Enregistrer le message de prêt souhaité</p>
	 * 
	 * @param idNewMessage L'id du message à enregistrer
	 * @param idPret L'identifiant du pret concerné par le message
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non. 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessagePretDaoImpl#addMessage(int, String)
	 * @see MessagePretDao
	 */
	boolean addMessage(int idNewMessage, String idPret) throws Exception;

}
