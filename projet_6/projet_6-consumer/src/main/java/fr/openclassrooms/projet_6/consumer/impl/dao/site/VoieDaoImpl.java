package fr.openclassrooms.projet_6.consumer.impl.dao.site;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.site.VoieDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.site.VoieRM;
import fr.openclassrooms.projet_6.model.site.Secteur;
import fr.openclassrooms.projet_6.model.site.Voie;

/**
 * <p>Implémentation de l'interface VoieDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 *
 * @see VoieDao
 * @see DaoFactory#getVoieDao()
 * @see DaoFactory#setVoieDao(VoieDao)
 * @see DaoFactoryImpl#getVoieDao()
 * @see DaoFactoryImpl#setVoieDao(VoieDao)
 * @see Voie
 * @see Secteur
 * @see Voie
 * @see RowMapper
 * @see VoieRM
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class VoieDaoImpl extends AbstractDao implements VoieDao {

	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe Voie suite à une lecture 
	 * 	de ligne complète de la table public.voie en base de donnée
	 * </p>
	 * 
	 * @see RowMapper
	 * @see Voie
	 * @see VoieDaoImpl#setRowMapper(RowMapper)
	 * @see VoieRM
	 */
	private RowMapper<Voie> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see Voie
	 * @see VoieDaoImpl#rowMapper
	 * @see VoieRM
	 */
	public void setRowMapper(RowMapper<Voie> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
