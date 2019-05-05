package fr.openclassrooms.projet_6.consumer.impl.dao.pret;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.pret.PretDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.pret.PretRM;
import fr.openclassrooms.projet_6.model.pret.Pret;

/**
 * <p>Implémentation de l'interface PretDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see PretDao
 * @see DaoFactory#getPretDao()
 * @see DaoFactory#setPretDao(PretDao)
 * @see DaoFactoryImpl#getPretDao()
 * @see DaoFactoryImpl#setPretDao(PretDao)
 * @see Pret
 * @see RowMapper
 * @see PretRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
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
}
