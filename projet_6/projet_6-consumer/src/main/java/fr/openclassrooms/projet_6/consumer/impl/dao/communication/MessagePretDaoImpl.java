package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessagePretDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.MessagePretRM;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;



/**
 * <p>Implémentation de l'interface CommentaireSiteDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * 
 * @see MessagePretDao
 * @see DaoFactory#getMessagePretDao()
 * @see DaoFactory#setMessagePretDao(MessagePretDao)
 * @see DaoFactoryImpl#getMessagePretDao()
 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
 * @see MessagePret
 * @see MessagePretRM
 * @see Message
 * @see RowMapper
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class MessagePretDaoImpl extends AbstractDao implements MessagePretDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe MessagePret suite à une lecture 
	 * 	de ligne complète de la table public.message_pret en base de donnée
	 * </p>
	 * 	ICI
	 * @see RowMapper
	 * @see MessagePret
	 * @see MessagePretDaoImpl#setRowMapper(RowMapper)
	 * @see MessagePretRM
	 */
	private RowMapper<Map<String, Integer>> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see MessagePret
	 * @see MessagePretDaoImpl#rowMapper
	 * @see MessagePretRM
	 */
	public void setRowMapper(RowMapper<Map<String, Integer>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
