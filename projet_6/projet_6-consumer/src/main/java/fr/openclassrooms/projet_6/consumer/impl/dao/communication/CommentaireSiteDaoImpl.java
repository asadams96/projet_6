package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireSiteDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.CommentaireSiteRM;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;

/**
 * <p>Implémentation de l'interface CommentaireSiteDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see CommentaireSiteDao
 * @see DaoFactory#getCommentaireSiteDao()
 * @see DaoFactory#setCommentaireSiteDao(CommentaireSiteDao)
 * @see DaoFactoryImpl#getCommentaireSiteDao()
 * @see DaoFactoryImpl#setCommentaireSiteDao(CommentaireSiteDao)
 * @see CommentaireSite
 * @see Message
 * @see RowMapper
 * @see CommentaireSiteRM
 * @see AbstractDao
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 */
public class CommentaireSiteDaoImpl extends AbstractDao implements CommentaireSiteDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe CommentaireSite suite à une lecture 
	 * 	de ligne complète de la table public.commentaire_site en base de donnée
	 * </p>
	 * 	ICI
	 * @see RowMapper
	 * @see CommentaireSite
	 * @see CommentaireSiteDaoImpl#setRowMapper(RowMapper)
	 * @see CommentaireSiteRM 
	 */
	private RowMapper<Map<String, Integer>> rowMapper;

	
	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see CommentaireSite
	 * @see CommentaireSiteDaoImpl#rowMapper
	 * @see CommentaireSiteRM
	 */
	public void setRowMapper(RowMapper<Map<String, Integer>> rowMapper) {
		this.rowMapper = rowMapper;
	}
}
