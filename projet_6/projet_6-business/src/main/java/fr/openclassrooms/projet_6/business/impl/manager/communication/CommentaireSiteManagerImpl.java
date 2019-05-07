package fr.openclassrooms.projet_6.business.impl.manager.communication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireSiteManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.consumer.contract.dao.DaoFactory;
import fr.openclassrooms.projet_6.consumer.impl.dao.DaoFactoryImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireSite;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Implémentation de l'interface 'CommentaireSiteManager'</p>
 * <p>Dédié au traitement métier de la classe 'CommentaireSite'</p>
 * 
 * 
 * @see CommentaireSiteManagerImpl#MIN_CONTENU
 * @see CommentaireSiteManagerImpl#MAX_CONTENU
 * @see CommentaireSiteManagerImpl#getList(String)
 * @see CommentaireSiteManagerImpl#addComment(int, String, String)
 * @see CommentaireSiteManagerImpl#validation(String, int, int)
 * @see CommentaireSiteManager#getList(String)
 * @see CommentaireSiteManager#addComment(int, String, String)
 * @see ManagerFactory#getCommentaireSiteManager()
 * @see ManagerFactory#setCommentaireSiteManager(CommentaireSiteManager)
 * @see ManagerFactoryImpl#getCommentaireSiteManager()
 * @see ManagerFactoryImpl#setCommentaireSiteManager(CommentaireSiteManager)
 * @see CommentaireSite
 * @see DaoFactory
 * @see DaoFactoryImpl
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireSiteManagerImpl extends AbstractManager implements CommentaireSiteManager {
	
	
	
	/**
	 * <p>Contrainte de taille minimale pour le paramètre 'contenu'</p>
	 * 
	 * @see CommentaireSiteManagerImpl#contenu
	 * @see CommentaireSiteManagerImpl#validation(String, int, int)
	 */
	private final int MIN_CONTENU = 25;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'contenu'</p>
	 * 
	 * @see CommentaireSiteManagerImpl#contenu
	 * @see CommentaireSiteManagerImpl#validation(String, int, int)
	 */
	private final int MAX_CONTENU = 500;
	
	
	/**
	 * @see CommentaireSiteManager#getList(String)
	 * @see CommentaireSite
	 * @see Message
	 */
	@Override
	public List<CommentaireSite> getList(String idSite) throws Exception {

		List<CommentaireSite> listCommentaireSite = null;
		
		if(idSite != null && !idSite.isEmpty()) {
			
			List<Integer> listIdsMessage = this.getDaoFactory().getCommentaireSiteDao().getIdsComment(idSite);
			listCommentaireSite = new ArrayList<CommentaireSite>();
			
			for(int idMessage : listIdsMessage) {
				
				Message message = this.getDaoFactory().getMessageDao().getMessage(idMessage);

				CommentaireSite commentaireSite = new CommentaireSite(idMessage, message.getDate(), message.getContenu(), 
													this.getDaoFactory().getUtilisateurDao().getUtilisateur(message.getAuteur().getIdUtilisateur()), 
																											this.getDaoFactory().getSiteDao().getSite(Integer.valueOf(idSite)));
				
				listCommentaireSite.add(commentaireSite);
			}
		}
		return listCommentaireSite;
	}
	
	
	
	/**
	 * @see CommentaireSiteManager#addComment(int, String, String)
	 * @see CommentaireSiteManagerImpl#validation(String, int, int)
	 * @see CommentaireSite
	 * @see Message
	 */
	@Override
	public boolean addComment(int idUtilisateur, String idSite, String contenu) throws Exception  {

		Boolean vResult = false;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
																&& idSite != null && !idSite.isEmpty() 
																&& contenu != null && this.validation(contenu, MIN_CONTENU, MAX_CONTENU)) {
						
			Timestamp date = new Timestamp(new Date().getTime());			
			
			if(this.getDaoFactory().getMessageDao().addMessage(idUtilisateur, contenu, date)) {
					int idNewMessage = Integer.valueOf(this.getDaoFactory().getMessageDao().getIdMessage(idUtilisateur, date));
					
				if(this.getDaoFactory().getCommentaireSiteDao().addComment(idNewMessage, idSite)) {
					vResult = true;
				}
			}
		}
		return vResult;
	}
	
	
	
	/**
	 * <p>Méthode servant à vérifier les inputs<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs</li>
	 * 		<li>La taille maximal du champs (lié à l'espace alloué en BDD)</li>
	 * </ul>
	 * 
	 * @param input  L'entrée à valider
	 * @param longueurMin La longueur minimale du chammps
	 * @param longueurMax La longueur maximale du champs
	 * @return Retourne le résultat de la validation => validée (=true) / refusée (=false)
	 * 
	 * @see CommentaireSiteManagerImpl#addComment(int, String, String)
	 * @see CommentaireSiteManagerImpl#MIN_CONTENU
	 * @see CommentaireSiteManagerImpl#MAX_CONTENU
	 */
	public Boolean validation(String input, int longueurMin, int longueurMax) {
				
		Boolean vReturn = false;
		
		
		if(input.length() >= longueurMin && input.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}
}
