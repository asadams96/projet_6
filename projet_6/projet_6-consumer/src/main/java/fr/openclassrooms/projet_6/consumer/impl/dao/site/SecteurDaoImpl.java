package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.SecteurDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.SecteurRM;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Site;



/**
 * <p>Implémentation de l'interface SecteurDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see SecteurDao#getIdsSiteByOrientation(String)
 * @see SecteurDao#getIdsSiteByType(String)
 * @see SecteurDao#checkType(int)
 * @see SecteurDao#checkOrientation(int)
 * @see SecteurDaoImpl#getIdsSiteByOrientation(String)
 * @see SecteurDaoImpl#getIdsSiteByType(String)
 * @see SecteurDaoImpl#checkType(int)
 * @see SecteurDaoImpl#checkOrientation(int)
 * @see DaoFactory#getSecteurDao()
 * @see DaoFactory#setSecteurDao(SecteurDao)
 * @see DaoFactoryImpl#getSecteurDao()
 * @see DaoFactoryImpl#setSecteurDao(SecteurDao)
 * @see Secteur
 * @see RowMapper
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class SecteurDaoImpl extends AbstractDao implements SecteurDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe Secteur suite à une lecture 
	 * 	de ligne complète de la table public.secteur en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Secteur
	 * @see SecteurDaoImpl#setRowMapper(RowMapper)
	 * @see SecteurRM
	 */
	private RowMapper<Secteur> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Secteur
	 * @see SecteurDaoImpl#rowMapper
	 * @see SecteurRM
	 */
	public void setRowMapper(RowMapper<Secteur> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see SecteurDao#getIdsSiteByType(String)
	 * @see Secteur
	 * @see Site
	 */
	@Override
	public List<Integer> getIdsSiteByType(String critereType)  throws Exception {
		
		List<Integer> listIdSite = null;

		if(critereType != null && !critereType.isEmpty()) {
			
			String sql = "SELECT id_site FROM public.secteur WHERE type = :type";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("type", critereType, Types.VARCHAR);
			
			listIdSite = this.getJdbcTemplate().queryForList(sql, map, Integer.class);
		}
		
		return listIdSite;
	}

	
	
	/**
	 * @see SecteurDao#getIdsSiteByOrientation(String)
	 * @see Secteur
	 * @see Site
	 */
	@Override
	public List<Integer> getIdsSiteByOrientation(String critereOrientation) throws Exception {
		
		List<Integer> listIdSite = null;

		if(critereOrientation != null && !critereOrientation.isEmpty()) {
			
			String sql = "SELECT id_site FROM public.secteur WHERE orientation = :orientation";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("orientation", critereOrientation, Types.VARCHAR);
			
			listIdSite = this.getJdbcTemplate().queryForList(sql, map, Integer.class);
		}
		
		return listIdSite;
	}

	
	/**
	 * @see Secteur#checkType(int)
	 * @see Secteur
	 * @see Site
	 */
	@Override
	public List<String> checkType(int idSite) throws Exception {
		
		List<String> vResult = null;

		if(String.valueOf(idSite) != null && !String.valueOf(idSite).isEmpty()) {
			
			String sql = "SELECT type FROM public.secteur WHERE id_site = :id_site";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_site", idSite, Types.INTEGER);
			
			vResult = this.getJdbcTemplate().queryForList(sql, map, String.class);
		}
		
		return vResult;
	}

	
	/**
	 * @see SecteurDao#checkOrientation(int)
	 * @see Secteur
	 * @see Site
	 */
	@Override
	public List<String> checkOrientation(int idSite) throws Exception {
		
		List<String> vResult = null;

		if(String.valueOf(idSite) != null && !String.valueOf(idSite).isEmpty()) {
			
			String sql = "SELECT orientation FROM public.secteur WHERE id_site = :id_site";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_site", idSite, Types.INTEGER);
			
			vResult = this.getJdbcTemplate().queryForList(sql, map, String.class);
		}
		
		return vResult;
	}
}
