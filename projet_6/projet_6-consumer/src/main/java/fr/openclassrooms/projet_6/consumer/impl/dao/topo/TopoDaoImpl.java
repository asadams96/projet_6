package fr.openclassrooms.projet_6.consumer.impl.dao.topo;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.topo.TopoDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;
import fr.openclassrooms.projet_6.model.topo.Topo;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>Implémentation de l'interface TopoDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see TopoDao#getTopo(String)
 * @see TopoDao#getList()
 * @see TopoDaoImpl#getTopo(String)
 * @see TopoDaoImpl#getList()
 * @see DaoFactory#getTopoDao()
 * @see DaoFactory#setTopoDao(TopoDao)
 * @see DaoFactoryImpl#getTopoDao()
 * @see DaoFactoryImpl#setTopoDao(TopoDao)
 * @see Topo
 * @see RowMapper
 * @see TopoRM
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
 public class TopoDaoImpl extends AbstractDao implements TopoDao {
	 
	 
	 
	/**
	 * <p>
	 * 	Construit une instance de la classe Topo suite à une lecture 
	 * 	de ligne complète de la table public.topo en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Topo
	 * @see TopoDaoImpl#setRowMapper(RowMapper)
	 * @see TopoRM
	 */
	private RowMapper<Topo> rowMapper;
	
	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Topo
	 * @see TopoDaoImpl#rowMapper
	 * @see TopoRM
	 */
	public void setRowMapper(RowMapper<Topo> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see TopoDao#getTopo(String)
	 * @see Topo
	 */
	@Override
	public Topo getTopo(String idTopo)  throws Exception {
		Topo topo = null;
		
		if(idTopo != null && !idTopo.isEmpty()) {
	
			String sql = "SELECT * FROM public.topo WHERE id_topo = :id_topo";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_topo", idTopo, Types.INTEGER);
			
			topo = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
			
			
		}

		
		return topo;
	}

	
	
	
	/**
	 * @see TopoDao#getList()
	 * @see Topo
	 */
	@Override
	public List<Topo> getList() throws Exception {
		
		List<Topo> listTopo = null;
		
		String sql = "SELECT * FROM public.topo";
		listTopo = this.getJdbcTemplate().query(sql, this.rowMapper);
		
		return listTopo;
		
	}

}
