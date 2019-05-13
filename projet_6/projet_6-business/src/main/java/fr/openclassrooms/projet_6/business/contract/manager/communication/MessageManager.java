package fr.openclassrooms.projet_6.business.contract.manager.communication;

import java.sql.Timestamp;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessageManagerImpl;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'Message'</p>
 * 
 * 
 * @see MessageManager#addMessage(int, String, Timestamp)
 * @see MessageManager#getMessage(int)
 * @see MessageManager#getIdMessage(int, Timestamp)
 * @see MessageManagerImpl#addMessage(int, String, Timestamp)
 * @see MessageManagerImpl#getMessage(int)
 * @see MessageManagerImpl#getIdMessage(int, Timestamp)
 * @see ManagerFactory#getMessageManager()
 * @see ManagerFactory#setMessageManager(MessageManager)
 * @see ManagerFactoryImpl#getMessageManager()
 * @see ManagerFactoryImpl#setMessageManager(MessageManager)
 * @see Message
 * @see Timestamp
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface MessageManager {

	
	
	/**
	 * <p>Demande l'ajout d'un commentaire à la couche du dessous.</p>
	 * 
	 * @param idUtilisateur idUtilisateur L'identifiant de l'auteur du message
	 * @param contenu Le contenu du message
	 * @param date La date du message
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageManagerImpl#addMessage(int, String, Timestamp)
	 */
	Boolean addMessage(int idUtilisateur, String contenu, Timestamp date) throws Exception;

	
	
	/**
	 * <p>Récupère une instance de la classe Message en fonction de l'identifiant passé en paramètres</p>
	 * 
	 * @param idMessage
	 * @return Une instance de la classe 'Message'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageManagerImpl#getMessage(int)
	 * @see Message
	 */
	Message getMessage(int idMessage) throws Exception;

	
	
	/**
	 * <p>Récupère l'identifiant du message en fonction des paramètres de la méthode</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'auteur du message
	 * @param date La date du message
	 * @return Un string représentant un identifiant de message
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageManagerImpl#getIdMessage(int, Timestamp)
	 */
	String getIdMessage(int idUtilisateur, Timestamp date) throws Exception;

}
