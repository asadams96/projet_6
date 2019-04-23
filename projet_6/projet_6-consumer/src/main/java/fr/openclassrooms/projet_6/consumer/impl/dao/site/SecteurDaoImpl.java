package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.site.SecteurDao;

public class SecteurDaoImpl implements SecteurDao {
	
	private RowMapper<Map<String, Object>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
