package fr.openclassrooms.projet_6.consumer.impl.dao.pret;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.topo.TopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.pret.PretRM;
import fr.openclassrooms.projet_6.model.pret.Pret;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;

/**
 * <p>Implémentation de l'interface PretDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see PretDaoImpl#getCountId(String)
 * @see PretDaoImpl#getPret(String)
 * @see PretDaoImpl#getListPret(String, String)
 * @see PretDaoImpl#getListPret(String, String, String)
 * @see PretDaoImpl#updateEtat(Pret, String)
 * @see PretDaoImpl#insert(Timestamp, String, String, String, String)
 * @see PretDaoImpl#getEtat(String)
 * @see PretDaoImpl#getIdPret(Timestamp, String, String, String)
 * @see PretDao#getCountId(String)
 * @see PretDao#getPret(String)
 * @see PretDao#getListPret(String, String)
 * @see PretDao#getListPret(String, String, String)
 * @see PretDao#updateEtat(Pret, String)
 * @see PretDao#getEtat(String)
 * @see PretDao#insert(Timestamp, String, String, String, String)
 * @see PretDao#getIdPret(Timestamp, String, String, String)
 * @see DaoFactory#getPretDao()
 * @see DaoFactory#setPretDao(PretDao)
 * @see DaoFactoryImpl#getPretDao()
 * @see DaoFactoryImpl#setPretDao(PretDao)
 * @see Pret
 * @see RowMapper
 * @see PretRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * @see PretDaoImpl#rowMapper
 * @see PretDaoImpl#setRowMapper(RowMapper)
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class PretDaoImpl extends AbstractDao implements PretDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe Pret suite à une lecture 
	 * 	de ligne complète de la table public.pret en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Pret
	 * @see PretDaoImpl#setRowMapper(RowMapper)
	 * @see PretRM
	 */
	private RowMapper<Pret> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Pret
	 * @see PretDaoImpl#rowMapper
	 * @see PretRM
	 */
	public void setRowMapper(RowMapper<Pret> rowMapper) {
		this.rowMapper = rowMapper;
	}

	

	/**
	 * @see PretDao#getCountId(String)
	 */
	@Override
	public String getCountId(String idPret) throws Exception {		
			
		String sql = "SELECT COUNT(id_pret) FROM public.pret WHERE id_pret = :id_pret";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_pret", idPret, Types.INTEGER);
			
		int resultat = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
			
		String vResult = String.valueOf(resultat);
				
		return vResult;
	}


	
	/**
	 * @see PretDao#getPret(String)
	 * @see Pret
	 */
	@Override
	public Pret getPret(String idPret) throws Exception {
				
			
		String sql = "SELECT * FROM public.pret WHERE id_pret = :id_pret";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_pret", idPret, Types.INTEGER);
			
		Pret pret = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
			
		return pret;
	}



	/**
	 * @see PretDao#getListPret(String, String, String)
	 * @see Pret
	 */
	@Override
	public List<Pret> getListPret(String idUtilisateur, String etat, String type) throws Exception {
				
		String sql= null;
		
		if(type.equals("pret")) {
			sql = "SELECT * FROM public.pret WHERE id_proprietaire = :id_utilisateur AND etat = :etat";
		}
				
		else if(type.equals("emprunt")) {
			sql = "SELECT * FROM public.pret WHERE id_utilisateur = :id_utilisateur AND etat = :etat";
		}
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
		map.addValue("etat", etat, Types.VARCHAR);
					
		List<Pret> listPret = this.getJdbcTemplate().query(sql, map, this.rowMapper);				
		
		return listPret;
	}



	/**
	 * @see PretDao#getListPret(String, String)
	 * @see Pret
	 */
	@Override
	public List<Pret> getListPret(String idUtilisateur, String type) throws Exception {
						
		String sql = null;
				
		if(type.equals("pret")) {
			sql = "SELECT * FROM public.pret WHERE id_proprietaire = :id_utilisateur";
		}
				
		else if(type.equals("emprunt")) {
			sql = "SELECT * FROM public.pret WHERE id_utilisateur = :id_utilisateur";
		}
				
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
		
		List<Pret> listPret = this.getJdbcTemplate().query(sql, map, this.rowMapper);				
	
		return listPret;
	}


	
	/**
	 * @see PretDao#updateEtat(Pret, String)
	 */
	@Override
	public boolean updateEtat(Pret pret, String etat) throws Exception {
		
		String sql = "UPDATE public.pret SET etat = :etat WHERE id_pret = :id_pret";
				
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("etat", etat, Types.VARCHAR);
		map.addValue("id_pret", pret.getIdPret(), Types.INTEGER);
				
		this.getJdbcTemplate().update(sql, map);
					
		return true;
	}
	
	
	
	/**
	 * @see PretDao#getEtat(String)	
	 */
	@Override
	public String getEtat(String idPret) throws Exception {
					
		String sql = "SELECT etat FROM public.pret WHERE id_pret = :id_pret";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_pret", idPret, Types.INTEGER);
			
		String vResult = this.getJdbcTemplate().queryForObject(sql, map, String.class);
				
		return vResult;
		
	}



	/**
	 * @see PretDao#insert(Timestamp, String, String, String, String)
	 * @see Timestamp
	 */
	@Override
	public boolean insert(Timestamp date, String idTopo, String idProprietaire, String idUtilisateur, String etat1)	throws Exception {
		
		String sql = "INSERT INTO public.pret (date, etat, id_utilisateur, id_topo, id_proprietaire) "
							+ "VALUES (:date, :etat, :id_utilisateur, :id_topo, :id_proprietaire)";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("date", date, Types.TIMESTAMP);
		map.addValue("etat", etat1, Types.VARCHAR);
		map.addValue("id_utilisateur", Integer.valueOf(idUtilisateur), Types.INTEGER);
		map.addValue("id_topo", Integer.valueOf(idTopo), Types.INTEGER);
		map.addValue("id_proprietaire", Integer.valueOf(idProprietaire), Types.INTEGER);
		
		this.getJdbcTemplate().update(sql, map);
		
		return true;
	}



	/**
	 * @see PretDao#getIdPret(Timestamp, String, String, String)
	 */
	@Override
	public String getIdPret(Timestamp date, String idTopo, String idProprietaire, String idUtilisateur) throws Exception {
		
		String sql = "SELECT id_pret FROM public.pret "
					+ "WHERE date = :date AND id_topo = :id_topo "
					+ "AND id_proprietaire = :id_proprietaire AND id_utilisateur = :id_utilisateur";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("date", date, Types.TIMESTAMP);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
		map.addValue("id_topo", idTopo, Types.INTEGER);
		map.addValue("id_proprietaire", idProprietaire, Types.INTEGER);
		
		String vResult = String.valueOf(this.getJdbcTemplate().queryForObject(sql, map, Integer.class));

		return vResult;
	}

}
