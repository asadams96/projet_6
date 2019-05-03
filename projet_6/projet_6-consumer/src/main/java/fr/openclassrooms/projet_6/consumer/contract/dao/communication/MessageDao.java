package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import java.util.Date;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessageDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SiteDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.site.Site;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe Message</p>
 * 
 * @see MessageDao#getMessage(int)
 * @see MessageDao#addMessage(int, String, Date)
 * @see MessageDao#getIdMessage(int, Date)
 * @see MessageDaoImpl#getMessage(int)
 * @see MessageDaoImpl#addMessage(int, String, Date)
 * @see MessageDaoImpl#getIdMessage(int, Date)
 * @see DaoFactory#getMessageDao()
 * @see DaoFactory#setMessageDao(MessageDao)
 * @see DaoFactoryImpl#getMessageDao()
 * @see DaoFactoryImpl#setMessageDao(MessageDao)
 * @see Message
 * @see CommentaireTopo
 * @see CommentaireSite
 * @see MessagePret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface MessageDao {

	
	
	/**
	 * <p>Récupère un message en fonction du paramètre de méthode 'idMessage'</p>
	 * 
	 * @param idMessage L'identifiant du message
	 * @return Une instance de la classe 'Message'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageDaoImpl#getMessage(int)
	 * @see Message
	 */
	Message getMessage(int idMessage) throws Exception;
	
	
	
	/**
	 * <p>Enregistre le Message souhaité</p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur
	 * @param contenu Le contenu du message
	 * @param date La date du message
	 * 
	 * @return Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non. 
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageDaoImpl#addMessage(int, String, Date)
	 * @see Message
	 */
	boolean addMessage(int idUtilisateur, String contenu, Date date) throws Exception;

	
	
	/**
	 * <p>Récupère un identifiant de message en fonction des paramètres de méthode 'idUtilisateur' et 'date'</p>
	 * 
	 * @param idUtilisateur Un id d'utilisateur
	 * @param date La date du message
	 * 
	 * @return L'identifiant du message associé à l'utilisateur et à la date d'envoi
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see MessageDaoImpl#getIdMessage(int, Date)
	 * @see Message
	 */
	String getIdMessage(int idUtilisateur, Date date) throws Exception;

}
