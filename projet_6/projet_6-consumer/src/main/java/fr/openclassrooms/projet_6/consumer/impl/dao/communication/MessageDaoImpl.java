package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessageDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.MessageRM;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.communication.MessagePret;



/**
 * <p>Implémentation de l'interface MessageDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
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
 * @see RowMapper
 * @see MessageRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * @see MessageDaoImpl#rowMapper
 * @see MessageDaoImpl#setRowMapper(RowMapper)
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
 public class MessageDaoImpl extends AbstractDao implements MessageDao {

	 
	
	/**
	 * <p>
	 * 	Construit une instance de la classe Message suite à une lecture 
	 * 	de ligne complète de la table public.message en base de donnée
	 * </p>
	 * 	ICI
	 * @see RowMapper
	 * @see Message
	 * @see MessageDaoImpl#setRowMapper(RowMapper)
	 * @see MessageRM 
	 */
	private RowMapper<Message> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Message
	 * @see MessageDaoImpl#rowMapper
	 * @see MessageRM
	 */
	public void setRowMapper(RowMapper<Message> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	/**
	 * @see MessageDao#getMessage(int)
	 * @see Message
	 */
	@Override
	public Message getMessage(int idMessage)  throws Exception{
							
		String sql = "SELECT * FROM public.message WHERE id_message = :id_message";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_message", idMessage, Types.INTEGER);
		Message message = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
		
		return message;
	}

	
	
	/**
	 * @see MessageDao#getIdMessage(int, Date)
	 * @see Message
	 */
	@Override
	public String getIdMessage(int idUtilisateur, Date date)  throws Exception{
		
					
		String sql = "SELECT id_message FROM public.message "
						+ "WHERE id_auteur = :id_utilisateur AND date = :date";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
		map.addValue("date", date, Types.TIMESTAMP);

		String vResult = this.getJdbcTemplate().queryForObject(sql, map, String.class);
		
		return vResult;
	}

	
	
	/**
	 * @see MessageDao#addMessage(int, String, Date))
	 * @see Message
	 */
	@Override
	public boolean addMessage(int idUtilisateur, String contenu, Date date)  throws Exception{
					
		String sql = "INSERT INTO public.message (date, contenu, id_auteur) "
							+ "VALUES (:date, :contenu , :id_utilisateur)";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("date", date, Types.TIMESTAMP);
		map.addValue("contenu", contenu, Types.VARCHAR);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		this.getJdbcTemplate().update(sql, map);
				
		return true;
	}
	
}
