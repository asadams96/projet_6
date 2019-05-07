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
 * @see CommentaireTopoManage#MIN_CONTENU
 * @see CommentaireTopoManage#MAX_CONTENU
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
	 * <p>Contrainte de taille minimale pour le paramètre 'contenu'</p>
	 * 
	 * @see CommentaireTopoManagerImpl#contenu
	 * @see CommentaireTopoManagerImpl#validation(String, int, int)
	 */
	private final int MIN_CONTENU = 25;
	
	
	
	/**
	 * <p>Contrainte de taille maximale pour le paramètre 'contenu'</p>
	 * 
	 * @see CommentaireTopoManagerImpl#contenu
	 * @see CommentaireTopoManagerImpl#validation(String, int, int)
	 */
	private final int MAX_CONTENU = 500;
	
	
	
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
	 * @see CommentaireTopoManagerImpl#contenuValidation(String, int, int)
	 * @see CommentaireTopo
	 * @see Message
	 */
	@Override
	public boolean addComment(int idUtilisateur, String idTopo, String contenu) throws Exception  {

		Boolean vResult = false;
		
		if(String.valueOf(idUtilisateur) != null && !String.valueOf(idUtilisateur).isEmpty() 
																&& idTopo != null && !idTopo.isEmpty() 
																&& contenu != null && this.validation(contenu, MIN_CONTENU, MAX_CONTENU)) {
						
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
	 * <p>Méthode servant à vérifier les inputs<p>
	 * 
	 * <p>Il y a deux critères de validation :<p>
	 * <ul>
	 * 		<li>La taille minimal du champs</li>
	 * 		<li>La taille maximal du champs (lié à l'espace alloué en BDD)</li>
	 * </ul>
	 * 
	 * @param input L'entrée à valider
	 * @param longueurMin La longueur minimale du chammps
	 * @param longueurMax La longueur maximale du champs
	 * @return Retourne le résultat de la validation => validée (=true) / refusée (=false)
	 * 
	 * @see CommentaireTopoManagerImpl#addComment(int, String, String)
	 * @see CommentaireTopoManagerImpl#MIN_CONTENU
	 * @see CommentaireTopoManagerImpl#MAX_CONTENU
	 */
	public Boolean validation(String input, int longueurMin, int longueurMax) {
				
		Boolean vReturn = false;
		
		
		if(input.length() >= longueurMin && input.length() <= longueurMax) {
			vReturn = true;
		}
		
		return vReturn;
	}

}
