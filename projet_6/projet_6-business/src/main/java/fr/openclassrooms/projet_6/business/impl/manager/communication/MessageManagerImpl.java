package fr.openclassrooms.projet_6.business.impl.manager.communication;

import java.sql.Timestamp;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessageManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Implémentation de l'interface 'MessageManger'</p>
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
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class MessageManagerImpl extends AbstractManager implements MessageManager {

	
	
	/**
	 * @see MessageManager#addMessage(int, String, Timestamp)
	 */
	@Override
	public Boolean addMessage(int idUtilisateur, String contenu, Timestamp date) throws Exception {	
		
		return this.getDaoFactory().getMessageDao().addMessage(idUtilisateur, contenu, date);
	}

	
	
	/**
	 * @see MessageManager#getMessage(int)
	 * @see Message
	 */
	@Override
	public Message getMessage(int idMessage) throws Exception {
		
		return this.getDaoFactory().getMessageDao().getMessage(idMessage);
	}

	
	
	/**
	 * @see MessageManager#getIdMessage(int, Timestamp)
	 */
	@Override
	public String getIdMessage(int idUtilisateur, Timestamp date) throws Exception {
		
		return this.getDaoFactory().getMessageDao().getIdMessage(idUtilisateur, date);
	}

}
