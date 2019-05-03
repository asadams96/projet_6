package fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponSiteTopoDaoImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.topo.Topo;



/**
 * <p>RowMapper de la classe 'TamponSiteTopo'</p>
 * <p>Permet de stocker les informations de la table public.tampon_site_topo</p>
 * 
 * @see TamponSiteTopoRM#mapRow(ResultSet, int)
 * @see TamponSiteTopoDaoImpl#setRowMapper(RowMapper)
 * @see DaoFactoryImpl
 * @see TamponSiteTopo
 * @see RowMapper
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponSiteTopoRM implements RowMapper<TamponSiteTopo> {
	
	
	
	@Override
	public TamponSiteTopo mapRow(ResultSet rs, int rowNum) throws SQLException {

		TamponSiteTopo tampon = new TamponSiteTopo();
		tampon.setSite(new Site(rs.getInt("id_site")));
		tampon.setTopo(new Topo(rs.getInt("id_topo")));
		
		return tampon;
	}
}
