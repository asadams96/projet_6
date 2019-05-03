package fr.openclassrooms.projet_6.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireSiteDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.CommentaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessageDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.communication.MessagePretDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponProprietaireTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.liaison.TamponSiteTopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.topo.TopoDaoImpl;
import fr.openclassrooms.projet_6.consumer.impl.dao.utilisateur.UtilisateurDaoImpl;



/**
 * <p>Classe mère de toutes les classes Dao implémenté (sauf la Factory)</p>
 * <p>Permet de partager la connexion à la base de donnée pour effectuer des interactions</p>
 * 
 * @see AbstractDao#jdbcTemplate
 * @see AbstractDao#getJdbcTemplate()
 * @see AbstractDao#setJdbcTemplate(NamedParameterJdbcTemplate)
 * @see NamedParameterJdbcTemplate
 * @see UtilisateurDaoImpl
 * @see TopoDaoImpl
 * @see VoieDaoImpl
 * @see SecteurDaoImpl
 * @see SiteDaoImpl
 * @see PretDaoImpl
 * @see TamponProprietaireTopoDaoImpl
 * @see TamponSiteTopoDaoImpl
 * @see MessagePretDaoImpl
 * @see MessageDaoImpl
 * @see CommentaireTopoDaoImpl
 * @see CommentaireSiteDaoImpl
 * @see DaoFactory
 * @see DaoFactoryImpl
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public abstract class AbstractDao {

	
	
	/**
	 * <p>Représente l'instance de la classe 'NamedParameterJdbcTemplate'
	 * 
	 * @see AbstractDao#getJdbcTemplate()
	 * @see AbstractDao#setJdbcTemplate(NamedParameterJdbcTemplate)
	 * @see NamedParameterJdbcTemplate
	 */
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	/**
	 * <p>
	 * 	Getter permettant à tous les enfants de la classe AbstractDao 
	 * (tout les Dao) d'avoir accès à une instance de la classe 'NamedParameterJdbcTemplate'
	 * </p>
	 * 
	 * @return Une instance de la classe 'NamedParameterJdbcTemplate'
	 * 
	 * @see AbstractDao#jdbcTemplate
	 * @see AbstractDao#setJdbcTemplate(NamedParameterJdbcTemplate)
	 * @see NamedParameterJdbcTemplate
	 */
	protected NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	/**
	 * <p>
	 * 	Setter utilisé par Spring pour définir une instance de
	 * 	la classe 'NamedParameterJdbcTemplate'
	 * </p>
	 * 
	 * @param jdbcTemplate Nouvelle instance de 'NamedParameterJdbcTemplate'
	 * 
	 * @see AbstractDao#jdbcTemplate
	 * @see AbstractDao#getJdbcTemplate()
	 * @see NamedParameterJdbcTemplate
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
