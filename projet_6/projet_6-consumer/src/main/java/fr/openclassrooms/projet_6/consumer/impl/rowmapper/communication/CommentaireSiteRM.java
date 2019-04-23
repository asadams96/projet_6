package fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class CommentaireSiteRM implements RowMapper<Map<String, Integer>> {

	@Override
	public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("idMessage", rs.getInt("id_message"));
		map.put("idSite", rs.getInt("id_site"));
		
		return map;
	}
}
