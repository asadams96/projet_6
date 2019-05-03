package fr.openclassrooms.projet_6.business.contract.manager.liaison;

import java.util.List;

import fr.openclassrooms.projet_6.business.contract.manager.ManagerFactory;
import fr.openclassrooms.projet_6.business.impl.manager.ManagerFactoryImpl;
import fr.openclassrooms.projet_6.business.impl.manager.liaison.TamponProprietaireTopoManagerImpl;
import fr.openclassrooms.projet_6.model.liaison.TamponProprietaireTopo;



/**
 * <p>Interface de la couche manager</p>
 * <p>Dédié au traitement métier de la classe 'TamponProprietaireTopo'</p>
 * 
 * 
 * @see TamponProprietaireTopoManager#getBibliotheque(int)
 * @see TamponProprietaireTopoManager#addTampon(int, String, int)
 * @see TamponProprietaireTopoManager#removeTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int)
 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
 * @see ManagerFactory#getTamponProprietaireTopoManager()
 * @see ManagerFactory#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 * @see ManagerFactoryImpl#getTamponProprietaireTopoManager()
 * @see ManagerFactoryImpl#setTamponProprietaireTopoManager(TamponProprietaireTopoManager)
 * @see TamponProprietaireTopo
 * 
 * @version 1.0
 * @author Ayrton De Abreu Miranda
 *
 */
public interface TamponProprietaireTopoManager {

	
	
	/**
	 * <p>Récupère la bibliothèque de l'utilisateur en paramètre de méthode</p>
	 * 
	 * @param idUtilisateur L'identifiant d'un utilisateur
	 * @return Une liste d'instance de la classe 'TamponProprietaireTopo'
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#getBibliotheque(int)
	 * @see TamponProprietaireTopo
	 */
	List<TamponProprietaireTopo> getBibliotheque(int idUtilisateur) throws Exception;

	
	/**
	 * <p>
	 * 	Apres plusieurs étapes de validation =>
	 * 	Demande l'ajout, à la couche du dessous, d'un topo 
	 * 	en x quantité dans la bibliothèque de l'utilisateur.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantité désiré
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#addTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	Boolean addTampon(int idUtilisateur, String idTopo, int quantite) throws Exception;

	
	/**
	 * <p>
	 * 	Apres plusieurs étapes de validation =>
	 * 	Demande la suppression, à la couche du dessous, d'un topo 
	 * 	en x quantité dans la bibliothèque de l'utilisateur.
	 * </p>
	 * 
	 * @param idUtilisateur L'identifiant de l'utilisateur concerné
	 * @param idTopo L'identifiant du topo concerné
	 * @param quantite La quantité désiré
	 * @return Un boolean informant sur le résultat de l'opération
	 * @throws Exception Si une exception est levé, elle est remonté dans la couche du dessus
	 * 
	 * @see TamponProprietaireTopoManagerImpl#removeTampon(int, String, int)
	 * @see TamponProprietaireTopo
	 */
	boolean removeTampon(int idUtilisateur, String idTopo, int quantite) throws Exception;

}
