package fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class TamponSiteTopoRM implements RowMapper<Map<String, Integer>> {
	
	@Override
	public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("idSite", rs.getInt("id_site"));
		map.put("idTopo", rs.getInt("id_topo"));
		
		return map;
	}
}
