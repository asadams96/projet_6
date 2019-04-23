package fr.openclassrooms.projet_6.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.model.topo.Topo;

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
