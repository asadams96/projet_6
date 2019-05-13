package fr.openclassrooms.projet_6.business.impl.manager.communication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.MessagePretManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;



/**
 * <p>Implémentation de l'interface 'MessagePretManager'</p>
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
public class MessagePretManagerImpl extends AbstractManager implements MessagePretManager {

	
	
	/**
	 * @see MessagePretManager#getList(String)
	 * @see MessagePret
	 * @see Message
	 */
	@Override
	public List<MessagePret> getList(String idPret) throws Exception {
					
		List<Integer> listIdsMessage = this.getDaoFactory().getMessagePretDao().getIdsMessage(idPret);
			
		List<MessagePret>  listMessagePret = new ArrayList<MessagePret>();
			
		for(int idMessage : listIdsMessage) {
				
			Message message = this.getManagerFactory().getMessageManager().getMessage(idMessage);
			

			MessagePret messagePret = new MessagePret(idMessage, message.getDate(), message.getContenu(), 
												this.getDaoFactory().getUtilisateurDao().getUtilisateur(message.getAuteur().getIdUtilisateur()), 
																										this.getDaoFactory().getPretDao().getPret(idPret));
				
			listMessagePret.add(messagePret);
		}
	
		return listMessagePret;
	}

	
	
	/**
	 * @see MessagePretManager#addMessage(int, String, String)
	 * @see MessagePret
	 * @see Message
	 */
	@Override
	public boolean addMessage(int idUtilisateur, String idPret, String contenu) throws Exception {

		Boolean vResult = false;
						
		Timestamp date = new Timestamp(new Date().getTime());			
			
		
		if(this.getManagerFactory().getMessageManager().addMessage(idUtilisateur, contenu, date)) {
				int idNewMessage = Integer.valueOf(this.getManagerFactory().getMessageManager().getIdMessage(idUtilisateur, date));
													
			if(this.getDaoFactory().getMessagePretDao().addMessage(idNewMessage, idPret)) {
				vResult = true;
			}
		}
		
		return vResult;
	}
	
}
