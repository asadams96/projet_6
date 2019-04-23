package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.site.VoieDao;

public class VoieDaoImpl implements VoieDao {

	private RowMapper<Map<String, Object>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
