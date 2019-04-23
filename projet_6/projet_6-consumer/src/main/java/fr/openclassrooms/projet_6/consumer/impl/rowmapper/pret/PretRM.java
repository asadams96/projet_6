package fr.openclassrooms.projet_6.consumer.impl.rowmapper.pret;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class PretRM implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("idPret", rs.getInt("id_pret"));
		map.put("date", rs.getString("date"));
		map.put("etat", rs.getString("etat"));
		map.put("idUtilisateur", rs.getInt("id_utilisateur"));
		map.put("idTopo", rs.getInt("id_topo"));
		map.put("idProprietaire", rs.getInt("id_proprietaire"));
		
		return map;
	}
}
