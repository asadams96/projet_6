package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessagePretDaoImpl;
import fr.openclassrooms.projet_6.model.communication.MessagePret;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe MessagePret</p>
 * 
 * 
 * @see MessagePretDaoImpl
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

}
