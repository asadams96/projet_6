package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class MessageRM implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("idMessage", rs.getInt("id_message"));
		map.put("date", rs.getString("date"));
		map.put("contenu", rs.getString("contenu"));
		map.put("idAuteur", rs.getInt("id_auteur"));
		
	    return map;
	}

}
