package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireSiteDaoImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>RowMapper de la classe 'CommentaireSite'</p>
 * <p>Permet de stocker les informations de la table public.commentaire_site</p>
 * 
 * @see CommentaireSiteRM#mapRow(ResultSet, int)
 * @see CommentaireSiteDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see CommentaireSite
 * @see RowMapper
 * @see Site
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireSiteRM implements RowMapper<CommentaireSite> {

	
	
	@Override
	public CommentaireSite mapRow(ResultSet rs, int rowNum) throws SQLException {

		CommentaireSite commentaire = new CommentaireSite();
		
		commentaire.setIdMessage(rs.getInt("id_message"));
		commentaire.setSite(new Site(rs.getInt("id_site")));
				
		return commentaire;
	}
}
