package fr.openclassrooms.projet_6.business.impl.manager.communication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.contract.manager.communication.CommentaireTopoManager;
import fr.openclassrooms.projet_6.business.impl.manager.AbstractManager;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.model.communication.CommentaireTopo;
import fr.openclassrooms.projet_6.model.communication.Message;



/**
 * <p>Implémentation de l'interface 'CommentaireTopoManager'</p>
 * <p>Dédié au traitement métier de la classe 'CommentaireTopo'</p>
 * 
 * @see CommentaireTopoManager#getList(String)
 * @see CommentaireTopoManager#addComment(int, String, String)
 * @see CommentaireTopoManagerImpl#getList(String)
 * @see CommentaireTopoManagerImpl#addComment(int, String, String)
 * @see ManagerFactory#getCommentaireTopoManager()
 * @see ManagerFactory#setCommentaireTopoManager(CommentaireTopoManager)
 * @see ManagerFactoryImpl#getCommentaireTopoManager()
 * @see ManagerFactoryImpl#setCommentaireTopoManager(CommentaireTopoManager)
 * @see CommentaireTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public class CommentaireTopoManagerImpl extends AbstractManager implements CommentaireTopoManager {

	
	
	/**
	 * @see CommentaireTopoManager#getList(String)
	 * @see CommentaireTopo
	 * @see Message
	 */
	@Override
	public List<CommentaireTopo> getList(String idTopo) throws Exception {

		List<CommentaireTopo> listCommentaireTopo = null;
		
		if(idTopo != null && !idTopo.isEmpty()) {
			
			List<Integer> listIdsMessage = this.getDaoFactory().getCommentaireTopoDao().getIdsComment(idTopo);
			listCommentaireTopo = new ArrayList<CommentaireTopo>();
			
			for(int idMessage : listIdsMessage) {
				
				Message message = this.getDaoFactory().getMessageDao().getMessage(idMessage);

				CommentaireTopo commentaireTopo = new CommentaireTopo(idMessage, message.getDate(), message.getContenu(), 
													this.getDaoFactory().getUtilisateurDao().getUtilisateur(message.getAuteur().getIdUtilisateur()), 
																											this.getDaoFactory().getTopoDao().getTopo(idTopo));
				
				listCommentaireTopo.add(commentaireTopo);
			}
		}
		return listCommentaireTopo;
	}

	
	
	/**
	 * @see CommentaireTopoManager#addComment(int, String, String)
	 * @see CommentaireTopoManagerImpl#contenuValidation(String)
	 * @see CommentaireTopo
	 * @see Message
	 */
	@Override
	public boolean addComment(int idUtilisateur, String idTopo, String contenu) throws Exception  {

		Boolean vResult = false;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
																&& idTopo != null && !idTopo.isEmpty() 
																&& contenu != null && this.contenuValidation(contenu)) {
						
			Timestamp date = new Timestamp(new Date().getTime());			
			
			if(this.getDaoFactory().getMessageDao().addMessage(idUtilisateur, contenu, date)) {
					int idNewMessage = Integer.valueOf(this.getDaoFactory().getMessageDao().getIdMessage(idUtilisateur, date));
					
				if(this.getDaoFactory().getCommentaireTopoDao().addComment(idNewMessage, idTopo)) {
					vResult = true;
				}
			}
		}
		return vResult;
	}
	
	
	
	/**
	 * <p>Permet d'effectuer une validation du commentaire</p>
	 * 
	 * @param contenu Le contenu du commentaire
	 * @return Un boolean informant dur le resultat de l'opération
	 * 
	 * @see CommentaireTopoManagerImpl#addComment(int, String, String)
	 */
	public Boolean contenuValidation(String contenu) {
		
		int longueurMin = 25, longueurMax = 500;
		
		Boolean vReturn = false;
		
		
		if(contenu.length() >= longueurMin && contenu.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}

}
