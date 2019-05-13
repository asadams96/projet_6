package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessagePretDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.MessagePretRM;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;



/**
 * <p>Implémentation de l'interface CommentaireSiteDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * 
 * @see MessagePretDao#getIdsMessage(String)
 * @see MessagePretDao#addMessage(int, String)
 * @see MessagePretDaoImpl#getIdsMessage(String)
 * @see MessagePretDaoImpl#addMessage(int, String)
 * @see DaoFactory#getMessagePretDao()
 * @see DaoFactory#setMessagePretDao(MessagePretDao)
 * @see DaoFactoryImpl#getMessagePretDao()
 * @see DaoFactoryImpl#setMessagePretDao(MessagePretDao)
 * @see MessagePret
 * @see MessagePretRM
 * @see Message
 * @see RowMapper
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * @see MessagePretDaoImpl#rowMapper
 * @see MessagePretDaoImpl#setRowMapper(RowMapper)
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
	 * 	
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



	/**
	 * @see MessagePretDao#getIdsMessage(String)
	 * @see MessagePretDao
	 */
	@Override
	public List<Integer> getIdsMessage(String idPret) throws Exception {
		
		String sql = "SELECT id_message FROM public.message_pret WHERE id_pret = :id_pret";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_pret", idPret, Types.INTEGER);
		
		List<Integer> listIdsMessage = this.getJdbcTemplate().queryForList(sql, map, Integer.class);
					
		return listIdsMessage;
	}
	
	
	
	/**
	 * @see MessagePretDao#addMessage(int, String)
	 * @see MessagePretDao
	 */
	@Override
	public boolean addMessage(int idNewMessage, String idPret) throws Exception {
			
		String sql = "INSERT INTO public.message_pret (id_message, id_pret) "
						+ "VALUES (:id_message, :id_pret)";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_message", idNewMessage, Types.INTEGER);
		map.addValue("id_pret", idPret, Types.INTEGER);

		this.getJdbcTemplate().update(sql, map);
	
		return true;
	}
	
	
	
}
