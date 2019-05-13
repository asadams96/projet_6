package fr.openclassrooms.projet_6.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.site.VoieDaoImpl;
import fr.openclassrooms.projet_6.model.site.Voie;



/**
 * <p>RowMapper de la classe 'Voie'</p>
 * <p>Permet de stocker les informations de la table public.voie</p>
 * 
 * @see VoieRM#mapRow(ResultSet, int)
 * @see VoieDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Voie
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class VoieRM implements RowMapper<Voie> {
	
	@Override
	public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {

		Voie voie = new Voie();
		
		voie.setIdVoie(rs.getInt("id_voie"));
		voie.setNumero(rs.getInt("numero"));
		voie.setNom(rs.getString("nom"));
		voie.setCotation(rs.getString("cotation"));
		voie.setLongueur(rs.getString("longueur"));
		voie.setHauteur(rs.getString("hauteur"));
		voie.setNbrPoint(rs.getString("nbr_point"));
		voie.setTypePoint(rs.getString("type_point"));
		voie.setRemarque(rs.getString("remarque"));
		voie.setIdSecteur(rs.getInt("id_secteur"));
		
		return voie;
	}

}
