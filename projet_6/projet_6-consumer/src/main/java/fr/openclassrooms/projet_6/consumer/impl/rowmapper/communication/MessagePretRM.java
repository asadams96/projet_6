package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessagePretDaoImpl;
import fr.openclassrooms.projet_6.model.communication.MessagePret;
import fr.openclassrooms.projet_6.model.pret.Pret;



/**
 * <p>RowMapper de la classe 'MessagePret'</p>
 * <p>Permet de stocker les informations de la table public.message_pret</p>
 * 
 * @see MessagePretRM#mapRow(ResultSet, int)
 * @see MessagePretDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see MessagePret
 * @see RowMapper
 * @see Pret
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class MessagePretRM implements RowMapper<MessagePret> {

	@Override
	public MessagePret mapRow(ResultSet rs, int rowNum) throws SQLException {

		MessagePret message = new MessagePret();
		
		message.setIdMessage(rs.getInt("id_message"));
		message.setPret(new Pret(rs.getInt("id_pret")));
		
		return message;
	}

}
