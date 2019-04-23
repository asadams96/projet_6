package fr.openclassrooms.projet_6.consumer.impl.rowmapper.site;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.model.site.Site;

public class SiteRM implements RowMapper<Site>{
	
	@Override
	public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    Site site = new Site();
	    
	    site.setIdSite(rs.getInt("id_site"));
	    site.setNom(rs.getString("nom"));
	    site.setDescription(rs.getString("description"));
	    site.setInfoAcces(rs.getString("info_acces"));
	    site.setInfoProximite(rs.getString("info_proximite"));
	    site.setUrlImageSite(rs.getString("url_image_site"));
	    site.setUrlImageAcces(rs.getString("url_image_acces"));
	   
	    return site;
	}
}
