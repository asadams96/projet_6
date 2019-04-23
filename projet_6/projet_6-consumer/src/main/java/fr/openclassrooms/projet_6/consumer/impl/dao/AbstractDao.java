package fr.openclassrooms.projet_6.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AbstractDao {

	private NamedParameterJdbcTemplate jdbcTemplate;
	private MapSqlParameterSource params;
	
	protected NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	protected MapSqlParameterSource getParams() {
		return params;
	}
	public void setParams(MapSqlParameterSource params) {
		this.params = params;
	}
	

}
