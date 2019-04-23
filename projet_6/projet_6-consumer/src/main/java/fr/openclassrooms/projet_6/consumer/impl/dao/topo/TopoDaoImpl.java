package fr.openclassrooms.projet_6.consumer.impl.dao.topo;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.topo.TopoDao;
import fr.openclassrooms.projet_6.model.topo.Topo;

public class TopoDaoImpl implements TopoDao {

	private RowMapper<Topo> rowMapper;

	public void setRowMapper(RowMapper<Topo> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
