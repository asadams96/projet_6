package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessagePretDao;

public class MessagePretDaoImpl implements MessagePretDao {
	
	private RowMapper<Map<String, Integer>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Integer>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
