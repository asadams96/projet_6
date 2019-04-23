package fr.openclassrooms.projet_6.consumer.impl.dao.liaison;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponProprietaireTopoDao;

public class TamponProprietaireTopoDaoImpl implements TamponProprietaireTopoDao {
	
	private RowMapper<Map<String, Integer>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Integer>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
