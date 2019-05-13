package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireTopoDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.topo.Topo;



/**
 * <p>RowMapper de la classe 'CommentaireTopo'</p>
 * <p>Permet de stocker les informations de la table public.commentaire_topo</p>
 * 
 * @see CommentaireTopoRM#mapRow(ResultSet, int)
 * @see CommentaireTopoDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see CommentaireTopo
 * @see RowMapper
 * @see Topo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireTopoRM implements RowMapper<CommentaireTopo> {
	
	@Override
	public CommentaireTopo mapRow(ResultSet rs, int rowNum) throws SQLException {

		CommentaireTopo commentaire = new CommentaireTopo();
		
		commentaire.setIdMessage(rs.getInt("id_message"));
		commentaire.setTopo(new Topo(rs.getInt("id_topo")));
		
		return commentaire;
	}
}
