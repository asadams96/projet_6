package fr.openclassrooms.projet_6.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class VoieRM implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("idVoie", rs.getInt("id_voie"));
		map.put("numero", rs.getInt("numero"));
		map.put("nom", rs.getString("nom"));
		map.put("cotation", rs.getString("cotation"));
		map.put("longueur", rs.getString("longueur"));
		map.put("hauteur", rs.getString("hauteur"));
		map.put("nbrPoint", rs.getString("nbr_point"));
		map.put("typePoint", rs.getString("type_point"));
		map.put("remarque", rs.getString("remarque"));
		map.put("idSecteur", rs.getInt("id_secteur"));
		
		return map;
	}

}
