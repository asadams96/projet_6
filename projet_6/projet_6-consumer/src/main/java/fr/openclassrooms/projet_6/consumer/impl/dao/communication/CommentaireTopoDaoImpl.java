package fr.openclassrooms.projet_6.consumer.impl.dao.communication;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.contract.dao.communication.CommentaireTopoDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.AbstractDao;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.consumer.impl.rowmapper.communication.CommentaireTopoRM;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;


/**
 * <p>Implémentation de l'interface CommentaireTopoDao</p>
 * <p>Effectue les actions qui lui sont destinés en interagissant avec une base de donnée</p>
 * 
 * @see CommentaireTopoDao#getIdsComment(String)
 * @see CommentaireTopoDao#addComment(int, String)
 * @see CommentaireTopoDaoImpl#getIdsComment(String)
 * @see CommentaireTopoDaoImpl#addComment(int, String)
 * @see DaoFactory#getCommentaireTopoDao()
 * @see DaoFactory#setCommentaireTopoDao(CommentaireTopoDao)
 * @see DaoFactoryImpl#getCommentaireTopoDao()
 * @see DaoFactoryImpl#setCommentaireTopoDao(CommentaireTopoDao)
 * @see CommentaireTopo
 * @see Message
 * @see RowMapper
 * @see CommentaireTopoRM
 * @see AbstractDao
 * @see NamedParameterJdbcTemplate
 * 
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireTopoDaoImpl extends AbstractDao implements CommentaireTopoDao {
	
	
	
	/**
	 * <p>
	 * 	Construit une instance de la classe CommentaireTopo suite à une lecture 
	 * 	de ligne complète de la table public.commentaire_topo en base de donnée
	 * </p>
	 * 	
	 * @see RowMapper
	 * @see CommentaireTopo
	 * @see CommentaireTopoDaoImpl#setRowMapper(RowMapper)
	 * @see CommentaireTopoRM
	 */
	private RowMapper<Map<String, Integer>> rowMapper;

	
	/**
	 * <p>Setter du paramètre 'rowMapper' utilisé par spring lors de l'injection</p>
	 * 
	 * @param rowMapper L'instance du RowMapper injecté
	 * 
	 * @see RowMapper
	 * @see CommentaireTopo
	 * @see CommentaireTopoDaoImpl#rowMapper
	 * @see CommentaireTopoRM
	 */
	public void setRowMapper(RowMapper<Map<String, Integer>> rowMapper) {
		this.rowMapper = rowMapper;
	}

	
	
	/**
	 * @see CommentaireTopoDao#getIdsComment(String)
	 * @see CommentaireTopo
	 */
	@Override
	public List<Integer> getIdsComment(String idTopo) throws Exception {
		
		List<Integer> listIdsComment = null;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			
			String sql = "SELECT id_message FROM public.commentaire_topo WHERE id_topo = :id_topo";
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("id_topo", idTopo, Types.INTEGER);
			
			listIdsComment = this.getJdbcTemplate().queryForList(sql, map, Integer.class);
			
		}
		
		return listIdsComment;
	}

	
	/**
	 * @see CommentaireTopoDao#addComment(int, String)
	 * @see CommentaireTopo
	 */
	@Override
	public boolean addComment(int idNewMessage, String idTopo) throws Exception {
		
		Boolean vResult = false;
		
			if(String.valueOf(idNewMessage) != null && !String.valueOf(idNewMessage).isEmpty() 
																	&& idTopo != null && !idTopo.isEmpty()) {
				
				String sql = "INSERT INTO public.commentaire_topo (id_message, id_topo) "
								+ "VALUES (:id_message, :id_topo)";
				
				MapSqlParameterSource map = new MapSqlParameterSource();
				map.addValue("id_message", idNewMessage, Types.INTEGER);
				map.addValue("id_topo", idTopo, Types.INTEGER);
				
				this.getJdbcTemplate().update(sql, map);
				vResult = true;
			}
		
		return vResult;
	}
}
