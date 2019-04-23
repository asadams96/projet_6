package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.communication.MessageDao;

public class MessageDaoImpl implements MessageDao {

	private RowMapper<Map<String, Object>> rowMapper;

	public void setRowMapper(RowMapper<Map<String, Object>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
