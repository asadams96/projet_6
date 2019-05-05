package fr.openclassrooms.projet_6.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.SecteurDaoImpl;
import fr.openclassrooms.projet_6.model.site.Secteur;



/**
 * <p>RowMapper de la classe 'Secteur'</p>
 * <p>Permet de stocker les informations de la table public.secteur</p>
 * 
 * @see SecteurRM#mapRow(ResultSet, int)
 * @see SecteurDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Secteur
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class SecteurRM implements RowMapper<Secteur> {

	
	
	@Override
	public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {

		Secteur secteur = new Secteur();
		
		secteur.setIdSecteur(rs.getInt("id_secteur"));
		secteur.setNumero(rs.getInt("numero"));
		secteur.setNom(rs.getString("nom"));
		secteur.setType(rs.getString("type"));
		secteur.setOrientation(rs.getString("orientation"));
		secteur.setInfo(rs.getString("info"));
		secteur.setUrlImage(rs.getString("url_image"));
		secteur.setIdSite(rs.getInt("id_site"));
		
		return secteur;
	}

}
