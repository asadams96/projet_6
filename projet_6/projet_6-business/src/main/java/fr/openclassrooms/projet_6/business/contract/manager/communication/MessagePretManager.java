package fr.openclassrooms.projet_6.business.contract.manager.communication;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.communication.MessagePretManagerImpl;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'MessagePret'</p>
 * 
 * 
 * @see MessagePretManager#getList(String)
 * @see MessagePretManager#addMessage(int, String, String)
 * @see MessagePretManagerImpl#getList(String)
 * @see MessagePretManagerImpl#addMessage(int, String, String)
 * @see ManagerFactory#getMessagePretManager()
 * @see ManagerFactory#setMessagePretManager(MessagePretManager)
 * @see ManagerFactoryImpl#getMessagePretManager()
 * @see ManagerFactoryImpl#setMessagePretManager(MessagePretManager)
 * @see MessagePret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface MessagePretManager {
	
	
	
	/**
	 * <p>Récupère la lite des messages d'un pret</p>
	 * 
	 * @param idPret L'identifiant du prêt concerné
	 * @return Une liste d'instance de la classe 'MessagePret'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessagePretManagerImpl#getList(String)
	 * @see MessagePret
	 * @see Message
	 */
	List<MessagePret> getList(String idPret) throws Exception ;

	
	
	/**
	 * <p>Demande l'ajout d'un message de pret à la couche du dessous.</p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idPret L'identifiant du prêt concerné
	 * @param contenu Le contenu du message
	 * 
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessagePretManagerImpl#addMessage(int, String, String)
	 * @see MessagePret
	 * @see Message
	 */
	boolean addMessage(int idUtilisateur, String idPret, String contenu) throws Exception;

}
