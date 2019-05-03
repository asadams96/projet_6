package fr.openclassrooms.projet_6.consumer.impl.dao.liaison;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponSiteTopoDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison.TamponSiteTopoRM;
import fr.openclassrooms.projet_6.model.liaison.TamponSiteTopo;



/**
 * <p>Implémentation de l'interface TamponSiteTopoDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see TamponSiteTopoDao#getTamponBySite(int)
 * @see TamponSiteTopoDao#getTamponByTopo(String)
 * @see TamponSiteTopoDaoImpl#getTamponBySite(int)
 * @see TamponSiteTopoDaoImpl#getTamponByTopo(String)
 * @see DaoFactory#getTamponSiteTopoDao()
 * @see DaoFactory#setTamponSiteTopoDao(TamponSiteTopoDao)
 * @see DaoFactoryImpl#getTamponSiteTopoDao()
 * @see DaoFactoryImpl#setTamponSiteTopoDao(TamponSiteTopoDao)
 * @see TamponSiteTopo
 * @see RowMapper
 * @see TamponSiteTopoRM
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponSiteTopoDaoImpl extends AbstractDao implements TamponSiteTopoDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe TamponSiteTopo suite à une lecture 
	 * 	de ligne complète de la table public.tampon_site_topo en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see TamponSiteTopo
	 * @see TamponSiteTopoDaoImpl#setRowMapper(RowMapper)
	 * @see TamponSiteTopoRM
	 */
	private RowMapper<TamponSiteTopo> rowMapper;
	
	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see TamponSiteTopo
	 * @see TamponSiteTopoDaoImpl#rowMapper
	 * @see TamponSiteTopoRM
	 */
	public void setRowMapper(RowMapper<TamponSiteTopo> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see TamponSiteTopoDao#getTamponByTopo(String)
	 * @see TamponSiteTopo
	 */
	@Override
	public List<TamponSiteTopo> getTamponByTopo(String idTopo) throws Exception {
		
		List<TamponSiteTopo> tampons = null;
		
		if(String.valueOf(idTopo) != null && !idTopo.isEmpty()) {
			String sql = "SELECT * FROM public.tampon_site_topo WHERE id_topo = :id_topo";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_topo", idTopo, Types.INTEGER);
			
			tampons = getJdbcTemplate().query(sql, map, this.rowMapper);
		}
		
		return tampons;
	}

	
	
	/**
	 * @see TamponSiteTopoDao#getTamponBySite(int)
	 * @see TamponSiteTopo
	 */
	@Override
	public List<Integer> getTamponBySite(int idSite) throws Exception {
		
		List<Integer> tampons = null;
		
		if(String.valueOf(idSite) != null && !String.valueOf(idSite).isEmpty()) {
			String sql = "SELECT id_topo FROM public.tampon_site_topo WHERE id_site = :id_site";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_site", idSite, Types.INTEGER);
			
			tampons = getJdbcTemplate().queryForList(sql, map, Integer.class);
		}
		
		return tampons;
	}
}
