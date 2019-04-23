package fr.openclassrooms.projet_6.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class SecteurRM implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("idSecteur", rs.getInt("id_secteur"));
		map.put("nom", rs.getString("nom"));
		map.put("type", rs.getString("type"));
		map.put("orientation", rs.getString("orientation"));
		map.put("info", rs.getString("info"));
		map.put("urlImage", rs.getString("url_image"));
		map.put("idSite", rs.getInt("id_site"));
		
		return map;
	}

}
