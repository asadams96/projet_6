package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.site.SiteDao;
import fr.openclassrooms.projet_6.model.site.Site;

public class SiteDaoImpl implements SiteDao {

	private RowMapper<Site> rowMapper;

	public void setRowMapper(RowMapper<Site> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
