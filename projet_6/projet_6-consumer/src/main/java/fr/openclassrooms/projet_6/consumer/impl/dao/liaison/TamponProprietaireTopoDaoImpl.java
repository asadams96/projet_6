package fr.openclassrooms.projet_6.consumer.impl.dao.liaison;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.liaison.TamponProprietaireTopoDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.liaison.TamponProprietaireTopoRM;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;



/**
 * <p>Implémentation de l'interface TamponProprietaireTopoDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see TamponProprietaireTopoDao#getTamponByUser(int)
 * @see TamponProprietaireTopoDao#getQuantity(int, String)
 * @see TamponProprietaireTopoDao#addTampon(int, String, int)
 * @see TamponProprietaireTopoDao#removeTampon(int, String, int, int)
 * @see TamponProprietaireTopoDaoImpl#getTamponByUser(int)
 * @see TamponProprietaireTopoDaoImpl#getQuantity(int, String)
 * @see TamponProprietaireTopoDaoImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoDaoImpl#removeTampon(int, String, int, int)
 * @see TamponProprietaireTopoDaoImpl#existTampon(int, String)
 * @see DaoFactory#getTamponProprietaireTopoDao()
 * @see DaoFactory#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 * @see DaoFactoryImpl#getTamponProprietaireTopoDao()
 * @see DaoFactoryImpl#setTamponProprietaireTopoDao(TamponProprietaireTopoDao)
 * @see TamponProprietaireTopo
 * @see RowMapper
 * @see TamponProprietaireTopoRM 
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class TamponProprietaireTopoDaoImpl extends AbstractDao implements TamponProprietaireTopoDao {
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe TamponProprietaireTopo suite à une lecture 
	 * 	de ligne complète de la table public.tampon_proprietaire_topo en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see TamponProprietaireTopo
	 * @see TamponProprietaireTopoDaoImpl#setRowMapper(RowMapper)
	 * @see TamponProprietaireTopoRM
	 */
	private RowMapper<TamponProprietaireTopo> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see TamponProprietaireTopo
	 * @see TamponProprietaireTopoDaoImpl#rowMapper
	 * @see TamponProprietaireTopoRM
	 */
	public void setRowMapper(RowMapper<TamponProprietaireTopo> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see TamponProprietaireTopoDao#getTamponByUser(int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public List<TamponProprietaireTopo> getTamponByUser(int idUtilisateur) throws Exception {
		
		List<TamponProprietaireTopo> tampon = null;

		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			String sql = "SELECT * FROM public.tampon_proprietaire_topo WHERE id_proprietaire = :id_proprietaire";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_proprietaire", idUtilisateur, Types.INTEGER);
			
			tampon = this.getJdbcTemplate().query(sql, map, this.rowMapper);
		}
		
		return tampon;
	}

	
	
	/**
	 * @see TamponProprietaireTopoDao#addTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public boolean addTampon(int idUtilisateur, String idTopo, int quantite) throws Exception {

		Boolean vResult = false;

		if(idTopo != null && !idTopo.isEmpty() 
			&& String.valueOf(quantite) != null && !String.valueOf(quantite).isEmpty() && quantite > 0
						&& String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			String sql;
			int quantitePresente;
			
			if(!this.existTampon(idUtilisateur, idTopo)) {
				sql = "INSERT INTO public.tampon_proprietaire_topo (id_proprietaire, id_topo, quantite) "
						+ "VALUES (:id_utilisateur, :id_topo, :quantite)";
				quantitePresente = 0;
			}
			else {
				sql = "UPDATE public.tampon_proprietaire_topo "
						+ "SET quantite = :quantite "
							+ "WHERE id_proprietaire = :id_utilisateur AND id_topo = :id_topo ";
				quantitePresente = this.getQuantity(idUtilisateur, idTopo);
			}
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			map.addValue("id_topo", idTopo, Types.INTEGER);
			map.addValue("quantite", (quantite+quantitePresente), Types.INTEGER);
			 
			this.getJdbcTemplate().update(sql, map);
			vResult = true;
			
		}
		return vResult;
	}
	
	
	
	/**
	 * <p>
	 * 	Verifie l'existence, dans la table public.tampon_proprietaire_topo, de la ligne unique correspondant 
	 * 	aux identifiants d'utilisateur et de topo, tous deux clefs primaires étrangères, en paramètre de méthode
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * @param idTopo L'identifiant d'un topo
	 * @returnn Un boolean qui confirme en fonction de son état la réussite de l'opération, ou non.
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoDaoImpl#addTampon(int, String, int)
	 */
	public boolean existTampon(int idUtilisateur, String idTopo)  throws Exception {
		
		Boolean vResult = false;
		
		String sql = "SELECT COUNT(*) "
						+ "FROM public.tampon_proprietaire_topo "
							+ "WHERE id_proprietaire = :id_utilisateur AND id_topo = :id_topo";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
		map.addValue("id_topo", idTopo, Types.INTEGER);
		int result = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
		
		if(result != 0) {
			vResult = true;
		}
		return vResult;
	}
	

	
	/**
	 * @see TamponProprietaireTopoDao#removeTampon(int, String, int, int))
	 * @see TamponProprietaireTopo
	 */
	@Override
	public boolean removeTampon(int idUtilisateur, String idTopo, int quantite, int quantiteDispo)  throws Exception {

		Boolean vResult = false;
		
		if(idTopo != null && !idTopo.isEmpty()
			&& String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
			&& String.valueOf(quantite) != null && !String.valueOf(quantite).isEmpty() && quantite > 0
			&& String.valueOf(quantiteDispo) != null && !String.valueOf(quantiteDispo).isEmpty()) {
			
			String sql = "UPDATE public.tampon_proprietaire_topo "
							+ "SET quantite = :quantite "
								+ "WHERE id_proprietaire = :id_utilisateur AND id_topo = :id_topo";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			map.addValue("id_topo", idTopo, Types.INTEGER);
			map.addValue("quantite", (quantiteDispo-quantite), Types.INTEGER);
			
			this.getJdbcTemplate().update(sql, map);
			vResult = true;
			
		}
		return vResult;
	}

	
	/**
	 * @see TamponProprietaireTopoDao#getQuantity(int, String)
	 * @see TamponProprietaireTopo
	 */
	@Override
	public int getQuantity(int idUtilisateur, String idTopo)  throws Exception {

		int vResult = 0;
		
		if(idTopo != null && !idTopo.isEmpty()
			&&	String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty()) {
			
			String sql = "SELECT quantite "
						+ "FROM public.tampon_proprietaire_topo "
						+ "WHERE id_proprietaire = :id_utilisateur AND id_topo = :id_topo";
			
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_utilisateur", idUtilisateur, Types.INTEGER);
			map.addValue("id_topo", idTopo, Types.INTEGER);
			
			vResult = this.getJdbcTemplate().queryForObject(sql, map, Integer.class);
		}
		
		return vResult;
	}
}
