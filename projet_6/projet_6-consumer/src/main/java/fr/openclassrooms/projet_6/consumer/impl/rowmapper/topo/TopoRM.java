package fr.openclassrooms.projet_6.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>RowMapper de la classe 'Topo'</p>
 * <p>Permet de stocker les informations de la table public.topo</p>
 * 
 * @see TopoRM#mapRow(ResultSet, int)
 * @see TopoDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see Topo
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TopoRM implements RowMapper<Topo> {

	
	
	@Override
	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {

		Topo topo = new Topo();
		
		topo.setIdTopo(rs.getInt("id_topo"));
	    topo.setTitre(rs.getString("titre"));
	    topo.setAuteur(rs.getString("auteur"));
	    topo.setAnnee(rs.getString("annee"));
	    topo.setDescription(rs.getString("description"));
	    topo.setUrlImage(rs.getString("url_image"));
		
		return topo;
	}

}
