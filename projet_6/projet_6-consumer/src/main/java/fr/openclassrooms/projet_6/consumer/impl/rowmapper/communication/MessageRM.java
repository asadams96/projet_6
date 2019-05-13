package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessageDaoImpl;
import fr.openclassrooms.projet_6.model.communication.Message;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>RowMapper de la classe 'Message'</p>
 * <p>Permet de stocker les informations de la table public.message</p>
 * 
 * @see MessageRM#mapRow(ResultSet, int)
 * @see MessageDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Message
 * @see RowMapper
 * @see Utilisateur
 * @see Date
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class MessageRM implements RowMapper<Message> {

	
	
	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
		Message message = new Message();
		
		message.setIdMessage(rs.getInt("id_message"));
		message.setContenu(rs.getString("contenu"));
		message.setAuteur(new Utilisateur(rs.getInt("id_auteur")));
		
		Date date = rs.getTimestamp("date");
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy 'à' HH:mm:ss");
		message.setDate(formater.format(date));
		
	    return message;
	}

}
