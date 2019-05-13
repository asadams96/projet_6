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
 * @see UtilisateurDao#addUtilisateur(Utilisateur)
 * @see UtilisateurDao#getIdByMail(String)
 * @see UtilisateurDao#getCountMail(String)
 * @see UtilisateurDao#getCountId(String)
 * @see UtilisateurDao#setMailById(String, String)
 * @see UtilisateurDao#setPseudoById(String, String)
 * @see UtilisateurDao#setLocalisationById(String, String)
 * @see UtilisateurDao#setPassById(String, String, String)
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
 * @see UtilisateurDaoImpl#getPass(int)
 * @see UtilisateurDaoImpl#getUtilisateur(int)
 * @see UtilisateurDaoImpl#getIdByMail(String)
 * @see UtilisateurDaoImpl#getCountMail(String)
 * @see UtilisateurDaoImpl#getCountId(String)
 * @see UtilisateurDaoImpl#setMailById(String, String)
 * @see UtilisateurDaoImpl#setPseudoById(String, String)
 * @see UtilisateurDaoImpl#setLocalisationById(String, String)
 * @see UtilisateurDaoImpl#setPassById(String, String, String)
 * @see UtilisateurDaoImpl#rowMapper
 * @see UtilisateurDaoImpl#setRowMapper(RowMapper)
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
		
		String sql = "SELECT pass FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		String pass = this.getJdbcTemplate().queryForObject(sql,map, String.class);
		
		return pass;		
	}

	
	
	/**
	 * @see UtilisateurDao#getUtilisateur(int)
	 * @see Utilisateur
	 */
	@Override
	public Utilisateur getUtilisateur(int idUtilisateur) throws Exception {
				
		String sql = "SELECT * FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		Utilisateur utilisateur = this.getJdbcTemplate().queryForObject(sql, map, this.rowMapper);
		
		return utilisateur;
	}



	/**
	 * @see UtilisateurDao#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean addUtilisateur(Utilisateur utilisateur) throws Exception {
								
		String sql = "INSERT INTO public.utilisateur " + 
						"(mail, pseudo, nom, prenom, civilite, localisation, pass) " + 
					"VALUES " + 
						"(:mail, :pseudo, :nom, :prenom, :civilite, :localisation, :pass)";
				
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", utilisateur.getMail(), Types.VARCHAR);
		map.addValue("pseudo", utilisateur.getPseudo(), Types.VARCHAR);
		map.addValue("nom", utilisateur.getNom(), Types.VARCHAR);
		map.addValue("prenom", utilisateur.getPrenom(), Types.VARCHAR);
		map.addValue("civilite", utilisateur.getCivilite(), Types.VARCHAR);
		map.addValue("localisation", utilisateur.getLocalisation(), Types.VARCHAR);
		map.addValue("pass", utilisateur.getPass(), Types.VARCHAR);
				
		this.getJdbcTemplate().update(sql, map);
		
		return true;
	}
	
	

	/**
	 * @see UtilisateurDao#getIdByMail(String)
	 * @see Utilisateur
	 */
	@Override
	public String getIdByMail(String mail) throws Exception {
					
		String sql = "SELECT id_utilisateur FROM public.utilisateur WHERE mail = :mail";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", mail, Types.VARCHAR);
			
		String idUtilisateur = String.valueOf(this.getJdbcTemplate().queryForObject(sql, map, Integer.class));
		
		return idUtilisateur;
	}



	/**
	 * @see UtilisateurDao#getCountMail(String)
	 * @see Utilisateur
	 */
	@Override
	public int getCountMail(String mail) throws Exception {
						
		String sql = "SELECT COUNT(mail) FROM public.utilisateur WHERE mail = :mail";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", mail, Types.VARCHAR);
			
		int vResult = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
		
		return vResult;
	}
	
	
	
	/**
	 * @see UtilisateurDao#getCountId(String)
	 * @see Utilisateur
	 */
	@Override
	public int getCountId(String idUtilisateur) throws Exception {
			
		String sql = "SELECT COUNT(id_utilisateur) FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", Integer.valueOf(idUtilisateur), Types.INTEGER);
			
		int vResult = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
			
		return vResult;
	}



	/**
	 * @see UtilisateurDao#setMailById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setMailById(String idUtilisateur, String mail) throws Exception {
		
		String sql = "UPDATE public.utilisateur "
								+ "SET mail = :mail "
									+ "WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("mail", mail, Types.VARCHAR);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		this.getJdbcTemplate().update(sql, map);
			
		return true;
	}


	
	/**
	 * @see UtilisateurDao#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception {

		String sql = "UPDATE public.utilisateur "
								+ "SET pseudo = :pseudo "
									+ "WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("pseudo", pseudo, Types.VARCHAR);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		this.getJdbcTemplate().update(sql, map);
				
		return true;
	}



	/**
	 * @see UtilisateurDao#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception {	
			
		String sql = "UPDATE public.utilisateur "
								+ "SET localisation = :localisation "
									+ "WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("localisation", localisation, Types.VARCHAR);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		this.getJdbcTemplate().update(sql, map);
	
		return true;
	}



	/**
	 * @see UtilisateurDao#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception {
			
		String sql = "UPDATE public.utilisateur "
								+ "SET pass = :pass "
									+ "WHERE id_utilisateur = :id_utilisateur";
			
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("pass", pass, Types.VARCHAR);
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
		this.getJdbcTemplate().update(sql, map);
		
		return true;
	}
}
