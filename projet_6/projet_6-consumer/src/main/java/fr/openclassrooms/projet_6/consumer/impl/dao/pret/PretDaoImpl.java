package fr.openclassrooms.projet_6.consumer.impl.dao.pret;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;

public class PretDaoImpl implements PretDao {
	
	private RowMapper<Map<String, Object>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
