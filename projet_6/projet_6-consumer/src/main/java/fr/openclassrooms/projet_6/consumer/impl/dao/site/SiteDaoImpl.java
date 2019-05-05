package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SiteDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.SiteRM;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;
import fr.openclassrooms.projet_6.model.site.Voie;



/**
 * <p>Implémentation de l'interface SiteDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see SiteDao#getSite(int)
 * @see SiteDao#getIdsSiteByLocalisation(String)
 * @see SiteDao#checkLocalisation(int)
 * @see SiteDao#getList()
 * @see SiteDaoImpl#getSite(int)
 * @see SiteDaoImpl#getIdsSiteByLocalisation(String)
 * @see SiteDaoImpl#checkLocalisation(int)
 * @see SiteDaoImpl#getList()
 * @see DaoFactory#getSiteDao()
 * @see DaoFactory#setSiteDao(SiteDao)
 * @see DaoFactoryImpl#getSiteDao()
 * @see DaoFactoryImpl#setSiteDao(SiteDao)
 * @see Site
 * @see Secteur
 * @see Voie
 * @see RowMapper
 * @see SiteRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class SiteDaoImpl extends AbstractDao implements SiteDao {

	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe Site suite à une lecture 
	 * 	de ligne complète de la table public.site en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Site
	 * @see SiteDaoImpl#setRowMapper(RowMapper)
	 * @see SiteRM
	 */
	private RowMapper<Site> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Site
	 * @see SiteDaoImpl#rowMapper
	 * @see SiteRM
	 */
	public void setRowMapper(RowMapper<Site> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see SiteDao#getSite(int)
	 * @see Site
	 */
	@Override
	public Site getSite(int idSite) throws Exception {
		
		Site site = null;
		
		if(String.valueOf(idSite) != null && !String.valueOf(idSite).isEmpty()) {
			
			String sql = "SELECT * FROM public.site WHERE id_site = :id_site";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_site", idSite, Types.INTEGER);
			site = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
		}

		return site;
	}
	
	

	/**
	 * @see SiteDao#getIdsSiteByLocalisation(String)
	 * @see Site
	 */
	@Override
	public List<Integer> getIdsSiteByLocalisation(String critereLocalisation) throws Exception {
		
		List<Integer> listIdSite = null;

		if(critereLocalisation != null && !critereLocalisation.isEmpty()) {
			
			String sql = "SELECT id_site FROM public.site WHERE localisation = :localisation";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("localisation", critereLocalisation, Types.VARCHAR);
			
			listIdSite = this.getJdbcTemplate().queryForList(sql, map, Integer.class);
		}
		
		return listIdSite;
	}

	
	
	/**
	 * @see SiteDao#checkLocalisation(int)
	 * @see Site
	 */
	@Override
	public String checkLocalisation(int idSite) throws Exception {
		
		String vResult = null;

		if(String.valueOf(idSite) != null && !String.valueOf(idSite).isEmpty()) {
			
			String sql = "SELECT localisation FROM public.site WHERE id_site = :id_site";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_site", idSite, Types.INTEGER);
			
			vResult = this.getJdbcTemplate().queryForObject(sql, map, String.class);
		}
		
		return vResult;
	}

	
	
	/**
	 * @see SiteDao#getList()
	 * @see Site
	 */
	@Override
	public List<Site> getList() throws Exception {
		
		List<Site> listSite = null;
		
		String sql = "SELECT * FROM public.site";
		listSite = this.getJdbcTemplate().query(sql, this.rowMapper);
		
		return listSite;
		
	}
	

}
