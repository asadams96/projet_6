package fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur;

import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.utilisateur.UtilisateurDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.utilisateur.UtilisateurRM;
import fr.openclassrooms.projet_6.model.utilisateur.Utilisateur;



/**
 * <p>Implémentation de l'interface UtilisateurDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see UtilisateurDao#getPass(int)
 * @see UtilisateurDao#getUtilisateur(int)
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
 * @see DaoFactory#getUtilisateurDao()
 * @see DaoFactory#setUtilisateurDao(UtilisateurDao)
 * @see DaoFactoryImpl#getUtilisateurDao()
 * @see DaoFactoryImpl#setUtilisateurDao(UtilisateurDao)
 * @see Utilisateur
 * @see UtilisateurRM
 * @see RowMapper
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class UtilisateurDaoImpl extends AbstractDao implements UtilisateurDao {

	
	/**
	 * <p>
	 * 	Construit une instance de la classe Utilisateur suite à une lecture 
	 * 	de ligne complète de la table public.utilisateur en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Utilisateur
	 * @see UtilisateurDaoImpl#setRowMapper(RowMapper)
	 * @see UtilisateurRM
	 */
	private RowMapper<Utilisateur> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Utilisateur
	 * @see UtilisateurDaoImpl#rowMapper
	 * @see UtilisateurRM
	 */
	public void setRowMapper(RowMapper<Utilisateur> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see UtilisateurDao#checkCoupleIdPass(int)
	 * @see Utilisateur
	 */
	@Override
	public String getPass(int idUtilisateur) throws Exception {
		
		String pass = null;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			String sql = "SELECT pass FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			pass = this.getJdbcTemplate().queryForObject(sql,map, String.class);
		
		}
		
		return pass;		
	}

	
	
	/**
	 * @see UtilisateurDao#getUtilisateur(int)
	 * @see Utilisateur
	 */
	@Override
	public Utilisateur getUtilisateur(int idUtilisateur) throws Exception {
		
		Utilisateur utilisateur = null;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			String sql = "SELECT * FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			utilisateur = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
		
		}
		
		return utilisateur;
	}
}
