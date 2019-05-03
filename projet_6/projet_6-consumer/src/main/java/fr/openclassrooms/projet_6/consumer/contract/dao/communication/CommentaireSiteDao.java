package fr.openclassrooms.projet_6.consumer.contract.dao.communication;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireSiteDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;

/**
 * <p>Interface de la couche consumer</p>
 * <p>Dédié à la récupération et à la sauvegarde des informations concernant la classe CommentaireSite</p>
 * 
 * 
 * @see CommentaireSiteDaoImpl
 * @see DaoFactory#getCommentaireSiteDao()
 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
 * @see DaoFactoryImpl#getCommentaireSiteDao()
 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
 * @see CommentaireSite
 * @see Message
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface CommentaireSiteDao {

}
