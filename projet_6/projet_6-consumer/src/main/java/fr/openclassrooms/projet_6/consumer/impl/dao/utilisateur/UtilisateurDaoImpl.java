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
 * @see UtilisateurDaoImpl#validation(String, int, int)
 * @see UtilisateurDaoImpl#MIN_MAIL
 * @see UtilisateurDaoImpl#MIN_NOM
 * @see UtilisateurDaoImpl#MIN_PRENOM
 * @see UtilisateurDaoImpl#MIN_CIVILITE
 * @see UtilisateurDaoImpl#MIN_PSEUDO
 * @see UtilisateurDaoImpl#MIN_PASS
 * @see UtilisateurDaoImpl#MIN_LOCA
 * @see UtilisateurDaoImpl#MAX_MAIL
 * @see UtilisateurDaoImpl#MAX_NOM
 * @see UtilisateurDaoImpl#MAX_PRENOM
 * @see UtilisateurDaoImpl#MAX_CIVILITE
 * @see UtilisateurDaoImpl#MAX_PSEUDO
 * @see UtilisateurDaoImpl#MAX_PASS
 * @see UtilisateurDaoImpl#MAX_LOCA
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
	 * <p>Contrainte de taille minimale pour le paramètre 'mail'</p>
	 * 
	 * @see UtilisateurDaoImpl#mail
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_MAIL = 10;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'nom'</p>
	 * 
	 * @see UtilisateurDaoImpl#nom
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_NOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'prenom'</p>
	 * 
	 * @see UtilisateurDaoImpl#prenom
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_PRENOM = 2;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'civilite'</p>
	 * 
	 * @see UtilisateurDaoImpl#civilite
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_CIVILITE = 1;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'pseudo'</p>
	 * 
	 * @see UtilisateurDaoImpl#pseudo
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_PSEUDO = 5;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour les paramètres 'pass'et 'pasBis'</p>
	 * 
	 * @see UtilisateurDaoImpl#pass
	 * @see UtilisateurDaoImpl#passBis
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_PASS = 8;
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'localisation'</p>
	 * 
	 * @see UtilisateurDaoImpl#localisation
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MIN_LOCA = 8;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'mail'</p>
	 * 
	 * @see UtilisateurDaoImpl#mail
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_MAIL = 50;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'nom'</p>
	 * 
	 * @see UtilisateurDaoImpl#nom
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_NOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'prenom'</p>
	 * 
	 * @see UtilisateurDaoImpl#prenom
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_PRENOM = 30;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'civilite'</p>
	 * 
	 * @see UtilisateurDaoImpl#civilite
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_CIVILITE = 10;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pseudo'</p>
	 * 
	 * @see UtilisateurDaoImpl#pseudo
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_PSEUDO = 20;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'pass'</p>
	 * 
	 * @see UtilisateurDaoImpl#pass
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_PASS = 30;
		
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'localisation'</p>
	 * 
	 * @see UtilisateurDaoImpl#pseudo
	 * @see UtilisateurDaoImpl#validation(String, int, int)
	 */
	private final int MAX_LOCA = 75;
	

	
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



	/**
	 * @see UtilisateurDao#addUtilisateur(Utilisateur)
	 * @see Utilisateur
	 */
	@Override
	public boolean addUtilisateur(Utilisateur utilisateur) throws Exception {

		Boolean vResult = false;
				
		if(utilisateur != null) {
			
			if(utilisateur.getMail() != null || this.validation(utilisateur.getMail(), MIN_MAIL, MAX_MAIL) 
			&& utilisateur.getCivilite() != null || this.validation(utilisateur.getCivilite(), MIN_CIVILITE, MAX_CIVILITE)
			&& utilisateur.getNom() != null || this.validation(utilisateur.getNom(), MIN_NOM, MAX_NOM)
			&& utilisateur.getPrenom() != null || this.validation(utilisateur.getPrenom(), MIN_PRENOM, MAX_PRENOM)
			&& utilisateur.getPseudo() != null || this.validation(utilisateur.getPseudo(), MIN_PSEUDO, MAX_PSEUDO)
			&& utilisateur.getPass() != null || this.validation(utilisateur.getPass(), MIN_PASS, MAX_PASS)
			&& utilisateur.getLocalisation() != null || this.validation(utilisateur.getLocalisation(), MIN_LOCA, MAX_LOCA)) {
				
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
				vResult = true;
			}
		}
		
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à valider les input<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs</li>
	 * 		<li>La taille maximal du champss (lié à l'espace alloué)</li>
	 * </ul>
	 * 
	 * @param input  Le contenu de l'input
	 * @param longueurMin La longueur minimal du champs
	 * @param longueurMax La longueur maximal du champs
	 * @return Retourne le résultat de la validation => validée (=true) / refusée (=false)
	 * 
	 * @see UtilisateurDaoImpl#addUtilisateur(Utilisateur)
	 * @see UtilisateurDaoImpl#MIN_MAIL
	 * @see UtilisateurDaoImpl#MIN_NOM
	 * @see UtilisateurDaoImpl#MIN_PRENOM
	 * @see UtilisateurDaoImpl#MIN_CIVILITE
	 * @see UtilisateurDaoImpl#MIN_PSEUDO
	 * @see UtilisateurDaoImpl#MIN_PASS
	 * @see UtilisateurDaoImpl#MIN_LOCA
	 * @see UtilisateurDaoImpl#MAX_MAIL
	 * @see UtilisateurDaoImpl#MAX_NOM
	 * @see UtilisateurDaoImpl#MAX_PRENOM
	 * @see UtilisateurDaoImpl#MAX_CIVILITE
	 * @see UtilisateurDaoImpl#MAX_PSEUDO
	 * @see UtilisateurDaoImpl#MAX_PASS
	 * @see UtilisateurDaoImpl#MAX_LOCA
	 */
	public Boolean validation(String input, int longueurMin, int longueurMax) {
				
		Boolean vReturn = false;
		
		
		if(input.length() >= longueurMin && input.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}



	/**
	 * @see UtilisateurDao#getIdByMail(String)
	 * @see Utilisateur
	 */
	@Override
	public String getIdByMail(String mail) throws Exception {
		
		String idUtilisateur = null;
			
		if(mail != null && !mail.isEmpty()) {
			
			String sql = "SELECT id_utilisateur FROM public.utilisateur WHERE mail = :mail";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("mail", mail, Types.VARCHAR);
			
			idUtilisateur = String.valueOf(this.getJdbcTemplate().queryForObject(sql, map, Integer.class));
		}
		
		return idUtilisateur;
	}



	/**
	 * @see UtilisateurDao#getCountMail(String)
	 * @see Utilisateur
	 */
	@Override
	public int getCountMail(String mail) throws Exception {
		
		int vResult = 1;
		
		if(mail != null & !mail.isEmpty()) {
			
			String sql = "SELECT COUNT(mail) FROM public.utilisateur WHERE mail = :mail";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("mail", mail, Types.VARCHAR);
			
			vResult = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
			
		}
		
		return vResult;
	}
	
	
	
	/**
	 * @see UtilisateurDao#getCountId(String)
	 * @see Utilisateur
	 */
	@Override
	public int getCountId(String idUtilisateur) throws Exception {
		
		int vResult = 0;
		if(idUtilisateur != null & !idUtilisateur.isEmpty()) {
			
			String sql = "SELECT COUNT(id_utilisateur) FROM public.utilisateur WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", Integer.valueOf(idUtilisateur), Types.INTEGER);
			
			vResult = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
			
		}

		return vResult;
	}



	/**
	 * @see UtilisateurDao#setMailById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setMailById(String idUtilisateur, String mail) throws Exception {
		
		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() && this.getCountId(idUtilisateur) == 1
				&& mail != null && !mail.isEmpty() && this.validation(mail, MIN_MAIL, MAX_MAIL)) {
			
			String sql = "UPDATE public.utilisateur "
									+ "SET mail = :mail "
										+ "WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("mail", mail, Types.VARCHAR);
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			this.getJdbcTemplate().update(sql, map);
			vResult = true;
		}
		
		return vResult;
	}


	
	/**
	 * @see UtilisateurDao#setPseudoById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPseudoById(String idUtilisateur, String pseudo) throws Exception {

		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() && this.getCountId(idUtilisateur) == 1
				&& pseudo != null && !pseudo.isEmpty() && this.validation(pseudo, MIN_PSEUDO, MAX_PSEUDO)) {
			
			String sql = "UPDATE public.utilisateur "
									+ "SET pseudo = :pseudo "
										+ "WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("pseudo", pseudo, Types.VARCHAR);
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			this.getJdbcTemplate().update(sql, map);
			vResult = true;
		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurDao#setLocalisationById(String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setLocalisationById(String idUtilisateur, String localisation) throws Exception {
		
		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() && this.getCountId(idUtilisateur) == 1
				&& localisation != null && !localisation.isEmpty() && this.validation(localisation, MIN_LOCA, MAX_LOCA)) {
			
			String sql = "UPDATE public.utilisateur "
									+ "SET localisation = :localisation "
										+ "WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("localisation", localisation, Types.VARCHAR);
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			this.getJdbcTemplate().update(sql, map);
			vResult = true;		}
		
		return vResult;
	}



	/**
	 * @see UtilisateurDao#setPassById(String, String, String)
	 * @see Utilisateur
	 */
	@Override
	public boolean setPassById(String idUtilisateur, String pass, String passBis) throws Exception {

		Boolean vResult = false ;
		
		if(idUtilisateur != null && !idUtilisateur.isEmpty() && this.getCountId(idUtilisateur) == 1
				&& pass != null && !pass.isEmpty() && this.validation(pass, MIN_PASS, MAX_PASS)
				&& passBis != null && !passBis.isEmpty() && this.validation(passBis, MIN_PASS, MAX_PASS)) {
			
			String sql = "UPDATE public.utilisateur "
									+ "SET pass = :pass "
										+ "WHERE id_utilisateur = :id_utilisateur";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("pass", pass, Types.VARCHAR);
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			
			this.getJdbcTemplate().update(sql, map);
			vResult = true;
			
		}
		
		return vResult;
	}
}
